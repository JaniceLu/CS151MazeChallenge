package presentation;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import business.Maze;
import framework.AppFrame;

public class MazeFrame extends AppFrame {	
	public MazeFrame(MazeFactory factory) {
		super(factory);
	}
	
	public void actionPerformed(ActionEvent ae) {
		super.actionPerformed(ae);
		Maze maze = (Maze) model;
		MazePanel mazePanel = (MazePanel) panel;
		
		ControlPanel controlPanel = mazePanel.getControlPanel();
		
		JTextField exitDistanceField = controlPanel.getExitDistanceField();
		JTextField movesLeftField = controlPanel.getMovesLeftField();

		exitDistanceField.setText(""+maze.calculateExitDistance());
		movesLeftField.setText(""+maze.getMovesLeft());
	}
}