
public class PlayerShip extends AsteroidHunterShip
{
	private Player player;
	private Asteroid asteroid;
	private final int startX = 200;
	private final int startY = 200;
	
	public PlayerShip(Player initPlayer, int initXPos, int initYPos, int initVelocityX, int initVelocityY, char initDirection)
	{
		super(initXPos, initYPos, initVelocityX, initVelocityY, initDirection);
		this.player = initPlayer;
	}

	public Player getPlayer()
	{
		return this.player;
	}
	
	public void move(int x, int y)
	{
		this.x_position += this.velocityX;
		this.y_position += this.velocityY;
	}

	public void updateVelocity()
	{
		if (this.direction == 'U')
		{
			this.velocityX = 0;
			this.velocityY = -50; // FIXME
		}
		else if (this.direction == 'D')
		{
			this.velocityX = 0;
			this.velocityY = 50; // FIXME
		}
		else if (this.direction == 'L')
		{
			this.velocityX = -50; // FIXME
			this.velocityY = 0;
		}
		else if (this.direction == 'R')
		{
			this.velocityX = 50; // FIXME
			this.velocityY = 0;
		}
	}

	public void updateDirection(char direction)
	{
		char prevDirection = this.direction;

		this.direction = direction;
		updateVelocity();
		this.x_position += this.velocityX;
		this.y_position += this.velocityY;
		if (collision(this, asteroid))
		{
			this.x_position -= this.velocityX;
			this.y_position -= this.velocityY;
			this.direction = prevDirection;
			updateVelocity();
		}
	}

	public boolean enemyEncounter(EnemyShip enemy)
	{
		return this.x_position < enemy.x_position + enemy.width &&
			   this.x_position + this.width > enemy.x_position &&
			   this.y_position < enemy.y_position + enemy.height &&
			   this.y_position + this.height > enemy.y_position;
	}

	public boolean collision(AsteroidHunterShip ship, Asteroid asteroid)
	{
		return this.x_position < asteroid.x_position + asteroid.width &&
			   this.x_position + this.width > asteroid.x_position &&
			   this.y_position < asteroid.y_position + asteroid.height &&
			   this.y_position + this.height > asteroid.y_position;
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
