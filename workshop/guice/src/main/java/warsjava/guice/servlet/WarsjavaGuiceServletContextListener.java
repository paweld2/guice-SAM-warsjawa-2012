package warsjava.guice.servlet;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class WarsjavaGuiceServletContextListener extends GuiceServletContextListener {

	// TODO setup web.xml configuration
	// TODO setup servlet configuration
	@Override
	protected Injector getInjector() {
		return null;
	}

}
