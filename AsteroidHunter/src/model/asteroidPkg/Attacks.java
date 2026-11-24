public class Attacks {
    private String name;
    private double damage;
    
    public Attacks(String name, double damage) {
        this.name = name;
        this.damage = damage;
    }
    public double getDamage() {
        return damage;
    }
    public String getName() {
        return name;
    }
}