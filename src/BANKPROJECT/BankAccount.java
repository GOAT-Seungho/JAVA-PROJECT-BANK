package BANKPROJECT;

import javax.swing.JOptionPane;

public class BankAccount {
	
	private int balance; // 계좌의 잔액 (양수)
	
	// BankAccount : 계좌를 initial 금액으로 초기화 
	public BankAccount(int initial_amount) {
		if (initial_amount >= 0) balance = initial_amount;
		else balance = 0;
	}
	
	// getBalance : 잔액을 반환
	public int getBalance() {
		return balance;
	}
	
	// deposit : 입금 메소드
	public boolean deposit(int amount) {
		boolean result = false;
		
		if (amount < 0) JOptionPane.showMessageDialog(null, "잘못된 입금액이라 무시합니다.");
		
		else if (amount < 1000 && amount > 0) JOptionPane.showMessageDialog(null, "입금 수수료 (1,000₩) 미만으로 입금하실 수 없습니다.");
		
		else {
			balance += (amount - 1000);
			result = true;
		}
		
		return result;
	}
	
	// withdraw : 출금 메소드
	public boolean withdraw(int amount) {
		boolean result = false;
		
		if (amount < 0) JOptionPane.showMessageDialog(null, "잘못된 출금액이라 무시합니다.");
		
		else if (amount + 1000 > balance) JOptionPane.showMessageDialog(null, "잔고가 부족합니다.");
		
		else {
			balance -= (amount + 1000);
			result = true;
		}
		
		return result;
	}

}















