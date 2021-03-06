package main;

public class Story {

    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("You are the last person standing after your coding bootcamp got obliterated by the QUANTUM CODER.");
        System.out.println("\nAll of your classmates, instructors and hard drives got banished to the quantum realm.");
        System.out.println("You are stranded in the spliced code fragments of a once perfect program.");
        System.out.println("\nAll you seek now, is revenge. You begin planning your journey to defeat the QUANTUM CODER and rescue the hard drives!");
        System.out.println("You can then use the data to re-digitise your friends!");

        GameLogic.pressToContinue();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - INTRO - THE SERVER ROOM");
        GameLogic.printSeparator(30);
        System.out.println("As you begin your journey you start travelling through the nearby server room to reach the main server switch.");
        System.out.println("The server room is now a very dangerous place. Cabling systems lay ripped apart and the airflow system has been de-activated.");
        System.out.println("\nAfter clambering through the room, you finally reach the server power switch.");
        System.out.println("You use all your might to flip the switch and restore power, the journey to defeat the QUANTUM CODER begins.");
        System.out.println("\nYou turn around, but the QUANTUM CODERs powers have turned the broken cabling into Electric Death Snakes, interesting.");
        System.out.println("\n");
        GameLogic.pressToContinue();
    }

    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - OUTRO - THE SERVER ROOM");
        GameLogic.printSeparator(30);
        System.out.println("You did it! You crossed the server room and you're still alive!");
        System.out.println("As you step out the exit, you're elated as you can breathe freely. Just as you exhale, you are warped into a cosmic blockchain.");
        System.out.println("\nYou feel a surge of energy and the experience you gained allows you to learn another trait!");
        System.out.println("\n");
        GameLogic.pressToContinue();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - INTRO - THE BLOCKCHAIN");
        GameLogic.printSeparator(30);
        System.out.println("You begin travelling across the compromised blocks of this once secure chain.");
        System.out.println("You collected some bitcoin from the evil you slain along the way.");
        System.out.println("\nLuckily you know that every once in a while a hyper trader comes across this network.");
        System.out.println("You also know exactly where the QUANTUM CODER is, the surge of energy blessed you with a vision.");
        System.out.println("\nBut you have to cross this chaotic universe first...");
        System.out.println("\n");
        GameLogic.pressToContinue();
    }

    public static void printSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - OUTRO - THE BLOCKCHAIN");
        GameLogic.printSeparator(30);
        System.out.println("You managed to cross the entire blockchain and you're still alive!");
        System.out.println("You are just a few dimensions away from your final destination; the Starbucks of Hate!");
        System.out.println("You know that you probably can't rest there, so you take a while to restore some health.");
        System.out.println("\nYou are warped to a new dimension. After all you've seen, you feel empowered to learn another trait.");
        System.out.println("\n");
        GameLogic.pressToContinue();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - INTRO - THE STARBUCKS OF HATE");
        GameLogic.printSeparator(30);
        System.out.println("You see the Starbucks of Hate in front of you.");
        System.out.println("As you stand in front of the gates, you know there's no going back.");
        System.out.println("You're disguised as a hipster and enter the store. You don't know how much time you have until someone discovers you!");
        System.out.println("The github stickers are starting to peel away from your macbook, fear begins to engulf you");
        System.out.println("All you can do know is fight for your life and pray to come out as the winner...");
        System.out.println("\n");
        GameLogic.pressToContinue();
    }


    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - OUTRO - THE STARBUCKS OF HATE");
        GameLogic.printSeparator(30);
        System.out.println("You have come so far. You defeated all of the QUANTUM CODERs controlled data.");
        System.out.println("As you stand in front of the door to his throne room, you gain a bout of confidence.");
        System.out.println("You recall your lost power and restore your health.");
        System.out.println("You drink a super-charged espresso and learn a new trait before entering the throne room.");
        System.out.println("\n");
        GameLogic.pressToContinue();
    }

    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT IV - INTRO - THE THRONE ROOM");
        GameLogic.printSeparator(30);
        System.out.println("You enter the throne room of the QUANTUM CODER.");
        System.out.println("Sat upon his throne, he stares you dead in the eye. You feel the darkness around you.");
        System.out.println("He takes out the RAMBLADE-4400Mhz, the fastest weapon known to man.");
        System.out.println("All you can do know is fight for your life. You think about why his throne room is called a throne room...");
        System.out.println("\nThen you realise your in the Starbucks of Hates' toilet. Things are about to get messy.");
        System.out.println("\n");
        GameLogic.pressToContinue();
    }

    public static void printEnd(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Congratulations, " + player.name + "! You defeated the QUANTUM CODER and saved the hard drives!");
        System.out.println("You connect the drives to your newly acquired super computer! (Thanks Quantum Coder!)");
        System.out.println("You re-digitise your friends and the bootcamp has been saved!");
        GameLogic.printSeparator(30);
        System.out.println("Hopefully you had fun!");
    }
}
