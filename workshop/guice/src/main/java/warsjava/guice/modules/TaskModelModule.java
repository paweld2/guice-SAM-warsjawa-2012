package warsjava.guice.modules;

import warsjava.guice.contract.InternalModelAPI;
import warsjava.guice.domain.TaskObserver;
import warsjava.guice.implementations.InternalModelApiImplementation;
import warsjava.guice.implementations.TaskObserverImplementation;

import com.google.inject.PrivateModule;
import com.google.inject.Scopes;

public class TaskModelModule extends PrivateModule {

	@Override
	protected void configure() {
		bind(TaskObserver.class).to(TaskObserverImplementation.class).in(Scopes.SINGLETON);
		bind(InternalModelAPI.class).to(InternalModelApiImplementation.class);
		expose(TaskObserver.class);
	}

}
