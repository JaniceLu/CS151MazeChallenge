package framework;

import java.io.Serializable;
import java.util.Observable;

public abstract class Model extends Observable implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1627567944966918700L;
	private String fileName = null;
	private boolean unsavedChanges = false;

	public void copy(Model other) {
		this.fileName = other.fileName;
		this.unsavedChanges = other.unsavedChanges;
	}
	public synchronized void changed() {
		this.unsavedChanges = true;
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
		this.notify();
	}
	
	public boolean hasUnsavedChanges() {
		return unsavedChanges;
	}
	public String getFileName() {
		return fileName;
	}
	
	public void setUnsavedChanges(boolean flag) {
		unsavedChanges = flag;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
