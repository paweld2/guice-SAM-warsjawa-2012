package warsjawa.sam.architecture.impl;

import pmsoft.sam.definition.implementation.AbstractSamImplementationPackage;
import warsjawa.sam.architecture.impl.contact.LocalContractPersonServiceModule;
import warsjawa.sam.architecture.impl.person.LocalPersonInfoServiceModule;
import warsjawa.sam.architecture.service.PersonContactService;
import warsjawa.sam.architecture.service.PersonInfoService;

public class WarsjawaServiceImplementations extends AbstractSamImplementationPackage {

	@Override
	public void implementationDefinition() {
		provideContract(PersonInfoService.class)
		.implementedInModule(LocalPersonInfoServiceModule.class);

		provideContract(PersonContactService.class)
		.withBindingsTo(PersonInfoService.class)
		.implementedInModule(LocalContractPersonServiceModule.class);
		
	}

}
