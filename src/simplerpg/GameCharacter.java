package simplerpg;

import java.util.Random;

public class GameCharacter {
    public static Random rand = new Random();
    protected String name;
    protected String charClass;
    protected int hp;
    protected int hpMax;
    protected int attack;
    protected int defense;
    protected int critChance;
    protected int level;
    public boolean isAlive;

    public GameCharacter(String _charClass, String _name, int _hp, int _attack, int _defense)
    {
        name = _name;
        charClass = _charClass;
        hp = _hp;
        hpMax = _hp;
        attack = _attack;
        defense = _defense;
        level = 1;
        critChance = 10;
        isAlive = true;
    }

    public String getName() {
        return name;
    }

    public int makeAttack() {
        int minAttack = (int) (attack * 0.8f);
        int deltaAttack = (int) (attack * 0.4f);
        int currentAttack = minAttack + GameCharacter.rand.nextInt(deltaAttack);
        if (GameCharacter.rand.nextInt(100) < critChance)
        {
            currentAttack *= 2;
            System.out.println("Критический урон! " + name + " вмазал " + currentAttack + " урона.");
        }
        else System.out.println(name + " вмазал " + currentAttack + " урона.");
        return currentAttack;
    }

    public void getDamage(int _inputDamage) {
        System.out.println(name + " получил " + _inputDamage + " урона.");
        hp -= _inputDamage;
        if (hp < 1) {
            isAlive = false;
        }
    }

    public void showInfo()
    {
        System.out.println("Имя: " + getName() + " Здоровье: " + hp + "/" + hpMax + " Уровень " + level);
    }

}
