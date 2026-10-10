package assignment1;

import java.util.Scanner;

public class MatrixOperations {

    static Scanner sc = new Scanner(System.in);

    static int[][] readMatrix(int rows, int cols) {
        int[][] m = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }

    static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int[][] add(int[][] a, int[][] b) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }

    static int[][] subtract(int[][] a, int[][] b) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        return res;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    static int[][] transpose(int[][] a) {
        int[][] res = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[j][i] = a[i][j];
            }
        }
        return res;
    }

    static boolean isSquare(int[][] a) {
        return a.length == a[0].length;
    }

    static boolean isDiagonal(int[][] a) {
        if (!isSquare(a)) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j && a[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isIdentity(int[][] a) {
        if (!isDiagonal(a)) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("Enter rows and columns of matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        System.out.println("Enter elements of matrix A:");
        int[][] a = readMatrix(r1, c1);

        System.out.print("Enter rows and columns of matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        System.out.println("Enter elements of matrix B:");
        int[][] b = readMatrix(r2, c2);

        int choice;
        do {
            System.out.println("\n----- Matrix Menu -----");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Transpose of A");
            System.out.println("5. Check A is square");
            System.out.println("6. Check A is diagonal");
            System.out.println("7. Check A is identity");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (r1 == r2 && c1 == c2) {
                        System.out.println("A + B =");
                        printMatrix(add(a, b));
                    } else {
                        System.out.println("Order of both matrices must be same");
                    }
                    break;
                case 2:
                    if (r1 == r2 && c1 == c2) {
                        System.out.println("A - B =");
                        printMatrix(subtract(a, b));
                    } else {
                        System.out.println("Order of both matrices must be same");
                    }
                    break;
                case 3:
                    if (c1 == r2) {
                        System.out.println("A x B =");
                        printMatrix(multiply(a, b));
                    } else {
                        System.out.println("Columns of A must be equal to rows of B");
                    }
                    break;
                case 4:
                    System.out.println("Transpose of A =");
                    printMatrix(transpose(a));
                    break;
                case 5:
                    if (isSquare(a)) {
                        System.out.println("A is a square matrix");
                    } else {
                        System.out.println("A is not a square matrix");
                    }
                    break;
                case 6:
                    if (isDiagonal(a)) {
                        System.out.println("A is a diagonal matrix");
                    } else {
                        System.out.println("A is not a diagonal matrix");
                    }
                    break;
                case 7:
                    if (isIdentity(a)) {
                        System.out.println("A is an identity matrix");
                    } else {
                        System.out.println("A is not an identity matrix");
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (choice != 8);

        sc.close();
    }
}
