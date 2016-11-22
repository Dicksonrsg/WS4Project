
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Soldier;

/**
 *
 * @author Dickson
 */
public class LoginFilter implements Filter {
    
    public LoginFilter() {
    }    

    @Override    
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
       Soldier soldier = null;
       HttpSession sess = ((HttpServletRequest) request).getSession(false);
        System.out.println("executor motherfucker");
       if(sess != null){
            soldier = (Soldier) sess.getAttribute("usuarioLogado");
            System.out.println(".-." + soldier.toString());
       }      

        if(soldier == null){
            System.out.println("WHAT THE FUCK");
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/guard/login.xhtml");
        }else{
              chain.doFilter(request, response);
             }
    }    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }   
}
