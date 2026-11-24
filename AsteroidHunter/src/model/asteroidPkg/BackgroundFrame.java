import java.awt.*;
import javax.swing.*;

public class BackgroundFrame extends JFrame {
    private int rowCount = 21;
	private int columnCount = 19; 
	private int tileSize = 32;
	private int boardWidth = columnCount * tileSize;
	private int boardHeight = rowCount * tileSize;
    private boolean battle = false;
    private boolean attacking = false;
    private Player player;
    public BackgroundFrame(String path,boolean battle, Player player) {
        this.player = player;
        setSize(boardWidth, boardHeight);
        

        ImagePanel backgroundPanel = new ImagePanel(path);
        backgroundPanel.setLayout(new BorderLayout());
        
        JPanel southContainer = new JPanel();
        southContainer.setOpaque(false);
        southContainer.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        //Will set condition to display attacksMovesPanel instead of optionsPanel
        JPanel activePanel = new JPanel(new GridLayout(2,2));
        activePanel.setPreferredSize(new Dimension(300,200));
        if(attacking) {
        
        for(int i = 0;i < player.getSize();i++){

            activePanel.add(new JButton(player.moveSet[i].getName()));
            
        }
        } else {
        Image attackImage = new ImageIcon("../resources/button-attack.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton attackOption = new JButton(new ImageIcon(attackImage));
        // attackImage.addActionListener(e -> {
        //     attacking=true;
        // });
        activePanel.add(attackOption);

        Image skillImage = new ImageIcon("../resources/button-skills.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton skillOption = new JButton(new ImageIcon(skillImage));
        activePanel.add(skillOption);

        Image itemsImage = new ImageIcon("../resources/button-items.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton itemsOption = new JButton(new ImageIcon(itemsImage));
        activePanel.add(itemsOption);

        Image retreatImage = new ImageIcon("../resources/button-retreat.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton retreatOption = new JButton(new ImageIcon(retreatImage));
        activePanel.add(retreatOption);
        }
        southContainer.add(activePanel);
        backgroundPanel.add(southContainer,BorderLayout.SOUTH);


        if(!battle){

        Map gamePanel = new Map();
        gamePanel.setOpaque(false);

        backgroundPanel.add(gamePanel, BorderLayout.CENTER);
        setContentPane(backgroundPanel);
        setLocationRelativeTo(null);
    }
    else {
        //add the actions
        setContentPane(backgroundPanel);
        setLocationRelativeTo(null);
    }   
    
    }
}
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