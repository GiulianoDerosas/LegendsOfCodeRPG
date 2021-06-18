package main;
import java.util.Scanner;

public class GameLogic {


    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;


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
        System.out.println("LEGENDS OF TEXTERRA");
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


//        Method to continue the journey
    public static void continueJourney(){
    }
    //    ______________________________________________________________________________


//    Print the main menu
    public static void printMenu(){
        clearConsole();
        printHeader("MENU");
        System.out.println("Choose an action:");
        printSeparator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Stats");
        System.out.println("(3) Exit Game");
    }
    //    ______________________________________________________________________________


//    Prints the characters stats
    public static void characterInfo(){
        clearConsole();
        printHeader("MENU");
        System.out.println(player.name + "HP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);

//        Prints characters traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive traits: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive traits: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
    }
    //    ______________________________________________________________________________

}
