package warsjava.guice.servlet;

import java.util.concurrent.atomic.AtomicInteger;

import warsjava.guice.domain.User;
import warsjava.guice.servlet.service.ModelService;
import warsjava.guice.servlet.service.ModelServiceImplementation;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.google.inject.servlet.SessionScoped;

public class WarsjavaServletConfigurationModule extends ServletModule {

	@Override
	protected void configureServlets() {
		serve("*").with(ModelAccessServlet.class);
		bind(ModelService.class).to(ModelServiceImplementation.class).asEagerSingleton();
	}

	private final AtomicInteger counter = new AtomicInteger();

	@Provides
	@SessionScoped
	public User getUserForSession() {
		User user = new User();
		user.setUserName("user nr " + counter.addAndGet(1));
		return user;
	}
}
