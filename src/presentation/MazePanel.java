package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Maze;
import framework.AppPanel;
import framework.Utilities;

public class MazePanel extends AppPanel{

	private static final long serialVersionUID = 1L;
	private JTextField exitDistanceField,movesLeftField;
	private List<JPanel> panels = new ArrayList<>();
    public MazePanel(Maze maze, ActionListener listener) {
        super(maze, listener);
        // add text fields, labels, and views
        exitDistanceField = new JTextField(maze.calculateExitDistance());
        movesLeftField = new JTextField("20");
        addOutPut(new JLabel("Exist Distance:"), exitDistanceField);
        addOutPut(new JLabel("Moves Left:"), movesLeftField);
        

        for (String s : MazeFrame.moveButton) {
            JButton button = new JButton(s);
            button.addActionListener(listener);
            addButton(button);
        }

        setLayout(new GridLayout(panels.size(), 1));
        for (JPanel p : panels) {
            p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            add(p);
        }
     }
	
    private void addOutPut(JLabel label, JTextField field) {
        JPanel outP = new JPanel();
        outP.add(label);
        outP.add(field);
        panels.add(outP);
    }
    private void addButton(JButton button) {
        JPanel buttonP = new JPanel();
        buttonP.add(button);
        panels.add(buttonP);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	Maze maze = (Maze)model;
    	exitDistanceField.setText(maze.calculateExitDistance()+"");
    	movesLeftField.setText(maze.getMovesLeft()+"");
    	if(maze.calculateExitDistance() == 0) {
    		Utilities.inform("You escaped!");
    	}
		if(maze.getMovesLeft() == 0) {
			Utilities.inform("No moves left");
		}
    }
    
}
