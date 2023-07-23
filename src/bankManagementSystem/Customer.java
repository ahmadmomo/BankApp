package bankManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Customer {
	private int customerId;
	private String customerName;
	private HashMap<Integer, BankAccount> accounts;

	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.accounts = new HashMap<Integer, BankAccount>();
	}

	public void addAccount(BankAccount account, int accountNumber) {
		accounts.put(accountNumber, account);
	}

	public HashMap<Integer, BankAccount> getAccounts() {
		return accounts;
	}

	public void displayAccounts() {
		for (Entry<Integer, BankAccount> set : accounts.entrySet()) {
			System.out.println("the Account number: " + set.getKey() + "\nThe Account info: " + set.getValue());
		}
	}

	public BankAccount getAccount(int accountNumber) {
		for (Entry<Integer, BankAccount> set : accounts.entrySet()) {
			if (set.getKey() == accountNumber) {
				System.out.println(set.getValue());
				return set.getValue();
			}
		}
		return null;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setAccounts(HashMap<Integer, BankAccount> accounts) {
		this.accounts = accounts;
	}

}