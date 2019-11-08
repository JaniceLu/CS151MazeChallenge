package presentation;

import business.Maze;
import framework.Command;

/**
 * Change History:
 * 11/7/2019: JL - created
 */
public class Reset extends Command{
    private Maze maze;
    public Reset(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
    }
}