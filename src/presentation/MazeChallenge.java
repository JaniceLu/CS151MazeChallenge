package presentation;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class MazeChallenge {
	public static void main(String[] args) {
        MazeFactory factory = new MazeFactory();
        MazeFrame frame = new MazeFrame(factory);
        frame.setVisible(true);
    }
}
