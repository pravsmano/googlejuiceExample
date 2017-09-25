package pravsmano.ed.example.juice.jetty;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;

import pravsmano.ed.example.juice.modules.AppServletModule;
import pravsmano.ed.example.juice.modules.NonServletModule;

public class JuiceMain {

	public static void main(String args[]) throws Exception {
		System.out.println("testing...");
		NonServletModule nonServletModule = new NonServletModule();
		AppServletModule applicationServletModule = new AppServletModule();
		Guice.createInjector(nonServletModule, applicationServletModule);

		int port = 9040;
		Server server = new Server(port);

		ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/",ServletContextHandler.SESSIONS);
		servletContextHandler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));

		// You MUST add DefaultServlet or your server will always return 404s
		servletContextHandler.addServlet(DefaultServlet.class, "/");

		// Start the server
		server.start();

		// Wait until the server exits
		server.join();
	}

}
