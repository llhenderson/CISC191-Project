import java.util.ArrayList;

public class EnemyShip extends AsteroidHunterShip
{
	private ArrayList<EnemyCombatant> enemies;
	private int x_position = 0;
	private int y_position = 0;
	
	public EnemyShip(ArrayList<EnemyCombatant> initEnemies, int initXPos, int initYPos)
	{
		super(initXPos, initYPos);
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
}
