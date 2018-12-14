package BANKPROJECT;

import javax.swing.JOptionPane;

public class BankReader {
	
	private String input_line = ""; // 최근에 입력된 명령어
	
	// readCommand : 입력창을 띄워 명령어를 입력받는다. 입력된 명령어의 첫 글자 반환
	public char readCommand(String message) {
		input_line = JOptionPane.showInputDialog(message).toUpperCase();
		return input_line.charAt(0);
	}
	
	// readAmount : 최근에 입력된 명령어에서 첫 글자를 제외한 문자열 xxxxx를 반환한다.
	public int readAmount() {
		int answer = 0;
		
		String s = input_line.substring(1, input_line.length()); // 1로 하니 입출금 등에서 실행 x
		
		if (s.length() > 0) {
			double tmp = new Double(s).doubleValue();
			answer = (int) tmp;
		}
		
		else JOptionPane.showMessageDialog(null, "금액을 입력하지 않아 0으로 처리합니다.");
		
		return answer;
	}
}
