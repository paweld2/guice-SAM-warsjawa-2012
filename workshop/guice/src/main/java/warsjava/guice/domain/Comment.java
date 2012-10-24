package warsjava.guice.domain;

import com.google.inject.Inject;

public class Comment {

	private final Integer id;

	@Inject
	public Comment(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public boolean validate() {
		if (id == null)
			return false;

		return true;
	}
}
