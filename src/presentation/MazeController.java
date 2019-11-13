package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import business.Maze;
import framework.Command;
import framework.CommandProcessor;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/10/2019: NP - Extended to handle move commands
 *
 */
public class MazeController implements ActionListener {
	private Maze maze;

	public MazeController(Maze maze) {
		super();
		this.maze = maze;
	}

	public void actionPerformed(ActionEvent ae) {		
		String command = ae.getActionCommand();		
		Command c = null;
		
		if(command != null) {
			if(command.equals("North")) c = new MoveNorth(maze); 
			else if(command.equals("East")) c = new MoveEast(maze);
			else if(command.equals("West")) c = new MoveWest(maze);
			else if(command.equals("South")) c = new MoveSouth(maze);
			else if(command.equals("Reset")) c = new Reset(maze);
		}
		
		CommandProcessor.commandProcessor.execute(c);
	}
	
}
