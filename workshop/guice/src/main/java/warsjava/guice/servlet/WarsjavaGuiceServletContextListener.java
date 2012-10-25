package warsjava.guice.servlet;

import warsjava.guice.contract.ModelEnvironment;
import warsjava.guice.modules.EnvironmentModule;
import warsjava.guice.modules.ModelModule;
import warsjava.guice.modules.TaskModelModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.util.Modules;

public class WarsjavaGuiceServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		ModelEnvironment testEnvironment = new ModelEnvironment("servlet");
		Module allModel = Modules.combine(new ModelModule(),new TaskModelModule(), new EnvironmentModule(testEnvironment));
		return Guice.createInjector(Modules.combine(allModel, new WarsjavaServletConfigurationModule()));
	}

}
