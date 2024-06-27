package myserv;

import java.io.*;
import javax.servlet.*;

public class MyFilter implements Filter {
    public void init(FilterConfig arg0) throws ServletException {
        // Initialization code if needed
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        String password = req.getParameter("password");
        if ("admin".equals(password)) {
            chain.doFilter(req, resp);
        } else {
            out.print("username or password error!");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
    }
    
    public void destroy() {
        // Cleanup code if needed
    }
}
