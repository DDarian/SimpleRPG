package simplerpg;

public class Hero extends GameCharacter implements Cloneable {
    private int currentExp;
    private int expToNextLevel;

    public Hero (String _charClass, String _name, int _hp, int _attack, int _defense)
    {
        super(_charClass, _name, _hp, _attack, _defense);
        initHero();
        showFullInfo();
    }

    private void initHero() {
        currentExp = 0;
        expToNextLevel = 1000;
    }

    public void expGane(int _exp) {
        currentExp += _exp;
        if (currentExp > expToNextLevel) {
            currentExp -= expToNextLevel;
            expToNextLevel *= 2;
            level++;
            System.out.println(name + " повысил уровень до " + level);
        }
    }

    public void showFullInfo()
    {

    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование невозможно");
            return this;
        }
    }
}
