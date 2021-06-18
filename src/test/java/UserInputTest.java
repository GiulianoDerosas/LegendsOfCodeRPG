import main.GameLogic;

public class UserInputTest {

    public static void main(String[] args) {

        GameLogic.printHeader("Testing this method!");
        GameLogic.pressToContinue();
        GameLogic.clearConsole();
        int input = GameLogic.readInt("Enter 1, 2 or 3: ", 3);
        System.out.println("You chose number " + input);

    }
}
