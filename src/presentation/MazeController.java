package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import business.Maze;
import framework.Command;
import framework.CommandProcessor;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class MazeController implements ActionListener {
	private Maze maze;

	public MazeController(Maze maze) {
		super();
		this.maze = maze;
	}

	public void actionPerformed(ActionEvent ae) {
		JButton button = null;
		JMenuItem menu = null;
		String command = ae.getActionCommand();
		
		if(ae.getSource() instanceof JButton) button = (JButton)ae.getSource();
		else if(ae.getSource() instanceof JMenuItem) menu = (JMenuItem)ae.getSource();
		
		Command c = null;
		if(command.equals("North")) c = new MoveNorth(maze);
		else if(command.equals("East")) c = new MoveEast(maze);
		else if(command.equals("West")) c = new MoveWest(maze);
		else if(command.equals("South")) c = new MoveSouth(maze);
		else if(command.equals("Reset")) System.out.println("To be implemented.");
		
		CommandProcessor.commandProcessor.execute(c);
	}
	
}
