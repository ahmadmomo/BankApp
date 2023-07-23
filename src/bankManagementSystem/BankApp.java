package bankManagementSystem;

import java.util.Scanner;

public class BankApp {
	private static Scanner scanner = new Scanner(System.in);
	private static Bank bank = new Bank();

	public static void main(String[] args) {
		boolean quit = false;
		while (!quit) {
			System.out.println("1. Open a new account");
			System.out.println("2. Deposit money into an account");
			System.out.println("3. Withdraw money from an account");
			System.out.println("4. Check the balance of an account");
			System.out.println("5. Quit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				openAccount();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				getBalance();
				break;
			case 5:
				quit = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
			System.out.println();
		}
	}

// Open a new account
	private static void openAccount() {
		scanner.nextLine();
		System.out.println("Enter customer Name: ");
		String customerName = scanner.nextLine();
		System.out.println("Enter customer ID: ");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		Customer customer = new Customer(customerId, customerName);
//		if (customer == null) {
//			System.out.println("Customer not found.");
//			return;
//		}
		System.out.print("Enter initial deposit: ");
		double initialDeposit = scanner.nextDouble();
		bank.openAccount(customer, initialDeposit);
		System.out.println("Account opened successfully. [Please memorize your Account number and keep in a safe place].");
		customer.displayAccounts();
	}

// deposit money
		private static void deposit() {
		System.out.print("Enter account number: ");
		int accountNumber = scanner.nextInt();
		System.out.print("Enter amount to deposit: ");
		double amount = scanner.nextDouble();
		bank.deposit(accountNumber, amount);
	}

// withdraw money
	private static void withdraw() {
		System.out.print("Enter account number: ");
		int accountNumber = scanner.nextInt();
		System.out.print("Enter amount to withdraw: ");
		double amount = scanner.nextDouble();
		bank.withdraw(accountNumber, amount);
	}

// Inquire about current balance
	private static void getBalance() {
		System.out.print("Enter account number: ");
		int accountNumber = scanner.nextInt();
		double balance = bank.getBalance(accountNumber);
		if (balance == -1.0) {
			System.out.println("Account not found.");
		} else {
			System.out.println("Current balance: " + balance);
		}
	}
}