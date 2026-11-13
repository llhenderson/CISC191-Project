
import java.util.HashMap;

public class Player extends Characters {
    HashMap<String, Integer> items;
    public Player(String name, String[] moveset, HashMap<String, Integer> stats, HashMap<String, Integer> items) {
        super(name,moveset,stats);
        this.items = items;
    }
    public void pickupItem(String gameItem){
        if(items.containsKey(gameItem)){
            items.put(gameItem, items.get(gameItem) + 1);
        } else {
            items.put(gameItem, 1);
        }
    }
    
}