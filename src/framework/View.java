package framework;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;

/**
 * Change History: 
 * 10/31/2019: NP - created
 * 11/10/2019: JL - added serialversionuid for serialization/deserialization,
 * 					removed comment from update()
 */
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
			this.update(model, null);
		}
	}
}
