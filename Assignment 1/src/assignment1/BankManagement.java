package assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class BankAccount {
    private String accountHolder;
    private long accountNumber;
    private String accountType;
    private double balance;

    public BankAccount(String accountHolder, long accountNumber, String accountType, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero");
        }
        balance += amount;
        System.out.println("Rs. " + amount + " deposited successfully");
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdraw amount must be greater than zero");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Available: Rs. " + balance);
        }
        balance -= amount;
        System.out.println("Rs. " + amount + " withdrawn successfully");
    }

    public double getBalance() {
        return balance;
    }

    public void showDetails() {
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : Rs. " + balance);
    }
}

public class BankManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        int choice = 0;

        do {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 2 && choice <= 5 && account == null) {
                    System.out.println("Please create an account first");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter account holder name: ");
                        String holderName = sc.nextLine();
                        System.out.print("Enter account number: ");
                        long accNo = sc.nextLong();
                        sc.nextLine();
                        System.out.print("Enter account type (Savings/Current): ");
                        String accType = sc.nextLine();
                        System.out.print("Enter opening balance: ");
                        double openingBal = sc.nextDouble();
                        if (openingBal < 0) {
                            throw new InvalidAmountException("Opening balance cannot be negative");
                        }
                        account = new BankAccount(holderName, accNo, accType, openingBal);
                        System.out.println("Account created successfully");
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        account.deposit(sc.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        account.withdraw(sc.nextDouble());
                        break;
                    case 4:
                        System.out.println("Current balance: Rs. " + account.getBalance());
                        break;
                    case 5:
                        account.showDetails();
                        break;
                    case 6:
                        System.out.println("Thank you for banking with us");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only");
                sc.nextLine();
            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 6);

        sc.close();
    }
}
