package pravsmano.ed.example.juice.modules;

import com.google.inject.AbstractModule;

import pravsmano.ed.example.juice.NonServletImplementation;
import pravsmano.ed.example.juice.NonServletInterface;

public class NonServletModule extends AbstractModule {
	protected void configure() {
		bind(NonServletInterface.class).to(NonServletImplementation.class);
	}
}
