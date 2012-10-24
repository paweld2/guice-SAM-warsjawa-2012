package warsjava.guice.domain;

import com.google.inject.Inject;


public class Article {

	private final Integer id;

	public int getId() {
		return id;
	}

	public boolean validate() {
		if (id == null)
			return false;

		return true;
	}

	@Inject
	public Article(Integer id) {
		super();
		this.id = id;
	}

}
