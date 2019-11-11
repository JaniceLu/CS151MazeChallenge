package presentation;

import java.awt.GridLayout;

import javax.swing.JPanel;

import business.Maze;
import framework.AppPanel;

public class MazePanel extends AppPanel {
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
