package warsjava.guice.contract;

import warsjava.guice.domain.Task;

public interface ModelContract {

	public int getInstanceNr();
	
	public Task getNewTaskInstance();
	
	public boolean forbiddenMethod();
	
	public String getEnvironmentName();
}
