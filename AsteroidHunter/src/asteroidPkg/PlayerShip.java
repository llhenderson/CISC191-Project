package asteroidPkg;

import java.util.ArrayList;

public class PlayerShip extends AsteroidHunterShip
{
	//private Player player;
	private int x_position = 0;
	private int y_position = 0;
	private ArrayList<String> items;
	
	public PlayerShip(int initXPos, int initYPos)
	{
		x_position = initXPos;
		y_position = initYPos;
	}
	
	public void move(int x, int y)
	{
		x_position += x;
		y_position += y;
	}
	
	public void pickupItem(String gameItem)
	{
		items.add(gameItem);
	}
}
