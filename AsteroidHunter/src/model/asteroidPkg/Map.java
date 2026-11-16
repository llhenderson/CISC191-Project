
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener, KeyListener {
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
	private Image BackgroundImageSpace;
	
	private String[] tileMap = {
	        "         A        A",
	        "A             A   A",
	        "    A            A ",
	        "        A       A  ",
	        "           A       ",
	        "    A              ",
	        "               A   ",
	        "     A             ",
	        "               A   ",
	        "          A        ",
	        "   A             A ",
	        "          A        ",
	        "                   ",
	        "     A          A  ",
	        "A            A     ",
	        "       A        A  ",
			" A                 ",
			"    A     A     A  ",
	        "     A             ",
	        "      A      A     ",
	        "   A             A "
	    };
	HashSet<Block> asteroids;
	//Need to create Hashsets for PlayerShip, EnemyShip, and Items.
	
	Timer gameLoop;
	Map() {

			
			setPreferredSize(new Dimension(boardWidth, boardHeight));
			//pulling the image for the space background
			java.net.URL imageUrl = getClass().getResource("../resources/Space.png");
			if (imageUrl != null) {
				BackgroundImageSpace = new ImageIcon(imageUrl).getImage();
			}
			addKeyListener(this);
			setFocusable(true);
			//PlayerShipImage = new ImageIcon(getClass().getResource("../model/resources/Asteroid.png")).getImage();
			AsteroidImage = new ImageIcon(getClass().getResource("../resources/Asteroid.png")).getImage();
			
			loadMap();

			gameLoop = new Timer(60, this);
			gameLoop.start();
	} 
	public void loadMap() {
		asteroids = new HashSet<Block>();
		//Blocks for other characters can be added here.
		for(int r = 0; r < rowCount; r++ ) {
			for(int c=0; c < columnCount; c++) {
				String row = tileMap[r];
				char tileType = row.charAt(c);

				int x = c*tileSize;
				int y = r*tileSize;
				if(tileType == 'A') {
					Block asteroid = new Block(AsteroidImage, x, y, tileSize,tileSize);
					asteroids.add(asteroid);
					} 
				//Make conditions for other characters
			}
		}
		
	}
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(java.awt.Graphics g) {
		for(Block asteroid : asteroids) {
			g.drawImage(asteroid.image, asteroid.x, asteroid.y, asteroid.width, asteroid.height, null);
		}
	}
    	@Override 
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}