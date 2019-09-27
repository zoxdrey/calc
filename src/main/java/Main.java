import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String expression = in.next();

        Calculate.calc(expression);
    }
}
