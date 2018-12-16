package BANKPROJECT;

public class BankManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD

		//Login login = new Login();

		BankReader reader = new BankReader();
=======
>>>>>>> 승호
		
		Login login = new Login();
		
	}
	public static void run() {
		BankReader reader = new BankReader();
		BankAccount ordinary_account = new BankAccount(0);		
		BankWriter ordinary_writer = new BankWriter("입출금 통장", ordinary_account);
		BankAccount saving_account = new BankAccount(0);
		BankWriter saving_writer = new BankWriter("적금 통장", saving_account);
		BankController controller = new BankController(reader, ordinary_account, ordinary_writer, saving_account, saving_writer);
		controller.processTransactions();
	}
}
