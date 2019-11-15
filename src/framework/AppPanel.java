package framework;

import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.JPanel;

/**
 * Change History:
 * 10/31/2019: NP - created
 * 11/10/2019: JL - fixed setModel method to properly set observers/views in the case
 * 					of New/Open/Save operations
 */
public class AppPanel extends JPanel implements Observer {
	protected Model model;
	protected Set<View> views = new HashSet<>();
	protected ActionListener listener;
	
	public AppPanel(Model model, ActionListener actionListener) {
		model.addObserver(this);
		this.model = model;
		this.listener = actionListener;
	}
	
	public void update(Observable o, Object arg) {
		for(View view : views) view.update(model, view);
	}
	
	public void setModel(Model model) {
		model.deleteObserver(this);
		this.model = model;
		model.addObserver(this);
		for(View view : views) {
			view.setModel(model);
		}
	}
	
	public void addView(View view) {
		super.add(view);
		this.views.add(view);
	}
}
