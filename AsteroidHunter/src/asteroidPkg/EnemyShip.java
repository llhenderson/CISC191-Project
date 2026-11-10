package asteroidPkg;

public class EnemyShip extends AsteroidHunterShip
{
	private ArrayList<EnemyCombatant> enemies;
	private int x_position = 0;
	private int y_position = 0;
	
	public EnemyShip(ArrayList<EnemyCombatants> initEnemies, int initXPos, int initYPos)
	{
		this.enemies = initEnemies;
		this.x_position = initXPos;
		this.y_position = initYPos;
	}

	public ArrayList<EnemyCombatant> getEnemies()
	{
		return this.enemies;
	}

	public int getXPos()
	{
		return this.x_position;
	}

	public int getYPos()
	{
		return this.y_position;
	}
	
	public void move(int x, int y)
	{
		this.x_position += x;
		this.y_position += y;
	}
}
