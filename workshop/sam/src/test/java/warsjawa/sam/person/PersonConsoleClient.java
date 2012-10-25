package warsjawa.sam.person;

import java.io.IOException;
import java.util.Map;

import pmsoft.sam.architecture.model.ServiceKey;
import pmsoft.sam.see.SEEConfiguration;
import pmsoft.sam.see.SEEServer;
import pmsoft.sam.see.SEEServiceSetupAction;
import pmsoft.sam.see.ServiceInteracion;
import pmsoft.sam.see.api.model.SIID;
import pmsoft.sam.see.api.model.SIURL;
import pmsoft.sam.see.api.transaction.SamTransactionConfigurationUtil;
import warsjawa.sam.architecture.contract.RealizePersonInteraction;
import warsjawa.sam.architecture.impl.contact.LocalContractPersonServiceModule;
import warsjawa.sam.architecture.service.PersonContactService;
import warsjawa.sam.architecture.service.PersonInfoService;

import com.google.inject.Key;

public class PersonConsoleClient {

	private static int port = 4948;
	// TODO setup server address
	private static SIURL url = new SIURL("http://XXXX:4949/service1");

	public static void main(String[] args) throws IOException {
		SEEServer client = new SEEServer(createClientConfiguration(url));
		client.startUpServer();
		
		Map<SIURL, ServiceKey> running = client.getServiceDiscovery().getServiceRunningStatus();
		SIURL localServiceURL = running.keySet().iterator().next();
		
		client.executeServiceInteraction(new ServiceInteracion<RealizePersonInteraction>(localServiceURL,Key.get(RealizePersonInteraction.class))  {
			@Override
			public void executeInteraction(RealizePersonInteraction service) {
				service.sayHello();
			}
		});
		
		client.shutdownServer();
	}

	private static SEEConfiguration createClientConfiguration(final SIURL url) {
		return PersonConsoleServer.createArchitectureConfiguration().setupAction(new SEEServiceSetupAction() {

			@Override
			public void setup() {
				SIID myContractService = createServiceInstance(LocalContractPersonServiceModule.class);

				setupServiceTransaction(SamTransactionConfigurationUtil.createTransactionOn(PersonContactService.class)
						.urlBinding(PersonInfoService.class, url).providedByServiceInstance(myContractService));
			}
		}).bindToPort(port);
	}

}
