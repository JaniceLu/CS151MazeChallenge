package framework;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;

public abstract class View extends JComponent implements Observer {
	/**
	 *
	 */
	private static final long serialVersionUID = -4603713846860940720L;
	protected Model model;

	public View(Model model) {
		this.setModel(model);
	}
	public View() {
		this(null);
	}
	
	public void update(Observable o, Object arg) {
		this.repaint();
	}
	
	public void setModel(Model model) {
		if(this.model != null) this.model.deleteObserver(this);
		this.model = model;
		if(this.model != null) {
			this.model.addObserver(this);
			System.out.println("here");
			this.update(model, null);
		}
	}
}
