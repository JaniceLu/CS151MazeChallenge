package presentation;

import business.Maze;

public class MoveNorth extends Move {
	public MoveNorth(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.NORTH);
	}
}
