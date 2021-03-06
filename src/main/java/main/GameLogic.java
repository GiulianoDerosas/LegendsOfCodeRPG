package main;
import java.util.Scanner;

public class GameLogic {


    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;

//    Random encounter
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

//    Enemy names
    public static String[] enemies = {"Electric Death Snake", "Solid State Depreciator", "Electric Death Snake", "Rebel Router", "Saboteur Server"};

//    Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"The Server Room", "The Blockchain", "The Starbucks of Hate", "The Throne Room"};



//    Method that gets user input from console
    public static int readInt(String prompt, int userChoices){
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            } catch(Exception e){
                input = -1;
                System.out.println("Please enter a number!");
            }
        } while(input < 1 || input > userChoices);
        return input;
    }
    //    ______________________________________________________________________________


//    Method that will faux clear the console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }
    //    ______________________________________________________________________________


//    Method that will print a separator
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }
    //    ______________________________________________________________________________


//    Method that will print a header
    public static void printHeader(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    //    ______________________________________________________________________________


//    Method that waits for user input
    public static void pressToContinue(){
        System.out.println("Type anything to continue...");
        scanner.next();
    }
    //    ______________________________________________________________________________


//    Method that will start the game
    public static void startGame(){
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("LEGENDS OF CODE");
        System.out.println("TEXT BASED RPG BY GIULIANO");
        printSeparator(30);
        printSeparator(40);
        pressToContinue();


//        Get the players name
        do {
            clearConsole();
            printHeader("What's your name?");
            name = scanner.next();
            clearConsole();
            printHeader("Your name is " + name + ". Is that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I wanna change my name.");
            int input = readInt("-->", 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);
    //    ______________________________________________________________________________


//        Create the Story Intro
        Story.printIntro();
//        Create ACT1 intro
        Story.printFirstActIntro();
    //    ______________________________________________________________________________


//        Create a new player object with inputted name
        player = new Player(name);
//        set isRunning to equal true so the game loop can begin
        isRunning = true;
//        Start main game loop
        gameLoop();
    }
    //    ______________________________________________________________________________

    //        Main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("--> ", 3);
            if (input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
    //    ______________________________________________________________________________


    //        Method that checks the act
    public static void checkAct(){
//        Changes the act based on the players xp
        if(player.xp >= 10 && act == 1){
            act = 2;
            place = 1;

//            Prints next part of the story
            Story.printFirstActOutro();
//            Let's the player add a new trait (Level up)
            player.chooseTrait();
//            Prints the next part of the story
            Story.printSecondActIntro();
//            Assign new values to the battles
            enemies[0] = "Terror Token";
            enemies[1] = "Consensus Criminal";
            enemies[2] = "Adversary Altcoin";
            enemies[3] = "Terror Token";
            enemies[4] = "Guerrilla Genesis Block";
//            Assign new values to the encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        }
        else if (player.xp >= 50 && act == 2){
            act = 3;
            place = 2;

//            Prints next part of the story
            Story.printSecondActOutro();
//            Let's the player add a new trait (Level up)
            player.chooseTrait();
//            Prints the next part of the story
            Story.printThirdActIntro();
//            Assign new values to the battles
            enemies[0] = "Hipster Henchman";
            enemies[1] = "Giga-Hipster Henchman";
            enemies[2] = "Macchiato Monster";
            enemies[3] = "Disfigured Mermaid";
            enemies[4] = "Sergeant Steam-Wand";
//            Assign new values to the encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Shop";
//            Fully heal the player
            player.hp = player.maxHp;
        }
        else if (player.xp >= 100 && act == 3){
            act = 4;
            place = 3;

//            Prints next part of the story
            Story.printThirdActOutro();
//            Let's the player add a new trait (Level up)
            player.chooseTrait();
//            Prints the next part of the story
            Story.printFourthActIntro();
//            Fully heal the player
            player.hp = player.maxHp;
//            Calling the final battle vs QUANTUM CODER
            finalBattle();
        }
    }
    //    ______________________________________________________________________________


//        Method to create a random encounter
    public static void randomEncounter(){
//        Creates a random number between 0 and the array length
        int encounter = (int) (Math.random()* encounters.length);
        if(encounters[encounter].equals("Battle")) {
            randomBattle();
        }
        else if(encounters[encounter].equals("Rest")){
            rest();
        }
        else{
            shop();
        }
    }
    //    ______________________________________________________________________________


//        Method to continue the journey
    public static void continueJourney(){
        checkAct();
//        Checks that you're not in the final act
        if(act != 4)
            randomEncounter();
    }
    //    ______________________________________________________________________________


    //        Method to create a random battle
    public static void randomBattle(){
        clearConsole();
        printHeader("You encountered an evil foe! Time to fight!");
        pressToContinue();
//        Adds a new enemy with a random name
        battle(new Enemy(enemies[(int) (Math.random()*enemies.length)], player.xp));
    }
    //    ______________________________________________________________________________


    //        Battle method
    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeader(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeader(player.name + "\nHP: " + player.hp + "/" + player.maxHp);

//            Gives player a choice
            System.out.println("Choose an action:");
            printSeparator(20);
            System.out.println("(1) Fight \n(2) Use Potion \n(3) Run Away");
            int input = readInt("-->", 3);

//            Various actions based on user input
            if(input == 1){
//                Fight
                int dmg = player.attack() - enemy.defend();
                int dmgTaken = enemy.attack() - player.defend();
//                Check that damage taken isn't negative and add damage in case of huge defense
                if(dmgTaken < 0){
                    dmg -= dmgTaken / 2;
                    dmgTaken = 0;
                }
                if(dmg < 0)
                    dmg = 0;
                player.hp -= dmgTaken;
                enemy.hp -= dmg;

//            Show what happened during the battle
                clearConsole();
                printHeader("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeparator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTaken + " damage to you.");
                pressToContinue();

//                This will check to see if player is alive or dead. If dead, end the game.
                if(player.hp <= 0){
                    playerDied();
                    break;
                }else if(enemy.hp <=0){
//                    This will check to see if the enemy is alive or dead, if dead say player won.
                    clearConsole();
                    printHeader("You have defetead the " + enemy.name + "!");
//                    Increase the players xp if the enemy has been defeated.
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
//                    Adding the chance for a random drop at the end of battle
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int bitcoinGained = (int) (Math.random()*enemy.xp);
//                    if the boolean addRest is true add a rest to the player
                    if (addRest){
                        player.rests ++;
                        System.out.println("You just earned an additional rest!");
                    }
//                    Most enemies will drop but Math.random() has a chance to be zero
                    if (bitcoinGained > 0){
                        System.out.println("You collected " + bitcoinGained + " Bitcoin from the " + enemy.name);
                        player.bitcoin += bitcoinGained;
                    }
                    pressToContinue();
                    break;
                }
            }
            else if(input == 2){
//                Use a healing potion
                clearConsole();
//                Check to see if the player has any potions
                if(player.pots > 0 && player.hp < player.maxHp){
                    printHeader("Would you like to drink a potion? (" + player.pots + " left).");
                    System.out.println("(1) Yes!\n(2) No thanks.");
                    input = readInt("-->", 2);
//                    If the player choose yes restore their health to full
                    if (input == 1){
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeader("You drank a healing potion and restored your health to " + player.maxHp + "!");
                        pressToContinue();
                    }
                }
                else {
//                    Can't drink a potion due to one of the conditions above not being met
                    printHeader("You can't right now, you either have full HP or no potions!");
                    pressToContinue();
                }
            }
            else{
//                Run away
                clearConsole();
//                Checks that the player isn't in the final boss battle, as you can't flee from it.
                if (act != 4){
//                Create a chance to escape, this is fixed at 30%
                    if(Math.random()*10 + 1 <= 3){
                        printHeader("You ran away from the " + enemy.name + "!");
                        pressToContinue();
                        break;
                    }
                    else{
                        printHeader("You didn't manage to escape!");
//                  Make player take flee damage
                        int dmgTaken = enemy.attack();
                        System.out.println("As you were fleeing you took " + dmgTaken + " damage.");
                        pressToContinue();
//                  This will check to see if player is alive or dead. If dead, end the game.
                        if (player.hp <= 0)
                            playerDied();
                    }
                }
                else{
                    printHeader("YOU CANNOT ESCAPE THE WRATH OF THE QUANTUM CODER!");
                    pressToContinue();
                }
            }
        }
    }
    //    ______________________________________________________________________________


    //    Final battle
    public static void finalBattle(){
        battle(new Enemy("QUANTUM CODER", 300));
//        Prints the final part of the story
        Story.printEnd(player);
//        Ends the game loop
        isRunning = false;
    }
    //    ______________________________________________________________________________


    //    Add method so the player can shop
    public static void shop(){
        clearConsole();
        printHeader("You meet a hyper trader. \nHe shows you some of his wares:");
        int price = (int) Math.random()* (10 + player.pots*3) + 10 + player.pots;
        System.out.println("- Healing Potion: " + price + " bitcoin.");
        printSeparator(20);
//        Offer the purchase
        System.out.println("Would you like to buy a potion? \n(1) Yes! \n (2) No thanks.");
        int input = readInt("-->", 2);
        if (input == 1){
            clearConsole();
            if (player.bitcoin >= price) {
                printHeader("You have bought a healing potion for " + price + " bitcoin.");
                player.pots ++;
                player.bitcoin -= price;
            }
            else {
                printHeader("You don't have enough crypto to buy this!");
                pressToContinue();
            }
        }
    }
    //    ______________________________________________________________________________


//      Add method so the player can rest
    public static void rest(){
        clearConsole();
        if (player.rests >= 1){
            printHeader("Would you like to take a break " + player.name + "? (" + player.rests + " rest(s) left).");
            System.out.println("(1) Yes \n(2) Not right now.");
            int input = readInt("-->", 2);
            if (input == 1){
//                Player actually rests
                clearConsole();
                if (player.hp < player.maxHp){
                    int hpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.hp += hpRestored;
                    if (player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("You had a rest and restored " + hpRestored + " health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health");
                    player.rests --;
                }else
//                    Players health is already full
                    System.out.println("You're at full health, no need to rest now!");
                pressToContinue();
            }
        }
    }
    //    ______________________________________________________________________________


//    Print the main menu
    public static void printMenu(){
        clearConsole();
        printHeader(places[place]);
        System.out.println("Choose an action:");
        printSeparator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Stats");
        System.out.println("(3) Exit Game");
    }
    //    ______________________________________________________________________________


    //    Method that will end the game if the player dies
    public static void playerDied(){
        clearConsole();
        printHeader("You have been defeated!");
        printHeader("You earned " + player.xp + " XP on your quest for the hard drives." );
        System.out.println("Thanks for playing, try again and bring down the QUANTUM CODER!");
        isRunning = false;
    }
    //    ______________________________________________________________________________


//    Prints the characters stats
    public static void characterInfo(){
        clearConsole();
        printHeader("MENU");
        System.out.println(player.name + "HP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp + "\tBitcoin: " + player.bitcoin);
        printSeparator(20);
        System.out.println("Number of potions: " + player.pots);
        printSeparator(20);

//        Prints characters traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Attack traits: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defense traits: " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeparator(20);
        }
        pressToContinue();
    }
    //    ______________________________________________________________________________

}
