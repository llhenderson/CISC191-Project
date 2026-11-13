
public abstract class AsteroidHunterShip 
{
	protected int x_position = 0;
	protected int y_position = 0;
	protected int velocityX = 0;
	protected int velocityY = 0;
	protected char direction = 'R';
	
	public AsteroidHunterShip(int initXPos, int initYPos, int initVelocityX, int initVelocityY, char initDirection)
	{
		this.x_position = initXPos;
		this.y_position = initYPos;
		this.velocityX = initVelocityX;
		this.velocityY = initVelocityY;
		this.direction = initDirection;
	}

	protected int getXPos()
	{
		return this.x_position;
	}

	protected int getYPos()
	{
		return this.y_position;
	}

	public abstract void move(int x, int y);

	public abstract void updateVelocity();

	public abstract void reset();

}
