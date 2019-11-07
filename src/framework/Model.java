package framework;

import java.io.Serializable;
import java.util.Observable;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public abstract class Model extends Observable implements Serializable {
	private String fileName = null;
	private boolean unsavedChanges = false;

	public void copy(Model other) {
		this.fileName = other.fileName;
		this.unsavedChanges = other.unsavedChanges;
	}
	public void changed() {
		this.unsavedChanges = true;
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
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
