package warsjava.guice.domain;


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

	public Article(Integer id) {
		super();
		this.id = id;
	}

}
