package framework;

public abstract class Command {
	protected Model model;
	
	public abstract void execute();
}