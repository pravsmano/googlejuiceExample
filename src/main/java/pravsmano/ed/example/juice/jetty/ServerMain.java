package pravsmano.ed.example.juice.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

import pravsmano.ed.example.juice.servlets.FooServlet;
import pravsmano.ed.example.juice.servlets.HelloServlet;

public class ServerMain {

	public static void main( String[] args ) throws Exception
    {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] { connector });

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(HelloServlet.class, "/hello");
        context.addServlet(FooServlet.class, "/foo");
        //context.addServlet(AsyncEchoServlet.class, "/echo/*");

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
