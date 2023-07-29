package lk.ijse.gdse63.shaili.assignment1.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "filter",urlPatterns = {"/*"})
public class Dofilter extends HttpFilter {
    public Dofilter() {
        System.out.println("Object created for DoFilter.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DoFilter.init");
    }


    /*public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DoFilter.doFilter");
        *//*Since we cannot access HttpServlet methods from ServletRequest and ServletResponse
         * we can case those references to their subtype.Which is HttpServletRequest and
         * HttpServletResponse.*//*
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "Content-Type");

        //In order to send the request to the relevant servlet, we need to call filterChain.doFilter() method.
        //If not , the request will not be sent to the relevant servlet..
        filterChain.doFilter(servletRequest, servletResponse);


    }*/

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.setHeader("Access-Control-Allow-Origin", req.getParameter("Origin"));
        res.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        res.setHeader("Access-Control-Expose-Headers", "Content-Type");
        chain.doFilter(req,res);
    }

    @Override
    public void destroy() {
        System.out.println("DoFilter.destroy");
    }
}
