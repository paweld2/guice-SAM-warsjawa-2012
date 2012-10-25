package warsjava.guice.modules;

import java.util.concurrent.atomic.AtomicInteger;

import warsjava.guice.contract.ExternalLibApi;
import warsjava.guice.contract.LoggingContract;
import warsjava.guice.contract.ModelContract;
import warsjava.guice.domain.AdminUser;
import warsjava.guice.domain.Article;
import warsjava.guice.domain.Comment;
import warsjava.guice.domain.Task;
import warsjava.guice.implementations.ExternalLibApiImplementation;
import warsjava.guice.implementations.LoggerLevel1;
import warsjava.guice.implementations.LoggerLevel2;
import warsjava.guice.implementations.ModelWarsjava;
import warsjava.guice.implementations.SimpleLogger;
import warsjava.guice.implementations.TaskProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class ModelModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LoggingContract.class).to(SimpleLogger.class);

		bind(LoggingContract.class).annotatedWith(Names.named("level1")).to(LoggerLevel1.class);
		bind(LoggingContract.class).annotatedWith(Names.named("level2")).to(LoggerLevel2.class);

		bind(ModelContract.class).to(ModelWarsjava.class).in(Singleton.class);

		bind(LoggingContract.class).annotatedWith(Names.named("modelLogger")).toInstance(ModelWarsjava.modelInternalLogger);

		bind(AdminUser.class).in(Singleton.class);

		try {
			bind(ExternalLibApi.class).toConstructor(ExternalLibApiImplementation.class.getConstructor());
		} catch (Exception e) {
			addError(e);
		}

		bind(Task.class).toProvider(new TaskProvider());
		
		bind(LoggingContract.class).annotatedWith(MyWorkshopCustomAnnotation.class).toInstance(new LoggingContract() {
			
			@Override
			public void log(String message) {
				System.out.println("MyWorkshopCustomAnnotation:"+message);
			}
			
			@Override
			public int getLevel() {
				return 100;
			}
		});
	}

	private final AtomicInteger modelCounter = new AtomicInteger(0);

	@Provides
	public Article getArticle() {
		return new Article(modelCounter.addAndGet(1));
	}

	@Provides
	public Comment getComment() {
		return new Comment(modelCounter.addAndGet(1));
	}

}
