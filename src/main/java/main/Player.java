package main;

public class Player extends Character {

//    Integers to define how many skills are in each path
    public int numAtkUpgrades, numDefUpgrades;

//    Arrays to store skills
    public String[] atkUpgrades = {"Battle Fury", "Noxian Might", "Primal Surge", "Wolf's Frenzy"};
    public String[] defUpgrades = {"Perseverance", "Bastion", "Courage", "Granite Shield"};

    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        chooseTrait();
    }

//    Player specific methods
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeader("Choose a trait: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2)");
    }
}