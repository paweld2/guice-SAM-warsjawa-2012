package warsjava.guice.implementations;

import com.google.inject.Inject;

import warsjava.guice.contract.InternalModelAPI;
import warsjava.guice.domain.Task;
import warsjava.guice.domain.TaskObserver;

public class TaskObserverImplementation implements TaskObserver {

	private final InternalModelAPI internalApi;
	
	@Inject
	public TaskObserverImplementation(InternalModelAPI internalApi) {
		this.internalApi = internalApi;
	}


	@Override
	public boolean observeTask(Task task) {
		if(task == null) throw new RuntimeException("task is null");
		return true;
	}


	@Override
	public boolean checkTask(Task task) {
		if(internalApi == null) throw new RuntimeException("internalApi is null");
		return internalApi.validate(task);
	}

}
