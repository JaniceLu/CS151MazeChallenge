package framework;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public abstract class View extends JComponent implements Observer {
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
			this.update(model, null);
		}
	}
}
