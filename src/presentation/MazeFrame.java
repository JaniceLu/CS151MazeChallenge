package presentation;

import java.awt.Container;
import javax.swing.JFrame;

import business.Maze;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/7/2019: JL - Added cosmetic menu bar to frame
 */
public class MazeFrame extends JFrame {
	private Maze maze;
	private MazePanel mazePanel;
	private EditMenuBar editMenu;
	
	public MazeFrame() {
		maze = new Maze();
		mazePanel = new MazePanel(maze);
		Container cp = getContentPane();
		cp.add(mazePanel);
		setJMenuBar(new EditMenuBar());
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
