package business;

import java.util.Random;

import framework.Command;
import framework.CommandProcessor;
import framework.Model;
import framework.Utilities;
import presentation.Heading;

/**
 * Change History:
 * 10/31/2019: NP - Created
 * 11/07/2019: JL - Changed Player and Exit Position generation by using Utilities
 *
 */
public class Maze extends Model {
	private Position exitRoom, player;
	private int movesLeft, size;
	
	public Maze() {
		movesLeft = 20;
		size = 20;
		Random gen = new Random(System.currentTimeMillis());
		
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
	
	public void move(Heading heading){
		
		if(heading == Heading.NORTH) player.setY(player.getY()-1);
		else if(heading == Heading.SOUTH) player.setY(player.getY()+1);
		else if(heading == Heading.EAST) player.setX(player.getX()+1);
		else if(heading == Heading.WEST) player.setX(player.getX()-1);
		
		movesLeft -= 1;
		changed();
//		if(movesLeft == 0) Utilities.error("No moves left");
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
		System.out.println("here");
		return movesLeft;
	}
	public int getSize() {
		return size;
	}
}
