package presentation;

import java.awt.event.ActionListener;

import business.Maze;
import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;

public class MazeFactory implements AppFactory {

	public Model makeModel() {
		return new Maze();
	}

	public AppPanel makePanel(Model model, ActionListener listener) {
		
		return new MazePanel((Maze)model);
	}

	public String[] getEditCommands() {
		return new String[] {"Move North", "Move East", "Move West", "Move South", "Reset"};
	}

	public Command makeEditCommand(Model model, String type) {
		Command c = null;
		
		if(type.equals("Move North")) c = new MoveNorth((Maze)model);
		else if(type.equals("Move East")) c = new MoveEast((Maze)model);
		else if(type.equals("Move West")) c = new MoveWest((Maze)model);
		else if(type.equals("Move South")) c = new MoveSouth((Maze)model);
//		else if(type.equals("Reset")) c = new Reset((Maze)model);
		
		return c;
	}

	public String getTitle() {
		return "Maze Challenge";
	}

	public String[] getHelp() {
		return new String[] {"test 1", "test 2"};
	}

	public String about() {
		return "Maze Challenge version 1.0 by Leopard © 2019";
	}

}
