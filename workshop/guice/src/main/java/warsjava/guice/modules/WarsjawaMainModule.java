package warsjava.guice.modules;

import com.google.inject.AbstractModule;

public class WarsjawaMainModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ViewModules());
		install(new PresenterModules());
		install(new DispatcherModules());
		install(new HandlerModules());
		install(new ServiceModules());
		install(new DAOModules());
		install(new ModelModules());
	}

}
