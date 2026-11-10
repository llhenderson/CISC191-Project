
import java.util.HashMap;

public abstract class Characters {
    private String name;
    private String[] moveSet;
    private HashMap<String, Integer> stats;

    public Characters(String name, String[] moveSet, HashMap<String, Integer> stats) {
        this.name = name;
        this.moveSet = moveSet;
        this.stats = stats;
    }
    
}