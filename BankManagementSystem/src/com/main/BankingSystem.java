package com.main;

import java.util.Scanner;

public class BankingSystem {
	
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of customers: ");
        int numCustomers = scanner.nextInt();
        
        BankAccount[] accounts = new BankAccount[numCustomers];
        
        for (int i = 0; i < numCustomers; i++)
        {
            System.out.println("\nEnter details for customer " + (i+1));
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();  // consume newline
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter initial balance: ");
            double balance = scanner.nextDouble();
            
            accounts[i] = new BankAccount(accountNumber, customerName, balance);
        }
        
        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display all account details");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    for (BankAccount account : accounts) {
                        account.display();
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccNum = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == depositAccNum) {
                            account.deposit(depositAmount);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccNum = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == withdrawAccNum) {
                            account.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
