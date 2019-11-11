package presentation;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Maze;
import framework.AppPanel;

public class ControlPanel extends AppPanel {
	private MazeController controller;
	private JTextField exitDistanceField, movesLeftField;
	private JButton northButton, eastButton, westButton, southButton, resetButton;
	
	public ControlPanel(Maze maze) {
		controller = new MazeController(maze, this);
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

	public JTextField getExitDistanceField() {
		return this.exitDistanceField;
	}
	public JTextField getMovesLeftField() {
		return this.movesLeftField;
	}
}
