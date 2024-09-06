package utility.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {
    public int integer(String message) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean valid = false;

        while (!valid) {
            try {
                valid = true;
                System.out.print(message);
                number = scan.nextInt();
            } catch (InputMismatchException ime) {
                System.err.println("Invalid input");
                valid = false;
                scan.next();
            }
        }

        scan.close();

        return number;
    }
}
