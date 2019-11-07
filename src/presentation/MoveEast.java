package presentation;

import business.Maze;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class MoveEast extends Move {
	public MoveEast(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.EAST);
	}
}
