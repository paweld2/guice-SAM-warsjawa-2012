package warsjava.guice.implementations;

import warsjava.guice.contract.LoggingContract;

public class SimpleLogger implements LoggingContract {

	@Override
	public void log(String message) {
		System.out.println("simple:"+message);
	}

	@Override
	public int getLevel() {
		return 0;
	}

}
