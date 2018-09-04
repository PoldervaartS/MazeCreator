import java.awt.*;


public class Cell {
	
	boolean rightW = true; boolean bottomW = true; boolean visited = false;
	Point p;
	int x,y;
	boolean[] freeNeighbors = {false,false,false,false};
	
	public Cell(Point p){
		this.p = p;
		x = 0;
		y = 0;
	}
	
	public Cell(Point p,int y, int x){
	this.p = p;
	this.x = x;
	this.y = y;
	}
	
	public Point getP(){
		return p;
	}
	
	
	public void setVisited(){
		visited = true;
	}

}
