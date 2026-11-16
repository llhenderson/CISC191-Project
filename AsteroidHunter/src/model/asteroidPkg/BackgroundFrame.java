import java.awt.*;
import javax.swing.*;

public class BackgroundFrame extends JFrame {
    private int rowCount = 21;
	private int columnCount = 19; 
	private int tileSize = 32;
	private int boardWidth = columnCount * tileSize;
	private int boardHeight = rowCount * tileSize;
    public BackgroundFrame() {
	 
        setSize(boardWidth, boardHeight);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel backgroundPanel = new ImagePanel("../resources/Space.png");
        backgroundPanel.setLayout(new BorderLayout());

        Map gamePanel = new Map();
        gamePanel.setOpaque(false);

        backgroundPanel.add(gamePanel, BorderLayout.CENTER);
        setContentPane(backgroundPanel);
        //backgroundPanel.add(new Map(), BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

}
// Map pacmanGame = new Map();
// 		frame.add(pacmanGame);
// 		frame.pack();
// 		pacmanGame.requestFocus();
// 		frame.setVisible(true);
class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Scale image to fill panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}