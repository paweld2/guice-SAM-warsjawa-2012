package warsjava.guice.modules;

import warsjava.guice.domain.TaskObserver;
import warsjava.guice.implementations.TaskObserverImplementation;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class TaskModelModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TaskObserver.class).to(TaskObserverImplementation.class).in(Scopes.SINGLETON);
	}

}
