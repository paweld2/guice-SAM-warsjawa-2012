package warsjava.guice.modules;

import warsjava.guice.contract.ModelEnvironment;

import com.google.inject.AbstractModule;

public class EnvironmentModule extends AbstractModule {

	private final ModelEnvironment environment;

	public EnvironmentModule(ModelEnvironment environment) {
		this.environment = environment;
	}

	@Override
	protected void configure() {
		binder().requireExplicitBindings();
		bind(ModelEnvironment.class).toInstance(environment);
	}

}
