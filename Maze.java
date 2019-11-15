package business;

import java.util.Random;

import framework.Model;

/**
 * Change History:
 * 10/31/2019: WW - Created
 */
public class Maze extends Model {
	int exitDistance;
	int leftMoves;
	Position currentP;

	public Maze() {
		int width = 20;
		int height = 20;
		Random gen = new Random(System.currentTimeMillis());
		Room[][] maze = new Room[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++)
				maze[i][j] = new Room();
		}
		int exitX = gen.nextInt(width);
		int exitY = gen.nextInt(height);
		Room exit = maze[exitX][exitY];
		exit.setExit(true);
		exit.setExitP(new Position(exitX, exitY));

		leftMoves = 20;

		currentP = new Position(0, 0);

		exitDistance = Math.abs(currentP.getX() - exit.exitP.getX()) + Math.abs(currentP.getY() - exit.exitP.getY());
	}

	public Position getCurrentP() {
		return currentP;
	}

	public void setCurrentP(Position currentP) {
		this.currentP = currentP;

	}

	public int getExitDistance() {
		return exitDistance;
	}

	public int getLeftmoves() {
		return leftMoves;
	}

}

class Room {
	boolean isExit = false;
	boolean hasPlayer = false;
	Position exitP;

	public Position getExitP() {
		return exitP;
	}

	public void setExitP(Position exitP) {
		this.exitP = exitP;
	}

	public void setExit(boolean b) {
		this.isExit = true;
	}
}

class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = 0;
		this.y = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}