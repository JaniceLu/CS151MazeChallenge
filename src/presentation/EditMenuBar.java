package presentation;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class EditMenuBar extends JMenuBar {
	private JMenu fileMenu, editMenu, helpMenu;
	private JMenuItem menuItem;
	private EditMenuController controller;
	private JMenuItem northButton, eastButton, westButton, southButton, resetButton;
	public EditMenuBar() {
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");
		northButton = new JMenuItem("North");
		eastButton = new JMenuItem("East");
		westButton = new JMenuItem("West");
		southButton = new JMenuItem("South");
		resetButton = new JMenuItem("Reset");
		
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
		menuItem = northButton;
		editMenu.add(menuItem);
		menuItem = eastButton;
		editMenu.add(menuItem);
		menuItem = westButton;
		editMenu.add(menuItem);
		menuItem = southButton;
		editMenu.add(menuItem);
		menuItem = resetButton;
		editMenu.add(menuItem);

		add(helpMenu);
		menuItem = new JMenuItem("About");
		helpMenu.add(menuItem);
		menuItem = new JMenuItem("Contents");
		helpMenu.add(menuItem);
	}
}
