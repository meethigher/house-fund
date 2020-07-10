package web.servlet;

import domain.Admin;
import domain.Person;
import domain.Unit;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.PersonServiceImpl;

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
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String message = null;
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        Unit unit = (Unit) session.getAttribute("unit");
        if (unit == null) {
            message = "您的单位信息不存在";
            response.sendRedirect("person.jsp?message=" + URLEncoder.encode(message, "utf-8"));
            return;
        }
        //接收参数并注册
        Map<String, String[]> map = request.getParameterMap();
        Person person = new Person();

        //调用service自动生成账号
        PersonServiceImpl ps = new PersonServiceImpl();
        String seq = ps.getSeq();

        if (seq == null) {
            message = "开户失败，账号数量已达上限，请通知管理员meethigher@qq.com";
            response.sendRedirect("person.jsp?message=" + URLEncoder.encode(message, "utf-8"));
            return;
        }
        try {
            BeanUtils.populate(person, map);
            person.setAccnum(seq);
            person.setUnitaccnum(unit.getUnitaccnum());
            person.setOpendate(ps.getCurrentTime());
            /*
            单位月应缴额=缴存基数*单位比例
            个人月应缴额=缴存基数*个人比例
             */
            Double unitprop = unit.getUnitprop();
            Double perprop = unit.getPerprop();
            Double basenumber = person.getBasenumber();

            person.setUnitprop(unitprop);
            person.setPerprop(perprop);

            person.setUnitmonpaysum(basenumber * unitprop);
            person.setPermonpaysum(basenumber * perprop);

            person.setOp(admin.getUsername());

            int insert = ps.insert(person);
            /**
             * 备注：
             * 此处个人觉得用事务比较好，但是我个人对spring的事务处理不太熟悉，所以先不用了。
             * 以免越整越乱，有时间需要详细好好学习spring。
             * 这个算是个小bug、优化点
             */
            if (insert > 0 && ps.updatePersonSeq(Integer.parseInt(seq)) > 0) {
                message = "开户成功";
            } else {
                message = "开户失败，输入数据格式不正确或者身份证号重复";
            }
            response.sendRedirect("person.jsp?message=" + URLEncoder.encode(message, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
