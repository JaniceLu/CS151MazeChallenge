package framework;

import java.awt.event.*;
import java.io.*;
import java.util.Random;

import javax.swing.*;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/07/2019: JL - Added random number generator based on system time
 * 11/10/2019: JL - getfilename has been changed to properly check with method called it 
 * 					(between save and open)
 * 11/12/2019: JL - Added changes to confirm and savechanges 
 */
public class Utilities {

	// enables stack traces and diagnostics
	public static Boolean DEBUG = true;

	// asks user a yes/no question
	public static boolean confirm(String query) {
		int result = JOptionPane.showConfirmDialog(null,
				query, "Choose One", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			return false;
		} else {
			return true;
		}
	}

	// asks user for info
	public static String ask(String query) {
		return JOptionPane.showInputDialog(null, query);
	}

	// tells user some info
	public static void inform(String info) {
		JOptionPane.showMessageDialog(null,info);
	}

	// tells user lots of info
	public static void inform(String[] items) {
		String infoString = "";
		for(int i = 0; i < items.length; i++) {
			infoString = infoString + "\n" + items[i];
		}
		inform(infoString);
	}

	// tells user about an error
	public static void error(String gripe) {
		JOptionPane.showMessageDialog(null,
				gripe,
				"OOPS!",
				JOptionPane.ERROR_MESSAGE);
	}

	// tells user about an exception
	public static void error(Exception gripe) {
		if (DEBUG) gripe.printStackTrace();
		JOptionPane.showMessageDialog(null,
				gripe.getMessage(),
				"OOPS!",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Asks users if they would like to save changes
	 * YES = continue without saving
	 * NO = save before continuing
	 */
	public static void saveChanges(Model model) {
		if (model.hasUnsavedChanges() &&
		      Utilities.confirm("Current model has unsaved changes, continue?"))
			Utilities.save(model, false);
	}

	// asks user for a file name
	public static String getFileName(String fName, String operationName) {
		String result = null;
		JFileChooser chooser = new JFileChooser();
		int returnVal = 0;
		chooser.setDialogTitle(operationName);
		if (fName != null) {
		   // open chooser in directory of fName
           chooser.setCurrentDirectory(new File(fName));
		}
		if(operationName.equals("Save")) {
			returnVal = chooser.showSaveDialog(null);
		} else {
			returnVal = chooser.showOpenDialog(null);
		}
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			result= chooser.getSelectedFile().getPath();
		}
		return result;
	}

	// save model
	public static void save(Model model, Boolean saveAs) {
		String fName = model.getFileName();
		if (fName == null || saveAs) {
			fName = Utilities.getFileName(fName, "Save");
			model.setFileName(fName);
		}
		try {
			ObjectOutputStream os =
			   new ObjectOutputStream(new FileOutputStream(fName));
			model.setUnsavedChanges(false);
			os.writeObject(model);
			os.close();
		} catch (Exception err) {
			model.setUnsavedChanges(true);
			Utilities.error(err);
		}
	}

	// open model
	public static Model open(Model model) {
		saveChanges(model);
		String fName = Utilities.getFileName(model.getFileName(), "Open");
		Model newModel = null;
		try {
			ObjectInputStream is =
			   new ObjectInputStream(new FileInputStream(fName));
			newModel = (Model)is.readObject();
			is.close();
		} catch (Exception err) {
			Utilities.error(err);
		}
		return newModel;
	}
	
	// a simple number generator
	public static int numberGenerator(int bound) {
		Random seed = new Random(System.currentTimeMillis());
		return seed.nextInt(bound);
	}
}