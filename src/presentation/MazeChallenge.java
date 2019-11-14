package presentation;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/08/2019: JL - Added main method
 *
 */
public class MazeChallenge {
	public static void main(String[] args) {
		MazeFrame frame = new MazeFrame(new MazeFactory());
		frame.display();
	}
}
