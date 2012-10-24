package warsjava.guice.modules;

import java.util.concurrent.atomic.AtomicInteger;

import warsjava.guice.contract.LoggingContract;
import warsjava.guice.contract.ModelContract;
import warsjava.guice.domain.Article;
import warsjava.guice.domain.Comment;
import warsjava.guice.implementations.LoggerLevel1;
import warsjava.guice.implementations.LoggerLevel2;
import warsjava.guice.implementations.ModelWarsjava;
import warsjava.guice.implementations.SimpleLogger;

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
		
	}

	private final AtomicInteger modelCounter = new AtomicInteger(0);
	
	@Provides
	public Article getArticle(){
		return new Article(modelCounter.addAndGet(1));
	}
	
	@Provides
	public Comment getComment(){
		return new Comment(modelCounter.addAndGet(1));
	}
	
	
}
