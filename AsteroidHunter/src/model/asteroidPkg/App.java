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
			// Used to test certain panels
			//new Battle(new Player(),new EnemyCombatant()).setVisible(true);
            new BackgroundFrame("../resources/Battle.png",true, new Player()).setVisible(true);            
        });

	}

}