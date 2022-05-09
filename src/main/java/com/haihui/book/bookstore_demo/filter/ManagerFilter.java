package com.haihui.book.bookstore_demo.filter;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/8, 星期日
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        User user = (User) httpServletRequest.getSession().getAttribute("user");

        if (user == null){
            // Not logged in: go to log in page
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else {
            // Already log in, let go
            chain.doFilter(request,response);
        }
    }
}
