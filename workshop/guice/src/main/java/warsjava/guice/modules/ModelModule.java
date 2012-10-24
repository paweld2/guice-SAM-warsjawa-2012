package warsjava.guice.modules;

import warsjava.guice.contract.LoggingContract;
import warsjava.guice.implementations.SimpleLogger;

import com.google.inject.AbstractModule;

public class ModelModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LoggingContract.class).to(SimpleLogger.class);
	}

}
