package droid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DroidTeam {
    private List<Droid> droids;
    private String name;
    private String teamName;

    public DroidTeam() {
        droids = new ArrayList<>();
    }

    public DroidTeam(String teamName) {
        this.teamName = teamName;
        droids = new ArrayList<>();
    }

    public void addDroid(Droid droid) {
        droids.add(droid);
    }

    public void removeDroid(Droid droid) {
        droids.remove(droid);
    }

    public List<Droid> getDroids() {
        return droids;
    }

    public boolean hasLivingDroids() {
        for (Droid droid : droids) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public void attackTeam(DroidTeam enemyTeam) {
        for (Droid droid : droids) {
            if (droid.isAlive()) {
                Droid target = enemyTeam.getRandomLivingDroid();
                droid.attack(target);
            }
        }
    }

    public Droid getRandomLivingDroid() {
        List<Droid> livingDroids = new ArrayList<>();
        for (Droid droid : droids) {
            if (droid.isAlive()) {
                livingDroids.add(droid);
            }
        }

        if (livingDroids.isEmpty()) {
            return null;
        }

        int randomIndex = new Random().nextInt(livingDroids.size());
        return livingDroids.get(randomIndex);
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
