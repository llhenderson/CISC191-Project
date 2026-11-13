
public abstract class AsteroidHunterShip 
{
	protected int x_position = 0;
	protected int y_position = 0;
	
	public AsteroidHunterShip(int initXPos, int initYPos)
	{
		this.x_position = initXPos;
		this.y_position = initYPos;
	}

	public abstract void move(int x, int y);

	protected int getXPos()
	{
		return this.x_position;
	}

	protected int getYPos()
	{
		return this.y_position;
	}

	// collision methods
}
