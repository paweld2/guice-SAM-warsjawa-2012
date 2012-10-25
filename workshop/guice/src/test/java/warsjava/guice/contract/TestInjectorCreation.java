package warsjava.guice.contract;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import warsjava.guice.domain.Task;
import warsjava.guice.domain.TaskObserver;
import warsjava.guice.modules.EnvironmentModule;
import warsjava.guice.modules.ModelModule;
import warsjava.guice.modules.TaskModelModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class TestInjectorCreation {

	private Injector createModelInjector() {
		return Guice.createInjector(new ModelModule());
	}
	
	@Test
	public void testModelInjectorCreation(){
		Injector injector = createModelInjector();
		assertNotNull(injector);
		assertNotNull(injector.getExistingBinding(Key.get(LoggingContract.class)));
		assertTrue(injector.getExistingBinding(Key.get(LoggingContract.class, Names.named("notExistingBinding"))) == null);
	}
	
	private Injector createExtendedModelInjector(){
		return Guice.createInjector(new ModelModule(),new TaskModelModule());
	}
	
	@Test
	public void testExtendedModelInjectorCreation(){
		// Don't change the definition of module ModelModule
		Injector injector = createExtendedModelInjector();
		assertNotNull(injector);
		assertNotNull(injector.getExistingBinding(Key.get(LoggingContract.class)));
		assertNotNull(injector.getExistingBinding(Key.get(TaskObserver.class)));
		Task task = createTask(injector);
		TaskObserver observer = createObserver(injector);
		assertTrue(observer.observeTask(task));
	}

	private TaskObserver createObserver(Injector injector) {
		return injector.getInstance(TaskObserver.class);
	}

	private Task createTask(Injector injector) {
		return injector.getInstance(Task.class);
	}

	@Test
	public void testExtendedModelInjectorDontProvideInternalApi(){
		Injector injector = createExtendedModelInjector();
		assertNotNull(injector);
		assertNotNull(injector.getExistingBinding(Key.get(LoggingContract.class)));
		assertNotNull(injector.getExistingBinding(Key.get(TaskObserver.class)));
		assertTrue(injector.getExistingBinding(Key.get(InternalModelAPI.class))==null);
		Task task = createTask(injector);
		TaskObserver observer = createObserver(injector);
		assertTrue(observer.checkTask(task));
	}
	
	@Test
	public void testExtendedModelInjectorEnvironment(){
//		Don't allow the use of the default constructor of ModelEnvironment
//		Bind this instance as a singleton to ModelEnvironment
		ModelEnvironment testEnvironment = new ModelEnvironment("test");
		Injector injector = Guice.createInjector(new ModelModule(),new TaskModelModule(), new EnvironmentModule(testEnvironment));
		assertNotNull(injector);
		ModelContract model = injector.getInstance(ModelContract.class);
		assertEquals("test", model.getEnvironmentName());
		assertTrue("test".compareTo(model.getEnvironmentName())==0);
	}
}
