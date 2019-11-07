package presentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import business.Maze;
import business.Position;
import framework.Model;
import framework.View;

/**
 * Change History:
 * 10/31/2019: NP - Created
 */
public class MazeView extends View {
	public static Boolean TESTING = true;
	
	public MazeView(Maze maze) {
		super(maze);		
	}

	public void paintComponent(Graphics gc) {
		Maze maze = null;
		if(model instanceof Maze) maze = (Maze)model;
		
		int size = maze.getSize();
		int width = this.getWidth();
		int height = this.getHeight();
		Position exitRoom = maze.getExitRoom();
		Position player = maze.getPlayer();
		
		double cellWidth = (double)width / size;
		double cellHeight = (double)height / size;

		Graphics2D gc2d = (Graphics2D) gc;
		gc2d.setStroke(new BasicStroke(2));
		gc2d.setColor(Color.DARK_GRAY);
		gc2d.fillRect(0, 0, width, height);
		gc2d.setColor(Color.BLACK);
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				Rectangle2D.Double grid = new Rectangle2D.Double(row*cellWidth, col*cellHeight, cellWidth, cellHeight);
				gc2d.draw(grid);				
			}
		}
		
		Ellipse2D.Double p = new Ellipse2D.Double(cellWidth*player.getX() + cellWidth/4,
												  cellHeight*player.getY() + cellWidth/4, 
												  cellWidth/2, 
												  cellHeight/2);
		gc2d.setColor(Color.RED);
		gc2d.fill(p);
		
		if(TESTING) {
			Rectangle2D.Double exit = new Rectangle2D.Double(cellWidth*exitRoom.getX(),
															 cellHeight*exitRoom.getY(), 
															 cellWidth, 
															 cellHeight);
			gc2d.setColor(Color.CYAN);
			gc2d.fill(exit);
		}
	}
}
