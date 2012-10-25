package warsjava.guice.contract;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import javax.inject.Singleton;

import org.testng.annotations.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class TestAssistetInjection {

	public static interface TaskService {

	}

	@Singleton
	public static class TaskServiceImpl implements TaskService {

	}

	public static class DomainServiceTask {

		final String name;
		final TaskService taskService;

		@Inject
		public DomainServiceTask(String name, TaskService taskService) {
			this.name = name;
			this.taskService = taskService;
		}
	}

	public static interface DomainServiceTaskFactory {

		public DomainServiceTask getTask(String name);

	}

	@Test
	public void testCreateAndBindImplementationOfDomainServiceTaskFactory() {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				// TODO create a implementation of DomainServiceTaskFactory and
				// bind as a factory
			}

		});
		DomainServiceTaskFactory factory = injector.getInstance(DomainServiceTaskFactory.class);
		DomainServiceTask task = factory.getTask("test name");
		assertNotNull(task);
		assertEquals("test name", task.name);
	}

	@Test
	public void testUserAssitedInjection() {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				// TODO use assisted injection
			}

		});
		DomainServiceTaskFactory factory = injector.getInstance(DomainServiceTaskFactory.class);
		DomainServiceTask task = factory.getTask("test name");
		assertNotNull(task);
		assertEquals("test name", task.name);
	}
}
