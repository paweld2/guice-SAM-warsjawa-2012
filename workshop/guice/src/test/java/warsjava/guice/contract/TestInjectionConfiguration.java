package warsjava.guice.contract;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import warsjava.guice.modules.ModelModule;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@Guice(modules = ModelModule.class)
public class TestInjectionConfiguration {

	@Inject
	public LoggingContract simpleLogger;

	@Test(groups = "test1")
	public void testSimpleLoggerBind() {
		assertNotNull(simpleLogger);
		assertEquals(simpleLogger.getLevel(), 0);
		simpleLogger.log("test pass");
	}
	
	@Inject @Named("level1")
	public LoggingContract namedLevel1;
	@Inject @Named("level2")
	public LoggingContract namedLevel2;

	@Test(groups = "test1")
	public void testNamedLoggerBind() {
		assertNotNull(namedLevel1);
		assertNotNull(namedLevel2);
		assertEquals(namedLevel1.getLevel(), 1);
		assertEquals(namedLevel2.getLevel(), 2);
		namedLevel1.log("test pass");
		namedLevel2.log("test pass");
	}
	
	
}
