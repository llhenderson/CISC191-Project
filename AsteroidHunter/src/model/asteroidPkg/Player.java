
import java.util.HashMap;

public class Player extends Characters {
    private HashMap<String, Integer> items;

    public Player(String name, Attacks[] moveset, HashMap<String, Integer> stats, HashMap<String, Integer> items) {
        super(name,moveset,new HashMap<String, Integer>(){
            {
                put("Health", 100);
                put("Power", 10);
                put("Defense", 5);
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
}