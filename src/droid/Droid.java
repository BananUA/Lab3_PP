package droid;

public class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Droid target) {
        int damageDealt = getDamage();
        target.takeDamage(damageDealt);
        System.out.println(getName() + " атакує " + target.getName() + " і завдає " + damageDealt + " пошкодження.");
    }

    public void heal(Droid target) {

    }

    public void defend() {

    }
}
