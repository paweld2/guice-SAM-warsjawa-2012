package warsjava.guice.implementations;

import java.util.concurrent.atomic.AtomicInteger;

import warsjava.guice.contract.LoggingContract;
import warsjava.guice.contract.ModelContract;

public class ModelWarsjava implements ModelContract {
	
	public static LoggingContract modelInternalLogger = new LoggingContract() {
		@Override
		public void log(String message) {
			System.out.println("model logger:" + message);
		}
		
		@Override
		public int getLevel() {
			return 10;
		}
	}; 

	private static AtomicInteger instanceCounter = new AtomicInteger(0);
	
	private final int instanceNr = instanceCounter.addAndGet(1);
	
	@Override
	public int getInstanceNr() {
		return instanceNr;
	}

}
