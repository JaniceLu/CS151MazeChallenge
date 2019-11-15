package framework;
/**
 * Change History:
 * 10/31/2019: NP - created
 */
public class CommandProcessor {
	public static CommandProcessor commandProcessor = new CommandProcessor();
	
	public void execute(Command c) {
		c.execute();
	}

}
