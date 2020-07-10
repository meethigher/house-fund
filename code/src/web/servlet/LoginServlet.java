package web.servlet;

import domain.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author https://github.com/meethigher
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        AdminService as = new AdminServiceImpl();
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        String code = (String) session.getAttribute("checkcode");
        //这是为了使验证码保持一次性使用
        session.removeAttribute("checkcode");

        //忽略大小写
        if (code != null && code.equalsIgnoreCase(checkcode)) {
            if (as.login(admin) != null) {
                admin.setLasttime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                admin.setAddr(request.getRemoteAddr());
                as.update(admin);
                session.setAttribute("admin", admin);
                //为了确保同时只能登录一个账号
                ServletContext sc = request.getServletContext();
                sc.setAttribute(username, session.getId());

                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("login_error", "用户名或者密码错误");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("cc_error", "验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
