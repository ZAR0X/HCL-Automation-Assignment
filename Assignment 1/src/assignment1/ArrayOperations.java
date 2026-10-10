package assignment1;

import java.util.Scanner;

public class ArrayOperations {

    static int[] arr = new int[100];
    static int size = 0;

    static void display() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void insert(int pos, int value) {
        if (size == arr.length) {
            System.out.println("Array is full");
            return;
        }
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = value;
        size++;
        System.out.println("Element inserted");
    }

    static void delete(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position");
            return;
        }
        int deleted = arr[pos];
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println(deleted + " deleted");
    }

    static int linearSearch(int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int findMax() {
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countEvenOdd() {
        int even = 0, odd = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even count = " + even);
        System.out.println("Odd count = " + odd);
    }

    static void insertionSort() {
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        System.out.println("Array sorted");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        size = sc.nextInt();
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\n----- Array Menu -----");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even/Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter position (0 to " + size + "): ");
                    int pos = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    insert(pos, val);
                    break;
                case 2:
                    System.out.print("Enter position to delete: ");
                    delete(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    int index = linearSearch(key);
                    if (index == -1) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at index " + index);
                    }
                    break;
                case 4:
                    insertionSort();
                    display();
                    System.out.print("Enter element to search: ");
                    int bKey = sc.nextInt();
                    int bIndex = binarySearch(bKey);
                    if (bIndex == -1) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at index " + bIndex);
                    }
                    break;
                case 5:
                    if (size == 0) {
                        System.out.println("Array is empty");
                    } else {
                        System.out.println("Maximum value = " + findMax());
                    }
                    break;
                case 6:
                    countEvenOdd();
                    break;
                case 7:
                    insertionSort();
                    display();
                    break;
                case 8:
                    display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (choice != 9);

        sc.close();
    }
}
