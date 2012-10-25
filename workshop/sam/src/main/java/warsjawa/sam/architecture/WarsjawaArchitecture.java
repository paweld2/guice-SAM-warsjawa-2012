package warsjawa.sam.architecture;

import pmsoft.sam.architecture.definition.AbstractSamArchitectureDefinition;
import pmsoft.sam.architecture.definition.SamArchitectureLoader.SamCategoryLoader;
import warsjawa.sam.architecture.service.PersonContactService;
import warsjawa.sam.architecture.service.PersonInfoService;

public class WarsjawaArchitecture extends AbstractSamArchitectureDefinition {

	@Override
	protected void loadArchitectureDefinition() {
		SamCategoryLoader userCategory = createCategory("user");
		userCategory.withService(new PersonInfoService());
		userCategory.withService(new PersonContactService());
	}

}
