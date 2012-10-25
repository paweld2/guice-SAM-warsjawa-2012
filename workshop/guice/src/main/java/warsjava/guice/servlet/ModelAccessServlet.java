package warsjava.guice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;

import warsjava.guice.contract.ModelContract;

@Singleton
public class ModelAccessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1897717577051090955L;

	private final ModelContract model;
	
	@Inject
	public ModelAccessServlet(ModelContract model) {
		super();
		this.model = model;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if( model == null) throw new RuntimeException("model is null");
		PrintWriter out = resp.getWriter();
		out.println("Guice injected servlet");
		out.println("Model environment is " + model.getEnvironmentName());
	}
}
