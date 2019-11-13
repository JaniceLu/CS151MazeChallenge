package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/12/2019: WW - Edited createMenuBar method
 */
public class AppFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private Model model;
	private AppPanel panel;
	private AppFactory factory;
	
	public AppFrame(AppFactory factory) {
		this.factory = factory;
		model = factory.makeModel();
		panel = factory.makePanel(model, this);
		this.getContentPane().add(panel);
		this.setJMenuBar(createMenuBar());
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
		JMenu fileMenu = new JMenu();
		JMenu helpMenu = new JMenu();
		JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
		bar.add(fileMenu);
		bar.add(helpMenu);
		bar.add(editMenu);
		
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
