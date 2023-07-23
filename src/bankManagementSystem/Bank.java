package bankManagementSystem;

import java.util.ArrayList;

// Bank to manage bank accounts
public class Bank {
	private ArrayList<Customer> customers;

	public Bank() {
		this.customers = new ArrayList<Customer>();
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public Customer getCustomer(int customerId) {
		for (Customer customer : customers) {
			if (customer.getCustomerId() == customerId) {
				return customer;
			}
		}
		return null;
	}

	public void openAccount(Customer customer, double initialDeposit) {
		int accountNumber = (int) (Math.random() * 1000000);
		BankAccount account = new BankAccount(accountNumber, customer.getCustomerName(), initialDeposit);
		addCustomer(customer);
		customer.addAccount(account, accountNumber);
	}

	public void deposit(int accountNumber, double amount) {
		for (Customer customer : customers) {
			BankAccount account = customer.getAccount(accountNumber);
			if (account != null) {
				account.deposit(amount);
				System.out.println("Deposited " + amount + " into account #" + accountNumber);
				return;
			}
		}
		System.out.println("Account #" + accountNumber + " not found.");
	}

	public void withdraw(int accountNumber, double amount) {
		for (Customer customer : customers) {
			BankAccount account = customer.getAccount(accountNumber);
			if (account != null) {
				if (account.getBalance() >= amount) {
					account.withdraw(amount);
					System.out.println("Withdrew " + amount + " from account #" + accountNumber);
				} else {
					System.out.println("Insufficient balance in account #" + accountNumber);
				}
				return;
			}
		}
		System.out.println("Account #" + accountNumber + " not found.");
	}

	public double getBalance(int accountNumber) {
		for (Customer customer : customers) {
			BankAccount account = customer.getAccount(accountNumber);
			if (account != null) {
				return account.getBalance();
			}
		}
		return -1.0;
	}
}