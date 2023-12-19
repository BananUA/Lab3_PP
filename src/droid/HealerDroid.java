package droid;
/*
public class HealerDroid extends Droid {
    private int healingPower;

    public HealerDroid(String name, int health, int damage, int healingPower) {
        super(name, health, damage);
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }
    @Override
    public void heal(Droid target) {
        if (target instanceof HealerDroid) {
            int healthRestored = getHealingPower();
            ((HealerDroid) target).restoreHealth(healthRestored);
            System.out.println(getName() + " лікує " + target.getName() + " і відновлює " + healthRestored + " здоров'я.");
        } else {
            System.out.println(getName() + " не може лікувати цього дроїда.");
        }
    }

    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println(getName() + " отримує " + damage + " пошкодження.");
    }

    private void restoreHealth(int healthRestored) {
        int currentHealth = getHealth();
        int maxHealth = 100;
        if (currentHealth + healthRestored > maxHealth) {
            health = maxHealth;
        } else {
            health = currentHealth + healthRestored;
        }
    }

}
*/