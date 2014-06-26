

package controller;

import java.net.BindException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.HelloService;




public class HelloController extends SimpleFormController {
    
    private   HelloService helloService;
    
    public void setHelloService(HelloService helloService) 
    {
    this.helloService = helloService;
    }
    public HelloController()
    {
        this.helloService = new HelloService();
    setCommandClass(Name.class);
    setCommandName("name");
    setSuccessView("helloView");
    setFormView("nameView");
    
   }    
   
protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception
{
        Name name = (Name) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        String s= helloService.sayHello(name.getValue());
        mv.addObject("message",s );
        return mv;

	}
}

