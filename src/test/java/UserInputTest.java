import main.GameLogic;

public class UserInputTest {

    public static void main(String[] args) {

//        GameLogic.printHeader("Testing this method!");
//        GameLogic.pressToContinue();
//        GameLogic.clearConsole();
//        int input = GameLogic.readInt("Enter 1, 2 or 3: ", 3);
//        System.out.println("You chose number " + input);

//        Testing drop rate calculation
        System.out.println((Math.random()*5 + 1<= 2.25));

//        Testing the price of pots, should increase as more pots are held by player
        int potBag1 = 1;
        int potBag2 = 2;
        int potBag3 = 3;

        int price = (int) (Math.random()* (10 + potBag1*3) + 10 + potBag1);
        System.out.println(price);

        int price2 = (int) (Math.random()* (10 + potBag2*3) + 10 + potBag2);
        System.out.println(price2);

        int price3 = (int) (Math.random()* (10 + potBag3*3) + 10 + potBag3);
        System.out.println(price3);

    }
}
