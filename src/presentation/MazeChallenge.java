package presentation;

import framework.AppFrame;

/**
 * Change History: 
 * 10/31/2019: NP - Created
 * 11/8/2019: JL - Added main method
 */
public class MazeChallenge {
	public static void main(String[] args) {
        AppFrame frame = new AppFrame(new MazeFactory());
        frame.display();
    }
}
