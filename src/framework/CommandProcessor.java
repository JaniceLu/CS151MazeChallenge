package framework;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class CommandProcessor {
	//public static CommandProcessor commandProcessor = new CommandProcessor();
	
	public static void execute(Command c) {
		c.execute();
	}

}
