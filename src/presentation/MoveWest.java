package presentation;

import business.Maze;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class MoveWest extends Move {
	public MoveWest(Maze maze) {
		super(maze);
	}

	public void execute() {
		maze.move(heading.WEST);
	}
}
