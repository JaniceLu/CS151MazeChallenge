package presentation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import business.Maze;
import business.Position;
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