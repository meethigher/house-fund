package top.meethigher.house.fund.web.filter;

import top.meethigher.house.fund.domain.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证
 * https://github.com/meethigher
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        /**
         * 若是登录相关资源，直接放行
         * 若否，判断是否登录
         * 已登录，放行
         * 未登录，转发
         */
        if (uri.contains("/login.jsp") || uri.contains("/error.html") || uri.contains("/module") || uri.contains("/css") || uri.contains("/js") || uri.contains("/checkcode") || uri.contains("/exit") || uri.contains("/login")) {
            chain.doFilter(request, resp);
        } else {
            //判断是否登录
            HttpSession session = request.getSession();
            ServletContext application = request.getServletContext();
            Admin admin = (Admin) session.getAttribute("admin");
            if (admin == null) {
                request.setAttribute("login_error", "您尚未登录");
                request.getRequestDispatcher("login.jsp").forward(request, resp);
            } else {
                String id = (String) application.getAttribute(admin.getUsername());
                if (!session.getId().equals(id)) {
                    request.setAttribute("login_error", "您的账号在其他地方登录");
                    request.getRequestDispatcher("login.jsp").forward(request, resp);
                } else {
                    chain.doFilter(request, resp);
                }
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
