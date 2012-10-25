package warsjawa.sam.architecture.impl.contact;

import warsjawa.sam.architecture.contract.RealizePersonInteraction;

import com.google.inject.AbstractModule;

public class LocalContractPersonServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RealizePersonInteraction.class).to(MyRealizePersonInteraction.class);
	}

}
