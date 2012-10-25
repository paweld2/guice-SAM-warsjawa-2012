package warsjava.guice.contract;

import warsjava.guice.domain.Task;

public interface InternalModelAPI {

	public boolean makeInternalRequest();

	public boolean validate(Task task);
	
}
