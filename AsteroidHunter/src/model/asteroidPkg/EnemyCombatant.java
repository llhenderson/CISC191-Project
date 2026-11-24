import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnemyCombatant extends Characters {
    List<Attacks> knownHumanMoves = new ArrayList<>();
    public EnemyCombatant() {
        super();
    }
    public EnemyCombatant(String name, Attacks[] moveset, HashMap<String, Double> stats) {
        super(name,moveset,stats);
    }

    public Double min_max_helper(Attacks attack, Player player, EnemyCombatant enemy, int activePlayer,int depth){
        // Initial maximizing - computer
        // Initial minimizing - human
        // Score to maximize is the computer health - human health
        Double max = 0.0;
        Double min = 200.0;
        if(depth ==0 || player.getStats().get("Health")==0){
            return max;
        }

        //player is computer
        if(activePlayer ==1) {
            for (Attacks knownHumanMove : knownHumanMoves) {
                Double eval = min_max_helper(knownHumanMove, player, enemy, 0, depth-1);
                min = Math.min(min,eval);
            }
            return min;
        }
        //player is human
        if(activePlayer ==0) {
            for(Attacks computerMove : moveSet){
                Double eval = min_max_helper(computerMove, player, enemy, 1, depth-1);
                max = Math.max(max,eval);
            }
            return max;
        } else {
        return max;
        }
    }

    public Attacks choose_move(Player player, EnemyCombatant enemy){
        Attacks attack = enemy.getMoveSet()[0];
        Double value = 0.0; 
        for(Attacks move : enemy.getMoveSet()){
            Double eval = min_max_helper(move,player,enemy,1,3);
            if(eval > value){
                attack = move;
                value = eval;
            }
        }
        return attack;
    }
    
}