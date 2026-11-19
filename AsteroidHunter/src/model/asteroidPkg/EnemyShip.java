import java.util.ArrayList;
import java.util.PriorityQueue;
import java.awt.Image;

public class EnemyShip extends AsteroidHunterShip
{
	private ArrayList<EnemyCombatant> enemies;
	private int startX = 200; // xPos of asteroid
	private int startY = 200; // yPos of asteroid
	
	public EnemyShip(ArrayList<EnemyCombatant> initEnemies, Image initImage, int initXPos, int initYPos, int initWidth, int initHeight)
	{
		super(initImage, initXPos, initYPos, initWidth, initHeight);
		this.enemies = initEnemies;
	}

	public ArrayList<EnemyCombatant> getEnemies()
	{
		return this.enemies;
	}
	
	public void move(int x, int y)
	{
		this.x_position += this.velocityX;
		this.y_position += this.velocityY;
	}


	public int shortestPathToPlayerShip(PlayerShip targetShip, Asteroid asteroid, int map[][], int numAsteroids)
	{
		// Path finding algorithm
		// Chasing playerShip
		
		

		// if (playerEncounter(targetShip))
		// {
		// 	return;
		// }
	}

	public void updateDirection()
	{
		if (velocityX > 0 && velocityY == 0)
		{
			this.direction = 'R';
		}
		else if (velocityX < 0 && velocityY == 0)
		{
			this.direction = 'L';
		}
		else if (velocityX == 0 && velocityY < 0)
		{
			this.direction = 'U';
		}
		else if (velocityX == 0 && velocityY > 0)
		{
			this.direction = 'D';
		}
	}

	public boolean collision(Block a, Asteroid asteroid)
	{
		return a.x < asteroid.x_position + asteroid.width &&
			   a.x + a.width > asteroid.x_position &&
			   a.y < asteroid.y_position + asteroid.height &&
			   a.y + a.height > asteroid.y_position;
	}

	public boolean playerEncounter(PlayerShip targetShip)
	{
		return this.x_position < targetShip.x_position + targetShip.width &&
			   this.x_position + this.width > targetShip.x_position &&
			   this.y_position < targetShip.y_position + targetShip.height &&
			   this.y_position + this.height > targetShip.y_position;
	}

	public void reset()
	{
		this.x_position = startX;
		this.y_position = startY;
	}
}
