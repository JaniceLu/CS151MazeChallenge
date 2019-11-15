package presentation;

import business.Maze;
import framework.Command;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/7/2019: JL - consolidated all Move classes into one file
 */
public abstract class Move extends Command {
	protected Heading heading;
	protected Maze maze;
	
	public Move(Maze maze) {
		this.maze = maze;
	}
	
	public abstract void execute();
}

class MoveEast extends Move {
	public MoveEast(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.EAST);
	}
}

class MoveNorth extends Move {
	public MoveNorth(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.NORTH);
	}
}

class MoveSouth extends Move {
	public MoveSouth(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.SOUTH);
	}
}

class MoveWest extends Move {
	public MoveWest(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.WEST);
	}
}