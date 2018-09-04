import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MazeCreator extends Canvas {

	int w, h,cellW;
	Point startP;
	Cell[][] maze;
	Stack<Cell> cells;

	public MazeCreator() {
		w = 0;
		h = 0;
	}

	public MazeCreator(int wB, int hB, int WIDTH1, int HEIGHT,int cellW) {
		randTest();
		this.cellW = cellW;
		cells = new Stack<>();
		w = wB;
		h = hB;
		setBackground(Color.WHITE);
		maze = new Cell[wB][hB];
		startP = new Point(WIDTH1 / 2 - cellW / 2 * w, HEIGHT / 2 - cellW /2 * h - 50);
		for (int i = 0; i < maze.length; i++) {
			int firstX = startP.x;
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = new Cell(startP, i, j);
				startP = new Point(startP.x + cellW, startP.y);
			}
			startP = new Point(firstX, startP.y + cellW);
		}
		startP = maze[0][0].getP();
		makeMaze(w/2, h/2);
		repaint();
	}
	
	public void randTest(){
		int[] nums = {0,0,0,0};
		for(int i =0; i < 100; i++){
			nums[(int) (Math.floor(Math.random() * 4))] ++;
		}
		for(int i :nums){
			System.out.println(i);
		}
	}

	public void paint(Graphics g) {
		toPaint(g);
	}

	public void toPaint(Graphics g) {
		setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.drawRect(startP.x, startP.y, cellW * w, cellW * h);
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (maze[i][j].rightW) {
					g.drawLine(maze[i][j].getP().x + cellW, maze[i][j].getP().y, maze[i][j].getP().x + cellW,
							maze[i][j].getP().y + cellW);
				}
				if (maze[i][j].bottomW) {
					g.drawLine(maze[i][j].getP().x, maze[i][j].getP().y + cellW, maze[i][j].getP().x + cellW,
							maze[i][j].getP().y + cellW);
				}
				
				
				

			}

		}
	}

	public boolean[] getFreeNeighbors(int x, int y) {
		boolean[] freeNeighbors = { false, false, false, false };
		if (x < maze.length - 1 && !maze[y][x + 1].visited)
			freeNeighbors[0] = true;
		if (y < maze.length - 1 && !maze[y + 1][x].visited)
			freeNeighbors[1] = true;
		if (x > 0 && !maze[y][x - 1].visited)
			freeNeighbors[2] = true;
		if (y > 0 && !maze[y - 1][x].visited)
			freeNeighbors[3] = true;
		return freeNeighbors;
	}

	public void makeMaze(int i, int j) {
		cells.add(maze[i][j]);
		int num = 0;
		while (!cells.isEmpty()) {
			Cell c = cells.peek();
			if (c.visited) {
				boolean[] freeNeighbors = getFreeNeighbors(c.x, c.y);
				int r = (int) (Math.floor(Math.random() * 4));
				int cnt = 0;
				while (!freeNeighbors[r] && cnt < 6) {
					r--;
					cnt++;
					if (r < 0) {
						r = 3;
					}
				}
				if (cnt == 6) {
					r = 4;
				}
				System.out.println(num++);
				if (r == 0) {
					maze[c.y][c.x].rightW = false;
					cells.push(maze[c.y][c.x+1]);
				} else if (r == 1) {
					maze[c.y][c.x].bottomW = false;
					cells.push(maze[c.y+1][c.x]);
				} else if (r == 2) {
					maze[c.y][c.x-1].rightW = false;
					cells.push(maze[c.y][c.x - 1]);
				} else if (r == 3) {
					maze[c.y-1][c.x].bottomW = false;
					cells.push(maze[c.y - 1][c.x]);
				} else {
					cells.pop();
				}
				maze[c.y][c.x].visited = true;

			} else {
				
				boolean[] freeNeighbors = getFreeNeighbors(c.x, c.y);
				int r = (int) (Math.random() * 4);
				int cnt = 0;
				while (!freeNeighbors[r] && cnt < 6) {
					r--;
					cnt++;
					if (r < 0) {
						r = 3;
					}
				}
				if (cnt == 6) {
					r = 4;
				}
				if (r == 0) {
					maze[c.y][c.x].rightW = false;
					cells.push(maze[c.y][c.x+1]);
				} else if (r == 1) {
					maze[c.y][c.x].bottomW = false;
					cells.push(maze[c.y+1][c.x]);
				} else if (r == 2) {
					maze[c.y][c.x-1].rightW = false;
					cells.push(maze[c.y][c.x - 1]);
				} else if (r == 3) {
					maze[c.y-1][c.x].bottomW = false;
					cells.push(maze[c.y - 1][c.x]);
				} else {
					cells.pop();
				}
				maze[c.y][c.x].visited = true;

			}
		}

	}
}
