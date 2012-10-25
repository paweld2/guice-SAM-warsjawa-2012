package warsjava.guice.contract;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.PrivateModule;
import com.google.inject.Provider;

public class TestCustomScopeCreation {

	@Test
	public void testControlledScopeConstruction() {
		Injector injector = Guice.createInjector(new PrivateModule() {

			@Override
			protected void configure() {
				// TODO implement custom scope and bind controller

			}
		});
		ScopeController controller = injector.getInstance(ScopeController.class);
		ScopedService service = injector.getInstance(ScopedService.class);
		User user = new User();
		user.name = "x";
		service.checkState(false);
		
		controller.enterScope(user);
		service.checkState(true);
		controller.exitScope();

		service.checkState(false);
		
		controller.enterScope(user);
		service.checkState(true);
		controller.exitScope();

	}

	public static class User {
		String name;
	}

	public static interface ScopeController {
		public void enterScope(User user);

		public void exitScope();
	}

	public static class ScopedService {
		private final Provider<User> userProvider;

		@Inject
		public ScopedService(Provider<User> userProvider) {
			this.userProvider = userProvider;
		}
		
		public void checkState(boolean haveUser) {
			User user = userProvider.get();
			if( haveUser ) {
				if( user == null) throw new RuntimeException("I expect to have a user binded in scope");
				assertEquals("x", user.name);
			} else {
				if( user != null) throw new RuntimeException("User is binded in scope and should not be");
			}
		}

	}

}
