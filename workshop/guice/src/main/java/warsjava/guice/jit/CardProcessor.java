package warsjava.guice.jit;

import com.google.inject.ImplementedBy;

@ImplementedBy(CardProcessorImpl.class)
public interface CardProcessor {

	public boolean processCard();
}
