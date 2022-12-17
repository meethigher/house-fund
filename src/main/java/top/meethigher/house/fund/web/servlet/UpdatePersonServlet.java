package top.meethigher.house.fund.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import top.meethigher.house.fund.domain.Person;
import top.meethigher.house.fund.service.impl.PersonServiceImpl;

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
@WebServlet("/updatePerson")
public class UpdatePersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Person personSession = (Person) session.getAttribute("person");
        String message = null;
        if (personSession == null) {
            message = "您的信息不存在，请先进行查询";
            response.sendRedirect("personupdate.jsp?message=" + URLEncoder.encode(message, "utf-8"));
            return;
        }
        Person person = new Person();
        PersonServiceImpl ps = new PersonServiceImpl();

        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(person, map);
            personSession.setAccname(person.getAccname());
            personSession.setPapno(person.getPapno());
            personSession.setRemark(person.getRemark());
            int update = ps.update(personSession);
            if (update > 0) {
                message = "修改成功";
                session.setAttribute("person", personSession);
            } else {
                message = "修改失败";
            }
            response.sendRedirect("personupdate.jsp?message=" + URLEncoder.encode(message, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
