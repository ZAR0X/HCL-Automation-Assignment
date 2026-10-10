package assignment1;

import java.util.Scanner;

public class BasicMath {

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static double divide(int a, int b) {
        return (double) a / b;
    }

    static int remainder(int a, int b) {
        return a % b;
    }

    static int square(int n) {
        return n * n;
    }

    static int cube(int n) {
        return n * n * n;
    }

    static int absolute(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Basic Maths -----");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Remainder");
            System.out.println("6. Square");
            System.out.println("7. Cube");
            System.out.println("8. Absolute");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Sum = " + add(a, b));
                        break;
                    case 2:
                        System.out.println("Difference = " + subtract(a, b));
                        break;
                    case 3:
                        System.out.println("Product = " + multiply(a, b));
                        break;
                    case 4:
                        if (b == 0) {
                            System.out.println("Cannot divide by zero");
                        } else {
                            System.out.println("Quotient = " + divide(a, b));
                        }
                        break;
                    case 5:
                        if (b == 0) {
                            System.out.println("Cannot divide by zero");
                        } else {
                            System.out.println("Remainder = " + remainder(a, b));
                        }
                        break;
                }
            } else if (choice >= 6 && choice <= 8) {
                System.out.print("Enter a number: ");
                int n = sc.nextInt();

                switch (choice) {
                    case 6:
                        System.out.println("Square = " + square(n));
                        break;
                    case 7:
                        System.out.println("Cube = " + cube(n));
                        break;
                    case 8:
                        System.out.println("Absolute value = " + absolute(n));
                        break;
                }
            } else if (choice == 9) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice, try again");
            }
        } while (choice != 9);

        sc.close();
    }
}
