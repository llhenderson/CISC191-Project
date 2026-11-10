package asteroidPkg;

import java.util.ArrayList;

public class PlayerShip extends AsteroidHunterShip
{
	private Player player;
	private int x_position = 0;
	private int y_position = 0;
	
	public PlayerShip(Player initPlayer, int initXPos, int initYPos)
	{
		this.player = initPlayer;
		this.x_position = initXPos;
		this.y_position = initYPos;
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
	
	public void pickupItem(String gameItem)
	{
		player.storeItem(gameItem);
	}
}
