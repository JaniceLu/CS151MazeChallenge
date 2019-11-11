package presentation;

import java.awt.event.ActionListener;

import business.Maze;
import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;

/**
 * 
 * Change History
 * 11/07/2019: JL - Created
 * 11/10/2019: NP - Small revisions to edit commands
 *
 */
public class MazeFactory implements AppFactory {

	public Model makeModel() {
		return new Maze();
	}

	public AppPanel makePanel(Model model, ActionListener listener) {
		AppPanel panel = null;
		
		if(model instanceof Maze) panel = new MazePanel((Maze)model);
		else panel = new AppPanel();
		
		return panel;
	}

	public String[] getEditCommands() {
		return new String[] {"Move North", "Move East", "Move West", "Move South", "Reset"};
	}

	public Command makeEditCommand(Model model, String type) {
		Command c = null;
		
		if(model instanceof Maze) {
			if(type.equals("Move North")) c = new MoveNorth((Maze)model);
			else if(type.equals("Move East")) c = new MoveEast((Maze)model);
			else if(type.equals("Move West")) c = new MoveWest((Maze)model);
			else if(type.equals("Move South")) c = new MoveSouth((Maze)model);
			else if(type.equals("Reset")) c = new Reset((Maze)model);
		}
		
		return c;
	}

	public String getTitle() {
		return "Maze Challenge";
	}

	public String[] getHelp() {
		return new String[] {"Located the escape room", "in the number of allotted moves"};
	}

	public String about() {
		return "Maze Challenge version 1.0 by Leopard © 2019";
	}

}
