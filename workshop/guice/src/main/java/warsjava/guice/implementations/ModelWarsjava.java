package warsjava.guice.implementations;

import java.util.concurrent.atomic.AtomicInteger;

import warsjava.guice.contract.ModelContract;

public class ModelWarsjava implements ModelContract {

	private static AtomicInteger instanceCounter = new AtomicInteger(0);
	
	private final int instanceNr = instanceCounter.addAndGet(1);
	
	@Override
	public int getInstanceNr() {
		return instanceNr;
	}

}
