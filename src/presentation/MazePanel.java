package presentation;

import java.awt.GridLayout;

import javax.swing.JPanel;

import business.Maze;

public class MazePanel extends JPanel {
	private Maze maze;
	private MazeView mazeView;
	private ControlPanel controlPanel;
	
	public MazePanel(Maze maze) {
		this.maze = maze;
		this.mazeView = new MazeView(maze);
		this.controlPanel = new ControlPanel(maze);
		
		this.setLayout(new GridLayout(1, 2));
		this.add(controlPanel);
		this.add(mazeView);
	}
}
