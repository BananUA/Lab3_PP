import droid.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<Droid> droids = new ArrayList<>();
        List<DroidTeam> teams = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Створення команди");
            System.out.println("3. Запустити бій 1 на 1");
            System.out.println("4. Запустити бій команда на команду");
            System.out.println("5. Додавання дроїда до команди");
            System.out.println("6. Список дроїдів");
            System.out.println("7. Вийти з програми");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Виберіть тип дроїда:");
                    System.out.println("1. AssaultDroid");
                    //System.out.println("3. HealerDroid");
                    System.out.println("2. DefenseDroid");
                    int droidTypeChoice = scanner.nextInt();

                    System.out.print("Введіть ім'я дроїда: ");
                    String name = scanner.next();
                    int damage;
                    Droid droid = null;

                    switch (droidTypeChoice) {
                        case 1:
                            System.out.print("Введіть здоров'я дроїда: ");
                            int health = scanner.nextInt();
                            System.out.print("Введіть шкоду дроїда: ");
                            damage = scanner.nextInt();
                            droid = new AssaultDroid(name, health, damage);
                            break;
                        /*case 3:
                            System.out.print("Введіть здоров'я дроїда: ");
                            int healerHealth = scanner.nextInt();
                            System.out.print("Введіть шкоду дроїда: ");
                            damage = scanner.nextInt();
                            System.out.print("Введіть healing power для HealerDroid: ");
                            int healingPower = scanner.nextInt();
                            droid = new HealerDroid(name, healerHealth, damage, healingPower);
                            break;*/
                        case 2:
                            System.out.print("Введіть кількість здоров'я: ");
                            int defenseHealth = scanner.nextInt();
                            System.out.print("Введіть шкоду дроїда: ");
                            damage = scanner.nextInt();
                            droid = new DefenseDroid(name, defenseHealth, damage);
                            break;
                        default:
                            System.out.println("Неправильний вибір типу дроїда.");
                            break;
                    }

                    if (droid != null) {
                        droids.add(droid);
                        System.out.println("Дроїд " + droid.getName() + " створено.");
                    }
                    break;

                case 2:
                    // Створення команди
                    System.out.println("Введіть назву команди: ");
                    String teamName = scanner.next();
                    DroidTeam newTeam = new DroidTeam(teamName);
                    teams.add(newTeam);

                    System.out.println("Команда " + teamName + " створена.");
                    break;

                case 3:
                    // Запуск бою 1 на 1
                    System.out.println("Оберіть двох дроїдів для бою:");
                    System.out.println("Виберіть першого дроїда:");
                    for (int i = 0; i < droids.size(); i++) {
                        System.out.println((i + 1) + ". " + droids.get(i).getName());
                    }
                    int droid1Index = scanner.nextInt() - 1;

                    System.out.println("Виберіть другого дроїда:");
                    for (int i = 0; i < droids.size(); i++) {
                        System.out.println((i + 1) + ". " + droids.get(i).getName());
                    }
                    int droid2Index = scanner.nextInt() - 1;

                    Battle.oneOnOne(droids.get(droid1Index), droids.get(droid2Index));
                    break;

                case 4:
                    if (teams.size() < 2) {
                        System.out.println("Потрібно мати щонайменше дві команди для бою.");
                    } else {
                        System.out.println("Оберіть першу команду:");
                        for (int i = 0; i < teams.size(); i++) {
                            System.out.println((i + 1) + ". " + teams.get(i).getTeamName());
                        }
                        int team1Index = scanner.nextInt() - 1;

                        System.out.println("Оберіть другу команду:");
                        for (int i = 0; i < teams.size(); i++) {
                            if (i != team1Index) {
                                System.out.println((i + 1) + ". " + teams.get(i).getTeamName());
                            }
                        }
                        int team2Index = scanner.nextInt() - 1;

                        DroidTeam team1 = teams.get(team1Index);
                        DroidTeam team2 = teams.get(team2Index);
                        Battle.runTeamBattle(team1, team2);
                    }

                    break;


                case 5:
                    if (droids.isEmpty() || teams.isEmpty()) {
                        System.out.println("Спочатку створіть дроїдів та команду.");
                    } else {
                        System.out.println("Оберіть команду для додавання дроїда:");
                        for (int i = 0; i < teams.size(); i++) {
                            System.out.println((i + 1) + ". " + teams.get(i).getTeamName());
                        }
                        int teamIndex = scanner.nextInt() - 1;

                        System.out.println("Оберіть дроїда для додавання до команди:");
                        for (int i = 0; i < droids.size(); i++) {
                            System.out.println((i + 1) + ". " + droids.get(i).getName());
                        }
                        int droidIndex = scanner.nextInt() - 1;

                        Droid selectedDroid = droids.get(droidIndex);
                        teams.get(teamIndex).addDroid(selectedDroid);

                        System.out.println(selectedDroid.getName() + " додано до команди " + teams.get(teamIndex).getTeamName());
                    }

                    break;

                case 6:
                    System.out.println("Список створених дроїдів:");
                    for (Droid d : droids) {
                        System.out.println("Ім'я: " + d.getName() + ", Здоров'я: " + d.getHealth() + ", Пошкодження: " + d.getDamage());
                    }
                    break;


                case 7:
                    // Вихід з програми
                    System.exit(0);
                    break;


                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }


        }
    }


}

