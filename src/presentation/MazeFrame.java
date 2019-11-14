package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import business.Maze;
import framework.AppFrame;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/7/2019: JL - Added cosmetic menu bar to frame
 * 11/12/2019: WW - Edited
 */
public class MazeFrame extends AppFrame {
	private Maze maze;
	private MazePanel mazePanel;
    private MazeView mazeView;
	private EditMenuBar editMenu;
	public static MazeFactory mazeF= new MazeFactory();
	public static String[] moveButton = mazeF.getEditCommands();
	
	
	public MazeFrame() {
		super(mazeF);
		setBackground(Color.DARK_GRAY);
		maze = new Maze();
		editMenu=new EditMenuBar();
		setJMenuBar(editMenu);
		
		setLayout(new GridLayout(1, 2));
		MazeController mC=new MazeController(maze);
		mazePanel = new MazePanel(maze, mC);
		mazeView= new MazeView(maze);
		add(mazePanel);
        add(mazeView);
	}
	
	public static void main(String[] args) {
		AppFrame app = new AppFrame(new MazeFactory());
		app.display();
	}
}
