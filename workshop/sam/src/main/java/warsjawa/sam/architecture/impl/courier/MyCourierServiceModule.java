package warsjawa.sam.architecture.impl.courier;

import warsjawa.sam.architecture.contract.courier.CourierServiceContract;

import com.google.inject.AbstractModule;

public class MyCourierServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CourierServiceContract.class).to(MyCourierServiceContract.class).asEagerSingleton();
	}

}
