
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Battle extends JFrame{
    private int rowCount = 21;
	private int columnCount = 19; 
	private int tileSize = 32;
	private int boardWidth = columnCount * tileSize;
	private int boardHeight = rowCount * tileSize;
    private boolean battle = false;
    private Player player;

    public Battle(Player player,EnemyCombatant enemy) {
    
      setSize(boardWidth, boardHeight);

        ImagePanel backgroundPanel = new ImagePanel("../resources/Battle.png");
        backgroundPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        //Player Health Panel
        JLabel playerName = new JLabel("Player Name");
        playerName.setFont(new Font("Arial",Font.BOLD,24));
        playerName.setForeground(Color.WHITE);
        JProgressBar playerHP = new JProgressBar(0,100);
        playerHP.setValue(player.stats.get("Health").intValue());
        playerHP.setStringPainted(true);
        JPanel playerHPPanel = new JPanel(new BorderLayout());
        playerHPPanel.setOpaque(false);
        playerHPPanel.add(playerName,BorderLayout.NORTH);
        playerHPPanel.add(playerHP,BorderLayout.CENTER);
        //Enemy Health Panel
        JLabel enemyName = new JLabel("Enemy Name");
        enemyName.setFont(new Font("Arial",Font.BOLD,24));
        enemyName.setForeground(Color.WHITE);
        JProgressBar enemyHP = new JProgressBar(0,100);
        enemyHP.setValue(100);
        enemyHP.setStringPainted(true);
        JPanel enemyHPPanel = new JPanel(new BorderLayout());
        enemyHPPanel.setOpaque(false);
        enemyHPPanel.add(enemyName,BorderLayout.NORTH);
        enemyHPPanel.add(enemyHP,BorderLayout.CENTER);
        backgroundPanel.add(enemyHPPanel,BorderLayout.NORTH);
        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);
        cards.setOpaque(false);

        JPanel options = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        options.setOpaque(false);
        //gbc.gridx = 1;
        //gbc.gridy = 0;

        Image attackImage = new ImageIcon("../resources/button-attack.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton attackOption = new JButton(new ImageIcon(attackImage));
        attackOption.setBorder(BorderFactory.createEmptyBorder());
        options.add(attackOption,gbc);

        
        //gbc.gridx = 1;
        //gbc.gridy = 1;
        Image skillImage = new ImageIcon("../resources/button-skills.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton skillOption = new JButton(new ImageIcon(skillImage));
        skillOption.setBorder(BorderFactory.createEmptyBorder());
        options.add(skillOption,gbc);

        //gbc.gridx = 2;
        //gbc.gridy = 1;
        Image itemImage = new ImageIcon("../resources/button-items.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton itemOption = new JButton(new ImageIcon(itemImage));
        itemOption.setBorder(BorderFactory.createEmptyBorder());
        options.add(itemOption,gbc);

        //gbc.gridx = 2;
        //gbc.gridy = 0;
        Image retreatImage = new ImageIcon("../resources/button-retreat.png").getImage().getScaledInstance(150,100, Image.SCALE_SMOOTH);
        JButton retreatOption = new JButton(new ImageIcon(retreatImage));
        retreatOption.setBorder(BorderFactory.createEmptyBorder());
        options.add(retreatOption,gbc);

        //MOVES
        JPanel moves = new JPanel(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();

        moves.setOpaque(false);
        //gbc2.gridx = 1;
        //gbc2.gridy = 0;

        if(player.getMoveSet().length ==1){
            Attacks move1 = player.getMoveSet()[0];
            JButton move1Button = new JButton(move1.getName());
            move1Button.addActionListener(e-> {
                player.attack(enemy,move1);
                enemyHP.setValue(enemy.getStats().get("Health").intValue());
                //System.out.println("Enemy health is now: " + enemy.stats.get("Health"));
            });
    
            moves.add(move1Button);
        }
        if(player.getMoveSet().length ==2){
            Attacks move2 = player.getMoveSet()[1];
            JButton move2Button = new JButton(move2.getName());
            moves.add(move2Button);
        }
        if(player.getMoveSet().length ==3){
            Attacks move3 = player.getMoveSet()[0];
            JButton move3Button = new JButton(move3.getName());
            moves.add(move3Button);
        }
        if(player.getMoveSet().length ==4){
            Attacks move4 = player.getMoveSet()[0];
            JButton move4Button = new JButton(move4.getName());
            moves.add(move4Button);
        }


        cards.add(options,"Options");

        attackOption.addActionListener(e -> {
            cardLayout.show(cards,"Moves");
        });
        cards.add(moves,"Moves");
        bottomPanel.add(playerHPPanel,BorderLayout.NORTH);
        bottomPanel.add(cards,BorderLayout.SOUTH);
        backgroundPanel.add(bottomPanel,BorderLayout.SOUTH);
        
        setContentPane(backgroundPanel);
        setLocationRelativeTo(null);
     }
    

}