package presentation;

import business.Position;
import framework.Command;

/**
 * Change History: 
 * 10/30/2019: NP - created
 */
public class SetPosition extends Command {
	private Position position;
	private int x, y;
	
	public SetPosition(Position position, int x, int y) {
		this.position = position;
		this.x = x;
		this.y = y;
	}
	
	public void execute() {
		position.setX(x);
		position.setY(y);
	}
}
