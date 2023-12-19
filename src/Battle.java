import droid.Droid;
import droid.DroidTeam;

class Battle {
    public static void oneOnOne(Droid droid1, Droid droid2) {
        System.out.println("Початкове здоров'я " + droid1.getName() + ": " + droid1.getHealth());
        System.out.println("Початкове здоров'я " + droid2.getName() + ": " + droid2.getHealth());

        while (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            int damage1 = droid1.getDamage();
            int damage2 = droid2.getDamage();

            droid2.takeDamage(damage1);
            droid1.takeDamage(damage2);

            System.out.println(droid1.getName() + " атакує " + droid2.getName() + " і завдає " + damage1 + " пошкодження.");
            System.out.println(droid2.getName() + " атакує " + droid1.getName() + " і завдає " + damage2 + " пошкодження.");

            int health1 = droid1.getHealth();
            int health2 = droid2.getHealth();

            if (health1 < 0) {
                health1 = 0;
            }
            if (health2 < 0) {
                health2 = 0;
            }

            System.out.println("Здоров'я " + droid1.getName() + ": " + health1);
            System.out.println("Здоров'я " + droid2.getName() + ": " + health2);
        }

        if (droid1.getHealth() > 0) {
            System.out.println(droid1.getName() + " перемагає!");
        } else {
            System.out.println(droid2.getName() + " перемагає!");
        }
    }
    public static void runTeamBattle(DroidTeam team1, DroidTeam team2) {
        while (atLeastOneTeamIsAlive(team1, team2)) {
            System.out.println("Перша команда атакує:");
            team1.attackTeam(team2);

            if (!atLeastOneTeamIsAlive(team1, team2)) {
                break;
            }

            System.out.println("Друга команда атакує:");
            team2.attackTeam(team1);
        }

        if (team1.hasLivingDroids()) {
            System.out.println("Перша команда перемагає!");
        } else {
            System.out.println("Друга команда перемагає!");
        }
    }


    public static boolean atLeastOneTeamIsAlive(DroidTeam team1, DroidTeam team2) {
        return team1.hasLivingDroids() && team2.hasLivingDroids();
    }
}

