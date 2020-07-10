package web.servlet;


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
@WebServlet("/updateUnit")
public class UpdateUnitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Unit unitSession = (Unit) session.getAttribute("unit");
        String message = null;
        if (unitSession == null) {
            message = "您的单位信息不存在";
            response.sendRedirect("unitupdate.jsp?message=" + URLEncoder.encode(message, "utf-8"));
            return;
        }

        UnitServiceImpl us = new UnitServiceImpl();
        Unit unit = new Unit();

        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(unit, map);
            unit.setUnitaccnum(unitSession.getUnitaccnum());
            int update = us.update(unit);
            if (update > 0) {
                message = "修改成功";
                session.setAttribute("unit", unit);
            } else {
                message = "修改失败，请检查输入格式";
            }
            response.sendRedirect("unitupdate.jsp?message=" + URLEncoder.encode(message, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
