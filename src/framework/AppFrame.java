package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/07/2019: JL - Modified createMenuBar() to display all options
 * 11/10/2019: NP - Changed createMenuBar() implementation 
 *
 */
public class AppFrame extends JFrame implements ActionListener {
	private Model model;
	private AppPanel panel;
	private AppFactory factory;
	
	public AppFrame(AppFactory factory) {
		this.factory = factory;
		model = factory.makeModel();
		panel = factory.makePanel(model, this);
		this.setJMenuBar(createMenuBar());
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(factory.getTitle());
		this.setSize(500, 500);
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	protected JMenuBar createMenuBar() {
		JMenuBar bar = new JMenuBar();
		
		// add file, edit, and help menus
		String[] fileMenuItems = new String[] {"New", "Save", "SaveAs", "Open", "Quit"};
		String[] helpMenuItems = new String[] {"About", "Contents"};
		
		JMenu fileMenu = Utilities.makeMenu("File", fileMenuItems, this);
		JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
		JMenu helpMenu = Utilities.makeMenu("Help", helpMenuItems, this);
		
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(helpMenu);
		
		return bar;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if(command.equals("Save")) Utilities.save(model, false);
		else if(command.equals("SaveAs")) Utilities.save(model, true);
		else if(command.equals("Open")) {
			Model newModel = Utilities.open(model);
			setModel(newModel);
		} else if(command.equals("New")) {
			Utilities.saveChanges(model);
			setModel(factory.makeModel());
			model.setUnsavedChanges(false);
		} else if (command.equals("Quit")) {
			Utilities.saveChanges(model);
			System.exit(1);
		} else if(command.equals("About")) {
			Utilities.inform(factory.about());
		} else if(command.equals("Help")) {
			Utilities.inform(factory.getHelp());
		} else {
			Command c = factory.makeEditCommand(model, command);
			CommandProcessor.commandProcessor.execute(c);
		}
	}
	


	public void setModel(Model model) {
		this.model = model;
		panel.setModel(model);
	}
	
}