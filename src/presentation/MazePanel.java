package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

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
	private ControlPanel controlPanel;
	private MazeView mazeView;	
	
	public MazePanel(Maze maze, ActionListener actionListener) {
		super(maze, actionListener);
		
		this.controlPanel = new ControlPanel(maze, actionListener);
		this.mazeView = new MazeView(maze);
		
		this.setLayout(new GridLayout(1, 2));
		this.add(controlPanel);
		this.add(mazeView);
	}
}