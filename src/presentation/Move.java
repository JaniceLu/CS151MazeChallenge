package presentation;

import business.Maze;
import framework.Command;

public abstract class Move extends Command {
	protected Heading heading;
	protected Maze maze;
	
	public Move(Maze maze) {
		this.maze = maze;
	}
	
	public abstract void execute();
}
