package warsjawa.sam.architecture.service;

import pmsoft.sam.definition.service.AbstractSamServiceDefinition;
import warsjawa.sam.architecture.contract.store.StoreOrder;
import warsjawa.sam.architecture.contract.store.StoreServiceContract;

public class StoreService extends AbstractSamServiceDefinition {

	@Override
	public void loadServiceDefinition() {
		addInterface(StoreServiceContract.class);
		addInterface(StoreOrder.class);
	}

}
