package framework;

public class CommandProcessor {
	public static CommandProcessor commandProcessor = new CommandProcessor();
	
	public void execute(Command c) {
		c.execute();
	}

}
