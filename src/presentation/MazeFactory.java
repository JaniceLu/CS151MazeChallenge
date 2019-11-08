package presentation;

import java.awt.event.ActionListener;

import javax.swing.event.AncestorListener;

import business.Maze;
import framework.AppFactory;
import framework.AppPanel;
import framework.Command;
import framework.Model;

/**
 * Change History: 11/7/2019: JL - created with dummy functions, needs to be
 * implemented properly later
 */
public class MazeFactory implements AppFactory {
    public Model makeModel() {
        return new Maze();
    }

    public String[] getEditCommands() {
        return new String[] { "North", "East", "West", "South", "Reset" };
    }

    public Command makeEditCommand(Model model, String type) {
        if (model instanceof Model) {
            if (type == "North")
                return new MoveNorth((Maze) model);
            else if (type == "East")
                return new MoveEast((Maze) model);
            else if (type == "West")
                return new MoveWest((Maze) model);
            else if (type == "South")
                return new MoveSouth((Maze) model);
            else if (type == "Reset")
                return new Reset((Maze) model);
            else
                return null;
        } else {
            return null;
        }
    }

    public String getTitle() {
        return "Maze Challenge";
    }

    public String[] getHelp() {
        String[] help = { "Locate the escape room", " in the number of allotted moves" };
        return help;
    }

    public String about() {
        return "Maze Challenge version 1.0 by Leopard Team";
    }

    @Override
    public AppPanel makePanel(Model model, ActionListener listener) {
        AppPanel panel = new AppPanel();
        return panel;
    }

}