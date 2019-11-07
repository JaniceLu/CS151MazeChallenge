package presentation;

import business.Maze;

public class MoveEast extends Move {
	public MoveEast(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.EAST);
	}
}
