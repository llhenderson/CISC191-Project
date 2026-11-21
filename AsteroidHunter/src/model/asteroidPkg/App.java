import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class App {

	public static void main(String[] args) {
		
		int rowCount = 21;
		int columnCount = 19; 
		int tileSize = 32;
		int boardWidth = columnCount * tileSize;
		int boardHeight = rowCount * tileSize; 
		
		JFrame frame = new JFrame("Asteroid Hunter");
		frame.setSize(boardWidth,boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingUtilities.invokeLater(() -> {
            new BackgroundFrame("../resources/Battle_Image2.png",true, new Player()).setVisible(true);            
        });


	}

}