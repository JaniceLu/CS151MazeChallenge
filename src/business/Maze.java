package business;

import framework.Model;
import framework.Utilities;
import presentation.Heading;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/07/2019: JL - Changed Player and Exit Position generation by using Utilities
 * 11/14/2019: NP - Added inform message for when Player escapes
 *
 */
public class Maze extends Model {
	private static final long serialVersionUID = -961630536196416271L;
	private Position exitRoom, player;
	private int movesLeft, size;
	
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
		
		if(heading == Heading.NORTH) player.setY(player.getY()-1);
		else if(heading == Heading.SOUTH) player.setY(player.getY()+1);
		else if(heading == Heading.EAST) player.setX(player.getX()+1);
		else if(heading == Heading.WEST) player.setX(player.getX()-1);
		
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
	public int getMovesLeft() {
		return movesLeft;
	}
	public int getSize() {
		return size;
	}
}
