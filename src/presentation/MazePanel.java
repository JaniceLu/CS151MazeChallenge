package presentation;

import java.awt.GridLayout;

import javax.swing.JPanel;

import business.Maze;
import framework.AppPanel;

/**
 * 
 * Change History:
 * 10/31/2019: NP - Created
 * 11/08/2019: JL - MazePanel now extends AppPanel(as it is supposed to)
 *
 */
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
	
	public ControlPanel getControlPanel() {
		return controlPanel;
	}
}
