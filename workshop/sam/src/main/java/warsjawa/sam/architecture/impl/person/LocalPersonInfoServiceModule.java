package warsjawa.sam.architecture.impl.person;

import warsjawa.sam.architecture.contract.PersonInfoContract;

import com.google.inject.AbstractModule;

public class LocalPersonInfoServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PersonInfoContract.class).to(MyPersonInfoContract.class).asEagerSingleton();
	}

}
