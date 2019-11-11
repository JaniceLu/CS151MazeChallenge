package presentation;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import business.Maze;

/**
 * Change History:
 * 10/31/2019: JL - Created
 * 11/10/2019: NP - Connected to controller
 */
public class EditMenuBar extends JMenuBar {
	private JMenu fileMenu, editMenu, helpMenu;
	private JMenuItem menuItem;
	private MazeController controller;
	private JMenuItem northButton, eastButton, westButton, southButton, resetButton;
	public EditMenuBar(Maze maze) {
		controller = new MazeController(maze);
		
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");
		
		add(fileMenu);
		menuItem = new JMenuItem("New");
		fileMenu.add(menuItem);
		menuItem = new JMenuItem("Save");
		fileMenu.add(menuItem);
		menuItem = new JMenuItem("SaveAs");
		fileMenu.add(menuItem);
		menuItem = new JMenuItem("Open");
		fileMenu.add(menuItem);
		menuItem = new JMenuItem("Quit");
		fileMenu.add(menuItem);

		add(editMenu);
		northButton = new JMenuItem("North");
		northButton.addActionListener(controller);
		menuItem = northButton;
		editMenu.add(menuItem);
		eastButton = new JMenuItem("East");
		eastButton.addActionListener(controller);
		menuItem = eastButton;
		editMenu.add(menuItem);
		westButton = new JMenuItem("West");
		westButton.addActionListener(controller);;
		menuItem = westButton;
		editMenu.add(menuItem);
		southButton = new JMenuItem("South");
		southButton.addActionListener(controller);
		menuItem = southButton;
		editMenu.add(menuItem);
		resetButton = new JMenuItem("Reset");
		resetButton.addActionListener(controller);
		menuItem = resetButton;
		editMenu.add(menuItem);

		add(helpMenu);
		menuItem = new JMenuItem("About");
		helpMenu.add(menuItem);
		menuItem = new JMenuItem("Contents");
		helpMenu.add(menuItem);
	}
}