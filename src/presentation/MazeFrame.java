package presentation;

import java.awt.Container;
import javax.swing.JFrame;

import business.Maze;

public class MazeFrame extends JFrame {
	private Maze maze;
	private MazePanel mazePanel;
	private EditMenuPanel editMenuPanel;
	
	public MazeFrame() {
		maze = new Maze();
		mazePanel = new MazePanel(maze);
		Container cp = getContentPane();
		cp.add(mazePanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Maze Challenge");
		this.setSize(800, 800);
		this.pack();
	}
	
	public static void main(String[] args) {
		MazeFrame mazeFrame = new MazeFrame();
		mazeFrame.setVisible(true);
	}
}
