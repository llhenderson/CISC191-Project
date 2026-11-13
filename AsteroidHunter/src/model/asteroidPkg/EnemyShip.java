import java.util.ArrayList;

public class EnemyShip extends AsteroidHunterShip
{
	private ArrayList<EnemyCombatant> enemies;
	private PlayerShip targetShip;
	private final int startX = 200; // xPos of asteroid
	private final int startY = 200; // xPos of asteroid
	
	public EnemyShip(ArrayList<EnemyCombatant> initEnemies, int initXPos, int initYPos, int initVelocityX, int initVelocityY, char initDirection)
	{
		super(initXPos, initYPos, initVelocityX, initVelocityY, initDirection);
		this.enemies = initEnemies;
	}

	public ArrayList<EnemyCombatant> getEnemies()
	{
		return this.enemies;
	}
	
	public void move(int x, int y)
	{
		this.x_position += x;
		this.y_position += y;
	}

	public void updateVelocity()
	{
		// start at 0
		// go at speed in which it will collide with PlayerShip
		// if PlayerShip yPos > EnemyShip yPos && PlayerShip xPos < EnemyShip xPos
			// EnemyShip velocityY < 0
		// else if PlayerShip yPos < EnemyShip yPos && PlayerShip xPos < EnemyShip xPos
			// EnemyShip velocityY > 0
		if (this.x_position - 50 < targetShip.x_position && targetShip.x_position < this.x_position && targetShip.y_position > this.y_position)
		{
			this.velocityY = -70;
		}
		else if (this.x_position - 50 < targetShip.x_position && targetShip.x_position < this.x_position && targetShip.y_position < this.y_position)
		{
			this.velocityY = 70;
		}
	}

	public void updateDirection()
	{
		if (velocityX == 0 && velocityY == 0)
		{
			this.direction = 'R';
		}
		else if (velocityY < 0)
		{
			this.direction = 'U';
		}
		else if (velocityY > 0)
		{
			this.direction = 'D';
		}
	}

	public void reset()
	{
		this.x_position = startX;
		this.y_position = startY;
	}
}
