package presentation;

import java.awt.event.ActionEvent;

import framework.AppFrame;

/**
 * Change History:
 * 10/31/2019: NP - created
 * 11/10/2019: JL,NP - discussion about whether or not to keep MazeFrame, changed implementation
 * 					   so that MVC layer rules are not violated
 */
public class MazeFrame extends AppFrame {
	public MazeFrame(MazeFactory factory) {
		super(factory);

	}
	
	public void actionPerformed(ActionEvent ae) {
		super.actionPerformed(ae);		
	}
}