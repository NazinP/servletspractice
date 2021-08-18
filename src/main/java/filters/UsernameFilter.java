package filters;

import javax.servlet.*;
import java.io.IOException;

public class UsernameFilter implements Filter {
    public static final String USER_TO_BAN = "UserToBan";
    private String userToBan;

    public void init(FilterConfig filterConfig) throws ServletException {
        userToBan = filterConfig.getInitParameter(USER_TO_BAN);
        System.out.println("UsernameFilter init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("userName");
        if(userToBan.equals(name)){
            servletResponse.getWriter()
                    .write("Ты не пройдёшь!");
            System.out.println("Filtered");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
