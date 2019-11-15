package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Maze;
import framework.AppPanel;
import framework.View;

/**
 * Change History: 
 * 10/31/2019: NP - created
 * 11/10/2019: NP - changed implementation to update fields using ControlPanel class
 * 11/14/2019: NP - added disabled clause to disable buttons after win/loss
 * 11/14/2918: JL - added clause to re-enable buttons if user decides to reset game
 */
public class ControlPanel extends AppPanel {
	private MazeController controller;
	private JTextField exitDistanceField, movesLeftField;
	private JButton northButton, eastButton, westButton, southButton, resetButton;
	
	public ControlPanel(Maze maze, ActionListener listener) {
		super(maze, listener);
		controller = new MazeController(maze);
		this.setLayout(new GridLayout(7, 1));
		
		JPanel p = new JPanel();
		p.add(new JLabel("Exit Distance"));
		exitDistanceField = new JTextField(""+maze.calculateExitDistance(), 10);
		p.add(exitDistanceField);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p);
		
		p = new JPanel();
		p.add(new JLabel("Moves Left"));
		movesLeftField = new JTextField(""+maze.getMovesLeft(), 10);
		p.add(movesLeftField);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p);
		
		p = new JPanel();
		northButton = new JButton("North");
		northButton.addActionListener(controller);
		p.add(northButton);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p);
		
		p = new JPanel();
		eastButton = new JButton("East");
		eastButton.addActionListener(controller);
		p.add(eastButton);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p);
		
		p = new JPanel();
		westButton = new JButton("West");
		westButton.addActionListener(controller);
		p.add(westButton);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p);
		
		p = new JPanel();
		southButton = new JButton("South");
		southButton.addActionListener(controller);
		p.add(southButton);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p);
		
		p = new JPanel();
		resetButton = new JButton("Reset");
		resetButton.addActionListener(controller);
		p.add(resetButton);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(p);	
	}

	public void update(Observable o, Object arg) {
		for(View view : views) view.update(model, view);
		
		Maze maze = (Maze)model;
		exitDistanceField.setText(""+maze.calculateExitDistance());
		movesLeftField.setText(""+maze.getMovesLeft());
		
		if(maze.isDisabled()) {
			northButton.setEnabled(false);
			eastButton.setEnabled(false);
			westButton.setEnabled(false);
			southButton.setEnabled(false);
		} else if(!maze.isDisabled()){
			northButton.setEnabled(true);
			eastButton.setEnabled(true);
			westButton.setEnabled(true);
			southButton.setEnabled(true);
		}
	}
}
