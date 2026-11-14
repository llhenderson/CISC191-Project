
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JPanel;

public class Map extends JPanel{
    private static final long serialVersionUID = 1L;
	private int rowCount = 21;
	private int columnCount = 19; 
	private int tileSize = 32;
	private int boardWidth = columnCount * tileSize;
	private int boardHeight = rowCount * tileSize;

    private Image AsteroidImage;
	private Image PlayerShipImage;
	private Image EnemyShipImage;
	private Image ItemImage;

	public void loadMap() {
			setPreferredSize(new Dimension(boardWidth, boardHeight));
	} 

}