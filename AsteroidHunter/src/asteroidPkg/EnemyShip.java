package asteroidPkg;

public class EnemyShip extends AsteroidHunterShip
{
	//private ArrayList<EnemyCombatants> Enemies;
	private int x_position = 0;
	private int y_position = 0;
	
	public EnemyShip(int initXPos, int initYPos)
	{
		x_position = initXPos;
		y_position = initYPos;
	}
	
	public void move(int x, int y)
	{
		x_position += x;
		y_position += y;
	}
}
