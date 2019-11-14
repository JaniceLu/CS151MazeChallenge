package business;

import framework.CommandProcessor;
import framework.Model;
import framework.Utilities;
import presentation.Heading;
import presentation.SetPosition;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/07/2019: JL - Changed Player and Exit Position generation by using Utilities
 * 11/14/2019: NP - Added inform message for when Player escapes, added bound checks
 * 11/14/2019: JL - Added reset maze functionality and a private setter
 */
public class Maze extends Model {
	private static final long serialVersionUID = -961630536196416271L;
	private Position exitRoom, player;
	private int movesLeft, size;
	private Position initialPlayerPosition;

	public Maze() {
		movesLeft = 20;
		size = 20;
		
		int exitX, exitY, playerX, playerY;
		do {
			exitX = Utilities.numberGenerator(size);
			exitY = Utilities.numberGenerator(size);
			playerX = Utilities.numberGenerator(size);
			playerY = Utilities.numberGenerator(size);
		} while(exitX == playerX && exitY == playerY);
		
		exitRoom = new Position(exitX, exitY);
		player = new Position(playerX, playerY);
		initialPlayerPosition = new Position(playerX, playerY);
	}

	/**
	 * used for resetting the Maze to the initial position
	 * @param player player position within the maze
	 */
	public void resetMaze(Position player) {
		movesLeft = 20;

		int playerX = player.getX();
		int playerY = player.getY();

		setPlayer(playerX, playerY);
		changed();
	}
	
	public void copy(Model other) {
		super.copy(other);
		Maze m = (Maze) other;
		movesLeft = m.getMovesLeft();
		size = m.getSize();
		exitRoom = m.getExitRoom();
		player = m.getPlayer();
		changed();
	}

	public void move(Heading heading){
		int playerX = player.getX();
		int playerY = player.getY();
		SetPosition command = new SetPosition(player, playerX, playerY);

		if(heading == Heading.NORTH && playerY > 0) command = new SetPosition(player, playerX, playerY-1);
		else if(heading == Heading.SOUTH && playerY < size) command = new SetPosition(player, playerX, playerY+1);
		else if(heading == Heading.EAST && playerX < size) command = new SetPosition(player, playerX+1, playerY);
		else if(heading == Heading.WEST && playerX > 0) command = new SetPosition(player, playerX, playerY-1);
		
		CommandProcessor.commandProcessor.execute(command);
		movesLeft -= 1;
		changed();
		if(movesLeft == 0) Utilities.inform("No moves left");
		if(exitRoom.getX() == player.getX() && exitRoom.getY() == player.getY()) Utilities.inform("You escaped!");
	}

	public int calculateExitDistance() {
		if(exitRoom == null || player == null) return -1;
		
		int exitX = exitRoom.getX();
		int exitY = exitRoom.getY();
		int playerX = player.getX();
		int playerY = player.getY();
		
		return (int)Math.sqrt((playerX-exitX)*(playerX-exitX) + (playerY-exitY)*(playerY-exitY));
	}
	
	public Position getExitRoom() {
		return exitRoom;
	}
	
	public Position getPlayer() {
		return player;
	}

	private void setPlayer(int x, int y) {
		player.setX(x);
		player.setY(y);
	}

	public Position getInitialPlayer() {
		return initialPlayerPosition;
	}

	public int getMovesLeft() {
		return movesLeft;
	}
	public int getSize() {
		return size;
	}
}
