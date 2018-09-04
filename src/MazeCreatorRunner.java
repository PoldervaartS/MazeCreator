import java.awt.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MazeCreatorRunner extends JFrame{
	private final int WIDTH = 1280;
	private final int HEIGHT = 1020;

	public static void main(String[] args) {
		new MazeCreatorRunner();
	}
	
	public MazeCreatorRunner(){
		super("MazeCreator");
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		MazeCreator runner = new MazeCreator(100,100,WIDTH,HEIGHT,9);
		((Component) runner).setFocusable(true);
		getContentPane().add(runner);
	}

}
