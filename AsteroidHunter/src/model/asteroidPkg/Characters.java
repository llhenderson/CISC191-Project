
import java.util.HashMap;

public abstract class Characters {
    private String name;
    public Attacks[] moveSet;
    public HashMap<String, Integer> stats;
    //Basic attack for all characters.
    public Characters(String name, Attacks[] moveSet, HashMap<String, Integer> stats) {
        this.name = name;
        this.moveSet = moveSet;
        this.stats = stats;
        //Attacks attack = new Attacks("Light Saber Slash", 10 * stats.get("Power"));
        //moveSet.push(attack);
    }
    //Primarily for Player class.
    public Characters(){        
        this.stats = new HashMap<String, Integer>() {
            {
                put("Health", 100);
                put("Power", 10);
            }
        };
        Attacks attack = new Attacks("Light Saber Slash", 10 * stats.get("Power"));
        this.moveSet = new Attacks[] {attack};

    }
    public void takeDamage(int damage) {
        stats.put("Health",stats.get("Health") - damage);
    }
    // public void attack(Characters target) {
    //     target.takeDamage(this.attack.getDamage());
    // }
    public String getName() {
        return name;
    }
    public Attacks[] getMoveSet() {
        return moveSet;
    }
    public int getSize(){
        return moveSet.length;
    }
    public HashMap<String, Integer> getStats() {
        return stats;
    }
    //For computer controlled enemies, the decision of which attack to use will be handled by a min-max
    //algorithm then the attack will be executed by this method.
    public void attack(Characters target, Attacks attack) {
        target.takeDamage(attack.getDamage());
    }
}