package warsjava.guice.contract;

import org.testng.annotations.Guice;

import com.google.inject.Inject;

@Guice
public class TestInjectionModel {

	@Inject
	public ViewContract view;
	
	public void testViewContractInjection(){
		
		
	}
}
