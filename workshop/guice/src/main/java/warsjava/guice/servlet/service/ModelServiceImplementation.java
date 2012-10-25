package warsjava.guice.servlet.service;

import javax.servlet.http.HttpServletRequest;

import warsjava.guice.contract.ModelContract;
import warsjava.guice.domain.User;

public class ModelServiceImplementation implements ModelService {

	private final ModelContract model;

	public ModelServiceImplementation(ModelContract model) {
		this.model = model;
	}

	@Override
	public boolean checkRequestStatus() {
		// TODO inject model
		if( model == null) throw new RuntimeException("model not injected");
		// TODO get access to the request
		HttpServletRequest request = null;
		if( request == null) throw new RuntimeException("request not injected");
		// TODO get a different user in each servlet session
		User currentUser = null;
		if( currentUser == null) throw new RuntimeException("user not injected");
		return false;
	}

}
