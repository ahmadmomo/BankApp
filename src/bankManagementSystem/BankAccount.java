package bankManagementSystem;

public class BankAccount {
	private int accountNumber;
	private String accountHolder;
	private double balance;

	public BankAccount(int accountNumber, String accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}
	public String toString() {
		String info = "\nAccount Balance: " + getBalance() + "\nAccount holder name: " + getAccountHolder();
		return info;
		
	}
}