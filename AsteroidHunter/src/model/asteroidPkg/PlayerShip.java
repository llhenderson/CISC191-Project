import java.awt.Image;
import java.util.HashMap;

public class PlayerShip extends AsteroidHunterShip
{
	private Player player;
	private HashMap<String, Integer> health;
	private final int tileSize = 32;
	private int startX = 10 * tileSize;
	private int startY = 3 * tileSize;
	
	public PlayerShip(Player initPlayer, Image initImage, int initXPos, int initYPos, int initWidth, int initHeight)
	{
		super(initImage, initXPos, initYPos, initWidth, initHeight);
		health.put("Health", 100);
		this.player = initPlayer;
	}

	public Player getPlayer()
	{
		return this.player;
	}
	
	public void move()
	{
		this.x_position += this.velocityX;
		this.y_position += this.velocityY;
	}

	public void updateVelocity()
	{
		if (this.direction == 'U')
		{
			this.velocityX = 0;
			this.velocityY = -tileSize / 4;
		}
		else if (this.direction == 'D')
		{
			this.velocityX = 0;
			this.velocityY = tileSize / 4; 
		}
		else if (this.direction == 'L')
		{
			this.velocityX = -tileSize / 4;
			this.velocityY = 0;
		}
		else if (this.direction == 'R')
		{
			this.velocityX = tileSize / 4;
			this.velocityY = 0;
		}
	}

	public void updateDirection(char direction, Asteroid asteroid, EnemyShip enemy)
	{
		char prevDirection = this.direction;

		this.direction = direction;
		updateVelocity();
		this.x_position += this.velocityX;
		this.y_position += this.velocityY;
		if (collision(this, asteroid))
		{
			// Update health of PlayerShip
			int currentHealth = health.get("Health");
			int newHealth = currentHealth - 20;
			health.put("Health", newHealth);

			// Cease PlayerShip movements
			this.x_position -= this.velocityX;
			this.y_position -= this.velocityY;
			this.direction = prevDirection;
			updateVelocity();
		}
		if (enemyEncounter(enemy))
		{
			// initiate battle
			if (player.isDefeated())
			{
				// Update health of PlayerShip
				int currentHealth = health.get("Health");
				int newHealth = currentHealth - 10;
				health.put("Health", newHealth);
			}
		}
	}

	public boolean enemyEncounter(EnemyShip enemy)
	{
		return this.x_position < enemy.x_position + enemy.width &&
			   this.x_position + this.width > enemy.x_position &&
			   this.y_position < enemy.y_position + enemy.height &&
			   this.y_position + this.height > enemy.y_position;
	}

	public boolean collision(Block a, Asteroid asteroid)
	{
		return a.x < asteroid.x + asteroid.width &&
			   a.x + a.width > asteroid.x &&
			   a.y < asteroid.y + asteroid.height &&
			   a.y + a.height > asteroid.y;
	}

	public void reset()
	{
		this.x_position = startX; 
		this.y_position = startY; 
	}

	public void pickupItem(String gameItem)
	{
		player.pickupItem(gameItem);
	}
}
