package warsjava.guice.contract;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import warsjava.guice.modules.ModelModule;

import com.google.inject.Inject;

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

}
