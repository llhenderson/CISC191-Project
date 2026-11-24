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
		Player player = new Player();
		EnemyCombatant enemy = new EnemyCombatant();
		SwingUtilities.invokeLater(() -> {
			// Used to test certain panels
			new Battle(player, enemy).setVisible(true);
            //new BackgroundFrame("../resources/Battle.png",true, new Player()).setVisible(true);          
        });
		while(player.getStats().get("Health") > 0.0 && enemy.getStats().get("Health") >0.0){
			player.attack(enemy,player.getMoveSet()[0]);
		
			enemy.attack(player,enemy.choose_move(player, enemy));

		}  

	}

}