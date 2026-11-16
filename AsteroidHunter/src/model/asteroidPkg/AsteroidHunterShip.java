import java.awt.Image;

public abstract class AsteroidHunterShip extends Block
{
	protected int x_position = 0;
	protected int y_position = 0;
	protected int velocityX = 0;
	protected int velocityY = 0;
	protected int width = 0;
	protected int height = 0;
	protected char direction;

	public AsteroidHunterShip(Image initImage, int initXPos, int initYPos, int initWidth, int initHeight)
	{
		super(initImage, initXPos, initYPos, initWidth, initHeight);
		this.velocityX = 0;
		this.velocityY = 0;
		this.direction = 'R';
	}

	protected int getXPos()
	{
		return this.x_position;
	}

	protected int getYPos()
	{
		return this.y_position;
	}

	protected int getVelocityX()
	{
		return this.velocityX;
	}

	protected int getVelocityY()
	{
		return this.velocityY;
	}

	protected char getDirection()
	{
		return this.direction;
	}

	public abstract void move(int x, int y);

	public abstract void reset();

}
