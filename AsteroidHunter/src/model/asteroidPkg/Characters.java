
import java.util.HashMap;

public abstract class Characters {
    private String name;
    public Attacks[] moveSet;
    public HashMap<String, Double> stats;
    //Basic attack for all characters.
    public Characters(String name, Attacks[] moveSet, HashMap<String, Double> stats) {
        this.name = name;
        this.moveSet = moveSet;
        this.stats = stats;
        //Attacks attack = new Attacks("Light Saber Slash", 10 * stats.get("Power"));
        //moveSet.push(attack);
    }
    //Primarily for Player class.
    public Characters(){        
        this.stats = new HashMap<String, Double>() {
            {
                put("Health", 100.0);
                put("Power", .75);
            }
        };
        Attacks attack = new Attacks("Light Saber Slash", 10 * stats.get("Power"));
        this.moveSet = new Attacks[] {attack};

    }
    public void takeDamage(double damage) {
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
    public HashMap<String, Double> getStats() {
        return stats;
    }
    //For computer controlled enemies, the decision of which attack to use will be handled by a min-max
    //algorithm then the attack will be executed by this method.
    public void attack(Characters target, Attacks attack) {
        System.out.println(target+" is attacked with " + attack.getName());
        target.takeDamage(attack.getDamage());
        if(target instanceof EnemyCombatant enemy) {
            enemy.knownHumanMoves.add(attack);
        }
    }
}