package droid;

public class DefenseDroid extends Droid {
    public DefenseDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void defend() {
        System.out.println(getName() + " вступає в оборону.");
    }

    public void takeDamage(int damage) {
        int currentHealth = getHealth();
        health = currentHealth - (damage / 2);
        System.out.println(getName() + " отримує " + damage / 2 + " пошкодження внаслідок захисту.");
    }

}
