package simplerpg;

import java.util.Random;
import java.util.Scanner;

public class GameClass {
    public static Random rand = new Random();

    private Hero[] heroPattern = new Hero[3];
    private Monster[] monsterPattern = new Monster[3];

    private Hero mainHero;
    private Monster currentMonster;
    private int currentRound;


    public GameClass() {
        initGame();
    }

    public void mainGameLoop() {
        Scanner sc = new Scanner(System.in);
        int inpInt;
        System.out.println("Game Start!");

        System.out.println("Take Hero: ");
        for (int i = 0; i < 3; i++)
        {
            System.out.println((i + 1) + ". " + heroPattern[i].getName());
        }
           // inpInt = sc.nextInt();
            inpInt = 1;
            mainHero = (Hero)heroPattern[inpInt - 1].clone();
            System.out.println("Вы выбрали " + mainHero.getName());
        currentMonster = (Monster)monsterPattern[0].clone();

        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\nРаунд " + currentRound);
            mainHero.showInfo();
            currentMonster.showInfo();
            System.out.println("Ход игрока: " + "1. Attack 2. Defence 3. Sleep 9. Exit");
            inpInt = sc.nextInt();
            if (inpInt == 1) {
                currentMonster.getDamage(mainHero.makeAttack());
            }
            if (inpInt == 9) break;
            mainHero.getDamage(currentMonster.makeAttack());
            currentRound++;

            if (!currentMonster.isAlive)
            { System.out.println("Победил " + mainHero.getName());
              System.out.println(currentMonster.getName() + " погиб. " + mainHero.getName() + " получает 500 опыта.");
              mainHero.expGane(500);
              currentMonster = (Monster) monsterPattern[1].clone();
              System.out.println("На поле боя выходит: " + currentMonster.getName());
            }

            if(!mainHero.isAlive)
            {
                break;
            }
        }
        while (true);
if (!mainHero.isAlive) System.out.println("Победил " + currentMonster.getName());

        System.out.println("Игра завершена ");
    }

    public void initGame() {
        currentRound = 1;

        heroPattern[0] = new Hero("Knight", "Lanclot", 100, 10, 5);
        heroPattern[1] = new Hero("Barbarian", "Konan",200, 20, 0);
        heroPattern[2] = new Hero("Dwarf", "Gimli",100, 15, 20);

        monsterPattern[0] = new Monster("Humanoid", "Goblin",50, 5, 1);
        monsterPattern[1] = new Monster("Humanoid", "Orc",80, 6, 2);
        monsterPattern[2] = new Monster("Humanoid", "Troll",90, 5, 1);
    }
}
