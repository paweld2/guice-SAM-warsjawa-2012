package warsjawa.sam.architecture.impl.contact;

import com.google.inject.Inject;

import warsjawa.sam.architecture.contract.PersonInfoContract;
import warsjawa.sam.architecture.contract.RealizePersonInteraction;

public class MyRealizePersonInteraction implements RealizePersonInteraction {

	private final PersonInfoContract personReference;
	
	//TODO setup your name
	private final String name = "Setup Your Name";

	@Inject
	public MyRealizePersonInteraction(PersonInfoContract personReference) {
		super();
		this.personReference = personReference;
	}

	@Override
	public boolean sayHello() {
		String externalNamename = personReference.getName(this.name);
		if( externalNamename == null) return false;
		System.err.println("Hello return from: " + externalNamename + "!!!!");
		return true;
	}

}
