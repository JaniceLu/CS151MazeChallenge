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
 * 11/10/2019: NP - Extended to handle EditMenuBar move commands
 *
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
		if(ae.getSource() instanceof JMenuItem) {
			menu = (JMenuItem)ae.getSource();
			System.out.println("Touched");
		}
				
		Command c = null;
		if(command != null && command.equals("North") || menu != null && menu.equals("North")) {
			c = new MoveNorth(maze);
			System.out.println("Touched");
		}
		else if(command != null && command.equals("East") || menu != null && menu.equals("East")) c = new MoveEast(maze);
		else if(command != null && command.equals("West") || menu != null && menu.equals("West")) c = new MoveWest(maze);
		else if(command != null && command.equals("South") || menu != null && menu.equals("South")) c = new MoveSouth(maze);
		else if(command != null && command.equals("Reset") || menu != null && menu.equals("Reset")) System.out.println("To be implemented.");
				
		CommandProcessor.commandProcessor.execute(c);
	}
	
}
