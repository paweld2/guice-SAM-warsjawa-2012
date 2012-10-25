package warsjawa.sam.architecture.impl.store;

import warsjawa.sam.architecture.contract.store.StoreServiceContract;

import com.google.inject.AbstractModule;

public class MyStoreServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(StoreServiceContract.class).to(MyStoreServiceContract.class).asEagerSingleton();
	}

}
