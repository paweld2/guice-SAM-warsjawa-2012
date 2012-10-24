package warsjava.guice.implementations;

import warsjava.guice.contract.LoggingContract;

public class LoggerLevel1 implements LoggingContract {

	@Override
	public void log(String message) {
		System.out.println("1:"+message);
	}

	@Override
	public int getLevel() {
		return 1;
	}

}
