package warsjava.guice.contract;

public interface LoggingContract {

	public void log(String message);
	
	public int getLevel();
}
