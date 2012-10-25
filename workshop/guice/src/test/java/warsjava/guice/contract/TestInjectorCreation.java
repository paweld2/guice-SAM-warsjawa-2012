package warsjava.guice.contract;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class TestInjectorCreation {

	private Injector createModelInjector() {
		return null;
	}
	
	@Test
	public void testModelInjectorCreation(){
		Injector injector = createModelInjector();
		assertNotNull(injector);
		assertNotNull(injector.getExistingBinding(Key.get(LoggingContract.class)));
		assertTrue(injector.getExistingBinding(Key.get(LoggingContract.class, Names.named("notExistingBinding"))) == null);
	}
}
