package warsjava.guice.domain;


public class Comment {

	private final Integer id;

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
