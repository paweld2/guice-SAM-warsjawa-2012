package warsjava.guice.implementations;

import warsjava.guice.contract.InternalModelAPI;
import warsjava.guice.domain.Task;

public class InternalModelApiImplementation implements InternalModelAPI {

	@Override
	public boolean makeInternalRequest() {
		return true;
	}

	@Override
	public boolean validate(Task task) {
		if( task == null) throw new RuntimeException("taks is null in internal api");
		return true;
	}

}
