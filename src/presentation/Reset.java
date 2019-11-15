package presentation;

import business.Maze;
import framework.*;

/**
 * Change History:
 * 11/7/2019: JL - created
 * 11/14/2019: JL - added execute contents to reset the maze
 */
public class Reset extends Command{
    private Maze maze;

    public Reset(Maze maze) {
    	this.maze = maze;
    }

    public void execute() {
        maze.copy(maze);
        maze.resetMaze(maze.getInitialPlayerPosition());
    }
}