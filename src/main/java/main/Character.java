package main;

public abstract class Character {

//    Attributes all characters have
    public String name;
    public int maxHp, hp, xp;

    public Character(String name, int maxHp, int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = xp;
    }

//    Methods for every character
    public abstract int attack();
    public abstract int defend();
}
