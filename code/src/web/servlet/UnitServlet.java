package web.servlet;

import domain.Admin;
import domain.Unit;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UnitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author https://github.com/meethigher
 */
@WebServlet("/unit")
public class UnitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        //接收参数并注册
        Map<String, String[]> map = request.getParameterMap();
        Unit unit = new Unit();

        //调用service自动生成账号
        UnitServiceImpl us = new UnitServiceImpl();
        String seq = us.getSeq();
        String message = null;
        if (seq == null) {
            message = "开户失败，账号数量已达上限，请通知管理员meethigher@qq.com";
            response.sendRedirect("unit.jsp?message=" + URLEncoder.encode(message, "utf-8"));
            return;
        }
        try {
            BeanUtils.populate(unit, map);
            unit.setCreatedate(us.getCurrentTime());
            unit.setUnitaccnum(seq);
            unit.setOp(admin.getUsername());
            int insert = us.insert(unit);
            /**
             * 备注：
             * 此处个人觉得用事务比较好，但是我个人对spring的事务处理不太熟悉，所以先不用了。
             * 以免越整越乱，有时间需要详细好好学习spring。
             * 这个算是个小bug、优化点
             */
            if (insert > 0 && us.updateUnitSeq(Integer.parseInt(seq)) > 0) {
                message = "开户成功";
            } else {
                message = "开户失败，输入格式错误或者单位已经存在";
            }
            response.sendRedirect("unit.jsp?message=" + URLEncoder.encode(message, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
