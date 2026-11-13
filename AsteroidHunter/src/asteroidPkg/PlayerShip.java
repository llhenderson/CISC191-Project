
public class PlayerShip extends AsteroidHunterShip
{
	private Player player;
	private int x_position = 0;
	private int y_position = 0;
	
	public PlayerShip(Player initPlayer, int initXPos, int initYPos)
	{
		super(initXPos, initYPos);
		this.player = initPlayer;
	}

	public Player getPlayer()
	{
		return this.player;
	}
	
	public void move(int x, int y)
	{
		this.x_position += x;
		this.y_position += y;
	}
	
	public void pickupItem(String gameItem)
	{
		player.pickupItem(gameItem);
	}
}
