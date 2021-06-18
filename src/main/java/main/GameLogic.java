package main;
import java.util.Scanner;

public class GameLogic {

    static Scanner scanner = new Scanner(System.in);

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

//    Method that will faux clear the console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

//    Method that will print a separator
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

//    Method that will print a header
    public static void printHeader(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

//    Method that waits for user input
    public static void pressToContinue(){
        System.out.println("Type anything to continue...");
        scanner.next();
    }

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
        }
    }

}
