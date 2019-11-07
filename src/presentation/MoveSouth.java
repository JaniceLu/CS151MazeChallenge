package presentation;

import business.Maze;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class MoveSouth extends Move {
	public MoveSouth(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.SOUTH);
	}
}
