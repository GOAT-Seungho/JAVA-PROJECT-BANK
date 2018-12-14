package BANKPROJECT;

import java.awt.*;

import javax.swing.*;

public class BankWriter extends JPanel {
	
	
	// 창의 크기 
	private int WIDTH = 600;
	private int HEIGHT = 400;
	
	// 이 출력 뷰에 연관된 은행 계좌
	private BankAccount bank;
	
	// 최근거래의 메시지
	private String last_transaction = "";
	
	// BankWriter 생성자 : 창을 띄운다.
	public BankWriter(String title, BankAccount b) {
		bank = b;
		
		JFrame f = new JFrame();
		
		f.getContentPane().add(this);
		f.setTitle(title); // 창의 제목 
		f.setSize(WIDTH, HEIGHT); // 창의 크기 
		f.setBackground(Color.white); // 창의 배경 
		f.setVisible(true);
	}
	
	// showTransaction : 메시지(message) 와 금액 (amount)에 해당하는 최근 거래를 화면에 출력
	public void showTransaction(String message, int amount) {
		last_transaction = message + " " + amount + "";
		this.repaint();
	}
	
	// showTransaction : 메시지(message)에 해당하는 최근 거래를 화면에 출력 
	public void showTransaction(String message) {
		last_transaction = message;
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT); // 네모 상자 그리기
		g.setColor(Color.black);
		int text_margin = 50;
		int text_baseline = 50;
		g.drawString(last_transaction, text_margin, text_baseline);
		g.drawString("현재 잔고는 " + bank.getBalance() + " ₩", text_margin, text_baseline + 20);
	}
}
