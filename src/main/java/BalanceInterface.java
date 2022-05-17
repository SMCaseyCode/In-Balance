import java.util.Scanner;


public class BalanceInterface {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an expression to test if balanced:");
        String userInput = scan.nextLine();

        System.out.println(userInput);

    }

}