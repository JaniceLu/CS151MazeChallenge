package framework;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.JPanel;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/12/2019: WW - Edited
 */
public class AppPanel extends JPanel implements Observer {
	protected Model model;
	protected Set<View> views;
	protected ActionListener listener;
	
	public AppPanel(Model model,ActionListener listener) {
		setModel(model);
		this.listener = listener;
		views = new HashSet<View>();
	}
	
	public void update(Observable o, Object arg) {}
	
	public void setModel(Model model) {
		if(this.model != null) this.model.deleteObserver(this); 
		this.model = model;
		if(this.model != null) this.model.addObserver(this);
		for(View view : views) view.setModel(model);
	}
	public void addView(View view) {
		super.add(view);
		this.views.add(view);
	}
}
