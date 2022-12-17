package top.meethigher.house.fund.web.servlet;

import top.meethigher.house.fund.domain.Admin;
import top.meethigher.house.fund.service.AdminService;
import top.meethigher.house.fund.service.impl.AdminServiceImpl;

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
@WebServlet("/updateAdmin")
public class UpdateAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //判断是否登录
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        //更新内容
        String newps = request.getParameter("newps");
        if (newps == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        admin.setPassword(newps);

        AdminService as = new AdminServiceImpl();
        int update = as.update(admin);
        String message = null;
        if (update > 0) {
            message = "修改成功";
            session.setAttribute("admin", admin);
        } else {
            message = "修改失败";
        }
        response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "utf-8"));

    }
}
