package warsjava.guice.implementations;

import warsjava.guice.domain.Task;
import warsjava.guice.domain.TaskObserver;

public class TaskObserverImplementation implements TaskObserver {

	@Override
	public boolean observeTask(Task task) {
		if(task == null) throw new RuntimeException("task is null");
		return true;
	}

}
