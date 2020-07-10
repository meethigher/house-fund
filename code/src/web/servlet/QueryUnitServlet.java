package web.servlet;

import domain.Unit;
import service.impl.UnitServiceImpl;

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
@WebServlet("/queryUnit")
public class QueryUnitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String unitaccnum = request.getParameter("unitaccnum");
        HttpSession session = request.getSession();
        session.removeAttribute("unit");
        String referer = request.getHeader("referer");
        String redirectUri = null;
        if (referer != null) {
            if (referer.contains("/person.jsp")) {
                redirectUri = "person.jsp";
            } else if (referer.contains("/unitupdate.jsp")) {
                redirectUri = "unitupdate.jsp";
            } else if (referer.contains("/unitdelete.jsp")) {
                redirectUri = "unitdelete.jsp";
            } else {
                redirectUri = "index.jsp";
            }
        } else {
            redirectUri = "index.jsp";
        }
        //查询数据
        UnitServiceImpl unitService = new UnitServiceImpl();
        Unit unit = unitService.findByAccNum(unitaccnum);
        String message = null;
        if (unit != null) {
            session.setAttribute("unit", unit);
            message = "查询到账号";

        } else {
            message = "该账号不存在";
        }
        response.sendRedirect(redirectUri + "?message=" + URLEncoder.encode(message, "utf-8"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
