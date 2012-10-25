package warsjava.guice.jit;

import com.google.inject.ProvidedBy;

@ProvidedBy(CardValidatorProvider.class)
public interface CardValidator {

	public boolean validate();
}
