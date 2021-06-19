package main;

public class Player extends Character {

//    Integers to define how many skills are in each path
    public int numAtkUpgrades, numDefUpgrades;

//    Adding bitcoin, rests & healing potions to the player
    int bitcoin, rests, pots;

//    Arrays to store skills
    public String[] atkUpgrades = {"Offensive: 100WPM Typing Gloves", "Offensive: RGB Trainers", "Offensive: 1337 H4cK3r H4nD5", "Offensive: Gigabit Gauntlet"};
    public String[] defUpgrades = {"Defensive: Firewall", "Defensive: VPN Shield", "Defensive: 2FAuthentication Helm", "Defensive: SHA256 Force Field"};

    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        this.bitcoin = 5;
        this.rests = 1;
        this.pots = 0;
        chooseTrait();
    }

//    Player specific methods
    @Override
    public int attack() {
//        If xp = 10, attack will return the value 8.5*(0.0-1.0) + 4 with one upgraded offensive trait.
//        If xp = 50, attack will return the value 24.5*(0.0-1.0) + 12 with three upgraded offensive trait.
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 +numAtkUpgrades + 1);
    }
    //    ______________________________________________________________________________


    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeader("Choose a trait: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
//        Gets the players choice of trait
        int input = GameLogic.readInt("-->", 2);
        GameLogic.clearConsole();

        if(input == 1){
            GameLogic.printHeader("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else{
            GameLogic.printHeader("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.pressToContinue();
    }
    //    ______________________________________________________________________________
}
