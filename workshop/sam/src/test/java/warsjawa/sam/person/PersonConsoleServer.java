package warsjawa.sam.person;

import java.io.IOException;

import pmsoft.sam.architecture.model.ServiceKey;
import pmsoft.sam.see.SEEConfiguration;
import pmsoft.sam.see.SEEConfigurationBuilder;
import pmsoft.sam.see.SEEConfigurationBuilder.SEEConfigurationGrammar;
import pmsoft.sam.see.SEEServer;
import pmsoft.sam.see.SEEServiceSetupAction;
import pmsoft.sam.see.api.model.SIID;
import pmsoft.sam.see.api.model.SIURL;
import pmsoft.sam.see.api.plugin.SamServiceDiscoveryListener;
import pmsoft.sam.see.api.transaction.SamTransactionConfigurationUtil;
import warsjawa.sam.architecture.WarsjawaArchitecture;
import warsjawa.sam.architecture.impl.WarsjawaServiceImplementations;
import warsjawa.sam.architecture.impl.person.LocalPersonInfoServiceModule;
import warsjawa.sam.architecture.service.PersonInfoService;

import com.google.inject.AbstractModule;
import com.google.inject.internal.UniqueAnnotations;

public class PersonConsoleServer {

	private static int port = 4949;

	public static void main(String[] args) throws IOException {
		SEEServer server = new SEEServer(createServerConfiguration());
		server.startUpServer();
	}

	private static SEEConfiguration createServerConfiguration() {
		return createArchitectureConfiguration().setupAction(new SEEServiceSetupAction() {

			@Override
			public void setup() {
				// SIID contractSIID =
//				createServiceInstance(LocalContractPersonServiceModule.class);
				SIID personInfoSIID = createServiceInstance(LocalPersonInfoServiceModule.class);

				// SamInstanceTransaction transactionPersonInfo =
				setupServiceTransaction(
						SamTransactionConfigurationUtil
						.createTransactionOn(PersonInfoService.class)
						.providedByServiceInstance(personInfoSIID)
						);

			}
		}).bindToPort(port);
	}

	static SEEConfigurationGrammar createArchitectureConfiguration() {
		return SEEConfigurationBuilder.configuration().withPlugin(new AbstractModule() {
			@Override
			protected void configure() {
				bind(SamServiceDiscoveryListener.class).annotatedWith(UniqueAnnotations.create()).toInstance(new SamServiceDiscoveryListener() {
					@Override
					public void serviceInstanceCreated(SIURL url, ServiceKey contract) {
						System.out.println("serviceCreated: url[" + url + "], contract [" + contract + "]");
					}
				});
			}
		}).architecture(new WarsjawaArchitecture()).implementationPackage(new WarsjawaServiceImplementations());
	}
}
