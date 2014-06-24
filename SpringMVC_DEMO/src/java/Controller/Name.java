

package Controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

@Controller
public class Name extends HttpServlet {

   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
    request.setAttribute("servletName", "servletToJsp");
    
    
    
        String s= request.getParameter("name");
                
        Model.NameModel mybean=new Model.NameModel();
        mybean.setName(s);
          
        HttpSession session=request.getSession();
        session.setAttribute("mybean", mybean);
        response.sendRedirect("mypage.jsp");

}
}
  


