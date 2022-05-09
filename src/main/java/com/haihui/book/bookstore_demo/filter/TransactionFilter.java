package com.haihui.book.bookstore_demo.filter;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/9, 星期一
 * @version : 1.0
 **/

import com.haihui.book.bookstore_demo.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request,response);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollBackAndClose();
        }
    }

    @Override
    public void destroy() {

    }
}
