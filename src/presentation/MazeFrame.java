package presentation;

import java.awt.Container;
import javax.swing.JFrame;

import business.Maze;
import framework.AppFrame;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/7/2019: JL - Removed reference to editMenu
 */
public class MazeFrame extends AppFrame {
	private static final long serialVersionUID = 1L;
	
	private Maze maze;
	private MazePanel mazePanel;
	
	public MazeFrame(MazeFactory factory) {
		super(factory);
		factory.makeEditCommand(maze, "North");
		factory.makeEditCommand(maze, "East");
		factory.makeEditCommand(maze, "West");
		factory.makeEditCommand(maze, "South");
		factory.makeEditCommand(maze, "Reset");
		
		maze = new Maze();
		mazePanel = new MazePanel(maze);
		Container cp = getContentPane();
		cp.add(mazePanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Maze Challenge");
		this.setSize(800, 800);
		this.pack();
	}
	
	public static void main(String[] args) {
		MazeFactory factory = new MazeFactory();
		MazeFrame mazeFrame = new MazeFrame(factory);
		mazeFrame.setVisible(true);
	}
}
