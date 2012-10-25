package warsjava.guice.servlet;

import com.google.inject.servlet.ServletModule;

public class WarsjavaServletConfigurationModule extends ServletModule {
	
	@Override
	protected void configureServlets() {
		serve("*").with(ModelAccessServlet.class);
	}

}
