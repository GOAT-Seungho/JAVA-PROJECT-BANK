package BANKPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame implements ActionListener {
	
	JButton button_ok; // OK 버튼
	JButton button_cancel; // Cancel 버튼
	JButton button_join; // Join 버튼
	JTextField ID; // 아이디 
	JTextField PW; // 비밀번호
	private int member_check = 0;
	
	public Login() {
		
		button_ok = new JButton("OK"); // button_ok : OK 버튼
		button_cancel = new JButton("Cancel"); // button_cancel : Cancel 버튼
		button_join = new JButton("Join"); // button_join : 회원가입 버
		
		setTitle("Login"); // 창의 이름 : Login 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료
		
		Container c = getContentPane(); // contentPane : 일반적인 컴포넌트들을 가질 수 있는 패널
		c.setBackground(Color.gray); // 배경 색 : Gray
		c.setLayout(new FlowLayout()); // 레이아웃 - 가운데 정렬
		
		ID = new JTextField(20);
		PW = new JPasswordField(20);
		
		c.add(new JLabel("ID"));
		c.add(ID);
		c.add(new JLabel("PW"));
		c.add(PW);
		c.add(button_ok);
		c.add(button_cancel);
		c.add(button_join);
		
		setSize(290, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		
		button_ok.addActionListener(this);
		button_cancel.addActionListener(this);
		button_join.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ie) {
		
		if (ie.getSource().equals(button_ok)) { // OK 버튼을 눌렀을 
			
			String member_info = ID.getText() + "," + PW.getText(); // 입력값
	        String master = "master,master";
			BufferedReader bufReader = null;
	        
	        try {
	            String line = "";
	            // 파일 객체 생성
	            File file = new File("members.txt");
	            // 입력 스트림 생성
	            FileReader filereader = new FileReader(file);
	            // 입력 버퍼 생성
	            bufReader = new BufferedReader(filereader);
	            
	            // 더이상 읽어들일게 없을 때까지 읽어들이게 합니다.
	            while ( (line = bufReader.readLine() ) != null) { // .readLine()은 끝에 개행문자를 읽지 않는다.
	            	// 만약 입력한 값과 text 파일의 값이 같으면 창 종료
	            	
	            	if(line.equals(member_info)) {
	            		member_check = 1;
	            		if(line.equals(master)) {
		            		JOptionPane.showMessageDialog(null, "Master Mode");
		            		setVisible(false);
		            		new Master();
		            		break;
		            	}
	            		JOptionPane.showMessageDialog(null, "Welcome!");
	            		setVisible(false);
	            		BankManager.run();
	            	}
	            	

	            }
	            if(member_check == 0) {
	            	JOptionPane.showMessageDialog(null, "Do Remind!");
	            }
	        }
	        
	        catch (IOException e) {
	        	e.printStackTrace();
	        }
	        
	        finally {
	            try {
	                if(bufReader != null) {
	                	bufReader.close();
	                }
	            }
	            catch(IOException e) {
	                e.printStackTrace();
	            }
	        }
	        
		}
		
		else if (ie.getSource().equals(button_cancel)) {
			System.exit(0);
		}
		
		else if (ie.getSource().equals(button_join)) {
			setVisible(false);
			new Join();
		}
			
	}
	
}
