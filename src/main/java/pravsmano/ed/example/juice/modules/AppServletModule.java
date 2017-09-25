package pravsmano.ed.example.juice.modules;

import com.google.inject.servlet.ServletModule;

import pravsmano.ed.example.juice.servlets.FooServlet;
import pravsmano.ed.example.juice.servlets.HelloServlet;

public class AppServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		bind(FooServlet.class);
		bind(HelloServlet.class);
		
		serve("/foo").with(FooServlet.class);
		serve("/hello").with(HelloServlet.class);
	}

}
