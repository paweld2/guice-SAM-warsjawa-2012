package warsjava.guice.modules;

import java.util.List;

import warsjava.guice.contract.ModelPlugin;

import com.google.inject.AbstractModule;
import com.google.inject.internal.UniqueAnnotations;

public class PlugInInstalationModule extends AbstractModule {

	private final List<ModelPlugin> toInstall;
	
	public PlugInInstalationModule(List<ModelPlugin> toInstall) {
		super();
		this.toInstall = toInstall;
	}

	@Override
	protected void configure() {
		for (ModelPlugin plugin : toInstall) {
			bind(ModelPlugin.class).annotatedWith(UniqueAnnotations.create()).toInstance(plugin);
		}
	}

}
