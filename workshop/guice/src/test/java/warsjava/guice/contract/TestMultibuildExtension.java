package warsjava.guice.contract;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

import warsjava.guice.modules.EnvironmentModule;
import warsjava.guice.modules.ModelModule;
import warsjava.guice.modules.TaskModelModule;
import warsjava.guice.multibinding.ModelPluginRegistry;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.util.Modules;

public class TestMultibuildExtension {

	

	@Test
	public void testPlugInInstalationWithMultibinding(){
		final List<ModelPlugin> plugins = pluginsToInstall("provider1");

		ModelEnvironment testEnvironment = new ModelEnvironment("test");
		Module allModel = Modules.combine(new ModelModule(),new TaskModelModule(), new EnvironmentModule(testEnvironment));
		Module pluginsModules = Modules.combine(new AbstractModule(){
			@Override
			protected void configure() {
				Multibinder<ModelPlugin> multibinder = Multibinder.newSetBinder(binder(), ModelPlugin.class);
				for (ModelPlugin modelPlugin : plugins) {
					multibinder.addBinding().toInstance(modelPlugin);
				}
				multibinder.permitDuplicates();
				MapBinder<String, ModelPlugin> mapMiltibinder = MapBinder.newMapBinder(binder(), String.class, ModelPlugin.class);
				for (ModelPlugin modelPlugin : plugins) {
					mapMiltibinder.addBinding(modelPlugin.getName()).toInstance(modelPlugin);
				}
			}
		});
		
		Injector injector = Guice.createInjector(Modules.combine(allModel,pluginsModules));
		assertNotNull(injector);
		ModelPluginRegistry registry = injector.getInstance(ModelPluginRegistry.class);
		assertEquals(5, registry.getPluginCounter());
	}
	
	private List<ModelPlugin> pluginsToInstall(final String provider){
		List<ModelPlugin> list = new LinkedList<ModelPlugin>();
		list.add(new ModelPlugin() {
			@Override
			public String getName() {
				return provider+"-plugin1";
			}
		});
		list.add(new ModelPlugin() {
			@Override
			public String getName() {
				return provider+"-plugin2";
			}
		});
		list.add(new ModelPlugin() {
			@Override
			public String getName() {
				return provider+"-plugin3";
			}
		});
		list.add(new ModelPlugin() {
			@Override
			public String getName() {
				return provider+"-plugin4";
			}
		});
		list.add(new ModelPlugin() {
			@Override
			public String getName() {
				return provider+"-plugin5";
			}
		});
		return list;
	}
}
