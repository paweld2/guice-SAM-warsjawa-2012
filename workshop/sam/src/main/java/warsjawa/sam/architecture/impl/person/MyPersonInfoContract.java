package warsjawa.sam.architecture.impl.person;

import warsjawa.sam.architecture.contract.PersonInfoContract;

public class MyPersonInfoContract implements PersonInfoContract {

	// TODO setup your service implementation
	private final String name = "Provide you name";

	@Override
	public String getName(String otherName) {
		System.err.println("Getting hello from" + otherName);
		return name;
	}

}
