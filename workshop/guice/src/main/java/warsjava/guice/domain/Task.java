package warsjava.guice.domain;

public class Task {

	private final Integer taskNr;

	public Task(Integer taskNr) {
		this.taskNr = taskNr;
	}

	public Integer getTaskNr() {
		return taskNr;
	}

	public boolean executeTask() {
		return true;
	}
}
