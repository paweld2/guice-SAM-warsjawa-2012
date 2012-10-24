package warsjava.guice.implementations;

import warsjava.guice.contract.LoggingContract;

public class LoggerLevel2 implements LoggingContract {

	@Override
	public void log(String message) {
		System.out.println("2:"+message);
	}

	@Override
	public int getLevel() {
		return 2;
	}

}
