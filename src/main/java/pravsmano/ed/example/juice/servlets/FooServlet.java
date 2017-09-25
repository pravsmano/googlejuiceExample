package pravsmano.ed.example.juice.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pravsmano.ed.example.juice.NonServletInterface;

/**
 * Created by timmattison on 8/4/14.
 */
@Singleton
public class FooServlet extends HttpServlet {
  
    private final NonServletInterface nonServletInterface;

    @Inject
    public FooServlet(NonServletInterface nonServletInterface) {
        this.nonServletInterface = nonServletInterface;
    }
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	        response.setContentType("text/html");
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.getWriter().println("<h1>foo Servlet</h1>");
	        response.getWriter().println(this.nonServletInterface.printVal());
	        
	       response.getWriter().println("session=" + request.getSession(true).getId());
	    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do whatever you need to do with POSTs
    }

}
