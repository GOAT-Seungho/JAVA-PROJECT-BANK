package BANKPROJECT;

public class BankController {
	private BankReader reader;
	private BankAccount ordinary_account, saving_account, account;
	private BankWriter ordinary_writer, saving_writer, writer;
	
	public BankController (BankReader r, BankAccount a1, BankWriter w1, BankAccount a2, BankWriter w2) {
		reader = r;
		ordinary_account = a1;
		ordinary_writer = w1;
		saving_account = a2;
		saving_writer = w2;
		account = ordinary_account;
		writer = ordinary_writer;
	}
	
	public void resetAccount(BankAccount other_account, BankWriter other_writer) {
		writer.showTransaction("비활성");
		account = other_account;
		writer = other_writer;
		writer.showTransaction("활성");
	}
	
	public void processTransactions() {
		char command = reader.readCommand(
				"O : 입출금 통장 활성화 \n" +
				"S : 적금 통장 활성화 \n" +
				"D [금액] : 활성 계좌에 [금액] 만큼 입금 \n" +
				"W [금액] : 활성 계좌에서 [금액] 만큼 출금 \n" +
				"T [금액] : 활성 계좌에서 [금액] 만큼 비활성 계좌에 이체 \n" +
				"I [날짜(일)] : 활성 계좌의 금액을 날짜 대 이율만큼 증가 \n " +
				"Q : 종료 \n" +
				"입출금 및 이체 수수료 : 1,000₩ \n" +
				"연 이율 : 1.80% \n" +
				"연 이율(적금) : 4.60% \n");
		
		switch (command) {
			
			case 'O' : {
				resetAccount(ordinary_account, ordinary_writer);
				break;
			}
			
			case 'S' : {
				resetAccount(saving_account, saving_writer);
				break;
			}
			
			case 'D' : {
				int amount = reader.readAmount();
				if (account.deposit(amount)) writer.showTransaction("입금 ₩", amount);
				else writer.showTransaction("입금 오류", amount);
				break;
			}
			
			case 'W' : {
				int amount = reader.readAmount();
				if (account == saving_account) writer.showTransaction("출금 오류 : 적금 통장은 출금하실 수 없습니다.");
				else {
					if (account.withdraw(amount)) writer.showTransaction("출금 ₩", amount);
					else writer.showTransaction("출금 오류", amount);
				}
				break;
			}
			
			case 'T' : {
				int amount = reader.readAmount();
				
				if (account == ordinary_account) {
					if (account.withdraw(amount) && saving_account.deposit(amount)) writer.showTransaction("이체 ₩", amount); 
					else writer.showTransaction("이체 오류", amount);
				}
				
				else {
					writer.showTransaction("이체 오류 : 적금 통장은 이체하실 수 없습니다.");
				}
				
				break;
			}
			
			case 'I' : {
				double interest_rate = 0; // 연 이율 
				int interest = 0; // 이자액
				int days = reader.readAmount(); // 날짜 
				
				if (days < 0) writer.showTransaction("이자 지급 오류", days);
				
				else {
					if (account == ordinary_account) interest_rate = 1.80; // 일반 계좌의 연 이율 = 1.80%
					else interest_rate = 4.60; // 적금 계좌의 연 이율 = 4.60%
					
					interest = (int) (account.getBalance() * (interest_rate / 365 * days));
				}
				
				if (account.deposit(interest+1000)) writer.showTransaction("이자 ₩", interest);
				
				else writer.showTransaction("이자 오류", interest);
				
				break;
			}
			
			case 'Q' : {
				return;
			}
			
			default : {
				writer.showTransaction("잘못된 명령 " + command);
			}
		}
		this.processTransactions();
	}
}
