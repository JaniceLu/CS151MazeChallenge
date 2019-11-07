package presentation;

import business.Maze;

public class MoveSouth extends Move {
	public MoveSouth(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.SOUTH);
	}
}
