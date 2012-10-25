package warsjawa.sam.architecture.service;

import pmsoft.sam.definition.service.AbstractSamServiceDefinition;
import pmsoft.sam.definition.service.SamServiceDefinition;
import warsjawa.sam.architecture.contract.RealizePersonInteraction;

public class PersonContactService extends AbstractSamServiceDefinition implements SamServiceDefinition {

	@Override
	public void loadServiceDefinition() {
		addInterface(RealizePersonInteraction.class);
	}

}
