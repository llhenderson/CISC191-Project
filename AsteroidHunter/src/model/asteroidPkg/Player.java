
import java.util.HashMap;

public class Player extends Characters {
    private HashMap<String, Integer> items;
    public Player() {

        super();
    }
    public Player(String name, Attacks[] moveset, HashMap<String, Double> stats, HashMap<String, Integer> items) {
        super(name,moveset,new HashMap<String, Double>(){
            {
                put("Health", 100.0);
                put("Power", 10.0);
                put("Defense", 5.0);
            }
        });
        this.items = items;
    }
    
    public void pickupItem(String gameItem){
        if(items.containsKey(gameItem)){
            items.put(gameItem, items.get(gameItem) + 1);
        } else {
            items.put(gameItem, 1);
        }
    }

    public boolean isDefeated()
    {
        HashMap<String, Integer> currentStats = this.getStats();
        if (currentStats.get("Health") == 0)
        {
            return true;
        }
        return false;
    }
}