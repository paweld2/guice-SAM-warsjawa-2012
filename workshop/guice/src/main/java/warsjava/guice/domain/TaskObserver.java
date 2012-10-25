package warsjava.guice.domain;

public interface TaskObserver {

	public boolean observeTask(Task task);
	
	public boolean checkTask(Task task);
}
