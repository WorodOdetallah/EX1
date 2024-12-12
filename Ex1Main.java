package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                num1 = sc.next();
                if (!num1.equals("quit")) {
                    // Validate num1 format
                    if (!Ex1.isNumber(num1)) {
                        System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                        continue; // Go back to the beginning of the loop
                    }

                    // Prompt for the second number
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    if (num2.equals("quit")) break;

                    // Validate num2 format
                    if (!Ex1.isNumber(num2)) {
                        System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        continue; // Go back to the beginning of the loop
                    }

                    // Prompt for the base
                    System.out.println("Enter a base for output: (a number [2,16]) ");
                    int base;
                    try {
                        base = sc.nextInt();
                        if (base < 2 || base > 16) {
                            System.out.println("ERR: Base must be between 2 and 16!");
                            continue; // Invalid base, restart the loop
                        }
                    } catch (Exception e) {
                        System.out.println("ERR: Invalid base input!");
                        sc.next(); // Clear invalid input
                        continue; // Restart the loop
                    }

                    // Perform calculations
                    int val1 = Ex1.number2Int(num1);
                    int val2 = Ex1.number2Int(num2);

                    // Compute results
                    String sum = Ex1.int2Number(val1 + val2, base);
                    String product = Ex1.int2Number(val1 * val2, base);
                    String[] maxCandidates = {num1, num2, sum, product};
                    int maxIdx = Ex1.maxIndex(maxCandidates);


                    System.out.println(num1 + " + " + num2 + " = " + sum);
                    System.out.println(num1 + " * " + num2 + " = " + product);
                    System.out.println("Max number over " + java.util.Arrays.toString(maxCandidates) + " is: " + maxCandidates[maxIdx]);
                }

            }
        }
        System.out.println("quiting now...");
    }
}
