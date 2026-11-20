import java.util.ArrayList;
import java.awt.Image;

public class EnemyShip extends AsteroidHunterShip
{
	private ArrayList<EnemyCombatant> enemies;
	private int startX = 200; // xPos of asteroid
	private int startY = 200; // yPos of asteroid
	private final int tileSize = 32;
	
	public EnemyShip(ArrayList<EnemyCombatant> initEnemies, Image initImage, int initXPos, int initYPos, int initWidth, int initHeight)
	{
		super(initImage, initXPos, initYPos, initWidth, initHeight);
		this.enemies = initEnemies;
	}

	public ArrayList<EnemyCombatant> getEnemies()
	{
		return this.enemies;
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
			this.velocityY = -tileSize / 3; 
		}
		else if (this.direction == 'D')
		{
			this.velocityX = 0;
			this.velocityY = tileSize / 3; 
		}
		else if (this.direction == 'L')
		{
			this.velocityX = -tileSize / 3; 
			this.velocityY = 0;
		}
		else if (this.direction == 'R')
		{
			this.velocityX = tileSize / 3; 
			this.velocityY = 0;
		}
		else
		{
			this.velocityX = 0;
			this.velocityY = 0;
		}
	}

	public void updateDirection(char direction)
	{
		this.direction = direction;
		updateVelocity();
		move();
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

	public void chasePlayerShip(int map[][], PlayerShip targetShip)
	{
		while (!playerEncounter(targetShip) || Math.abs(targetShip.x_position - this.x_position) < 7 && Math.abs(targetShip.y_position - this.y_position) < 7)
		{
			Astar.Pair enemyPair = new Astar.Pair(this.x_position, this.y_position);
			Astar.Pair targetPair = new Astar.Pair(targetShip.x_position, targetShip.y_position);
		
			// Return current direction of EnemyShip
			char currentDir = Astar.aStarAlgo(map, enemyPair, targetPair);
			
			updateDirection(currentDir);
		}
		if (playerEncounter(targetShip))
		{
			// initiate battle
		}
	}

	public boolean isDefeated(Player target)
	{
		reset();
		// Make enemyShip image disappear from screen
		// Make enemyShip explode and leave debris or make it explode and fade away
		return false;
	}
}
