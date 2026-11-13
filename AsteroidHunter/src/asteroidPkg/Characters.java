
import java.util.HashMap;

public abstract class Characters {
    private String name;
    private Attacks[] moveSet;
    private HashMap<String, Integer> stats;
    //Basic attack for all characters.
    private Attacks attack = new Attacks("Light Saber Slash", 10 * stats.get("Power"));
    public Characters(String name, Attacks[] moveSet, HashMap<String, Integer> stats) {
        this.name = name;
        this.moveSet = moveSet;
        this.stats = stats;
    
    }
    //Primarily for Player class.
    public Characters(){
        this.moveSet = new Attacks[] {attack};
        this.stats = new HashMap<String, Integer>() {
            {
                put("Health", 100);
                put("Power", 10);
            }
        };
    }
    public void takeDamage(int damage) {
        stats.put("Health",stats.get("Health") - damage);
    }
    public void attack(Characters target) {
        target.takeDamage(this.attack.getDamage());
    }
    public String getName() {
        return name;
    }
    public Attacks[] getMoveSet() {
        return moveSet;
    }
    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void attack(Characters target, Attacks attack) {
        
    }
}