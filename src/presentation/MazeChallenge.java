package presentation;

import framework.AppFrame;

public class MazeChallenge {
	public static void main(String[] args) {
		AppFrame frame = new AppFrame(new MazeFactory());
		frame.display();
	}
}
