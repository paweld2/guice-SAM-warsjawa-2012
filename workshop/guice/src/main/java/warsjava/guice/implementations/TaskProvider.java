package warsjava.guice.implementations;

import java.util.concurrent.atomic.AtomicInteger;

import warsjava.guice.domain.Task;

import com.google.inject.Provider;

public class TaskProvider implements Provider<Task>{

	private final AtomicInteger counter = new AtomicInteger();
	
	@Override
	public Task get() {
		return new Task(counter.addAndGet(1));
	}

}
