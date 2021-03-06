package web.servlet;

import domain.Page;
import domain.Person;
import service.impl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author https://github.com/meethigher
 */
@WebServlet("/findPersonByPage")
public class FindPersonByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        PersonServiceImpl ps = new PersonServiceImpl();
        Page<Person> personByPage = ps.findPersonByPage(currentPage, rows);

        //分页的开始跟结束
        int visibility = 4;//设置分页中间显示的个数，4就表示中间有5个

        int totalPage = personByPage.getTotalPage();
        int current = personByPage.getCurrentPage();
        current = current > totalPage ? totalPage : current;
        current = current < 1 ? 1 : current;

        int begin = current - visibility / 2;
        int end = current + visibility / 2;
        /**
         * 如果页数多于visibility，则按visibility正常显示
         * 如果页数少用visibility，则按实际情况展示
         */
        if (totalPage > visibility) {
            begin = begin < 1 ? 1 : begin;
            end = begin + visibility;
            end = end > totalPage ? totalPage : end;
            begin = end - visibility;

        } else {
            begin = begin < 1 ? 1 : begin;
            end = end > totalPage ? totalPage : end;
        }

        request.setAttribute("begin", begin);
        request.setAttribute("end", end);


        request.setAttribute("personByPage", personByPage);
        request.getRequestDispatcher("personquery.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
