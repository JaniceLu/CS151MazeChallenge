package business;

import java.io.Serializable;

/**
 * Change History: 
 * 10/31/2019: NP - created
 * 11/10/2019: JL - Position now implements Serializable for saving Position information,
 * 					also added serialversionuid
 */
public class Position implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 3219829151520700350L;
	private int x, y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
