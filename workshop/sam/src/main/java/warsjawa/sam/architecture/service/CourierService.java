package warsjawa.sam.architecture.service;

import pmsoft.sam.definition.service.AbstractSamServiceDefinition;
import warsjawa.sam.architecture.contract.courier.CourierServiceContract;

public class CourierService extends AbstractSamServiceDefinition {

	@Override
	public void loadServiceDefinition() {
		// This interfaces are not exposed
//		addInterface(CourierServiceOrder.class);
//		addInterface(CourierAddressSetupInfo.class);
		addInterface(CourierServiceContract.class);
	}

}
