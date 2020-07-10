package web.servlet;

import domain.Person;
import service.impl.PersonServiceImpl;

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
@WebServlet("/queryPerson")
public class QueryPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String accnum = request.getParameter("accnum");
        String message = null;
        HttpSession session = request.getSession();
        session.removeAttribute("person");

        String referer = request.getHeader("referer");
        String redirectUri = null;
        if (referer != null) {
            if (referer.contains("/personupdate.jsp")) {
                redirectUri = "personupdate.jsp";
            } else if (referer.contains("/persondelete.jsp")) {
                redirectUri = "persondelete.jsp";
            } else {
                redirectUri = "index.jsp";
            }
        } else {
            redirectUri = "index.jsp";
        }


        PersonServiceImpl ps = new PersonServiceImpl();
        Person person = ps.queryByAccNum(accnum);
        if (person != null) {
            message = "查询成功";
            session.setAttribute("person", person);
        } else {
            message = "该账号不存在";
        }
        response.sendRedirect(redirectUri + "?message=" + URLEncoder.encode(message, "utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
