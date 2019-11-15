package framework;

/**
 * Change History:
 * 10/31/2019: NP - created
 */
public abstract class Command {
	protected Model model;
	
	public abstract void execute();
}
