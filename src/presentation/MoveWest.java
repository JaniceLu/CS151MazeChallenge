package presentation;

import business.Maze;

public class MoveWest extends Move {
	public MoveWest(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.WEST);
	}
}
