package top.meethigher.house.fund.web.servlet;

import top.meethigher.house.fund.domain.Unit;
import top.meethigher.house.fund.service.impl.UnitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author https://github.com/meethigher
 */
@WebServlet("/deleteUnit")
public class DeleteUnitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Unit unit = (Unit) session.getAttribute("unit");
        String message = null;
        UnitServiceImpl us = new UnitServiceImpl();
        if (unit != null) {
            int close = us.close(unit.getUnitaccnum());
            if (close > 0) {
                message = "销户成功";
                session.removeAttribute("unit");
            } else if (close == -1) {
                message = "该单位下尚有员工，不可销户";
            } else {
                message = "请输入要删除账号，或者联系管理员meethigher@qq.com";
            }
        } else {
            message = "请输入你要删除的账号哦";
        }
        response.sendRedirect("unitdelete.jsp?message=" + URLEncoder.encode(message, "utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
