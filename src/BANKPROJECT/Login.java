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
		setVisible(true);
		
		button_ok.addActionListener(this);
		button_cancel.addActionListener(this);
		button_join.addActionListener(this);
	}
	
	//회원가입
//	if(ie.getSource().equals(btn1)) {
//		//login
//		String account = id.getText()+","+pw.getText()+"\n";
//        
//        File file = new File("test1.txt");
//        FileWriter writer = null;
//        
//        try {
//            // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
//            writer = new FileWriter(file, true);
//            writer.write(account);
//            writer.flush();
//            
//            System.out.println("DONE");
//        } catch(IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(writer != null) writer.close();
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//        }
	
	
	public void actionPerformed(ActionEvent ie) {

		if (ie.getSource().equals(button_ok)) { // OK 버튼을 눌렀을 
			
			String member_info = ID.getText() + "," + PW.getText(); // 입력값
	        
			BufferedReader bufReader = null;
	        
	        try {
	            String line = "";
	            // 파일 객체 생성
	            File file = new File("test1.txt");
	            // 입력 스트림 생성
	            FileReader filereader = new FileReader(file);
	            // 입력 버퍼 생성
	            bufReader = new BufferedReader(filereader);
	            
	            System.out.println(member_info);
	            
	            // 더이상 읽어들일게 없을 때까지 읽어들이게 합니다.
	            while ( (line = bufReader.readLine() ) != null) { // .readLine()은 끝에 개행문자를 읽지 않는다.
	            	// 만약 입력한 값과 text 파일의 값이 같으면 창 종료
	            	if(line.equals(member_info)) {
	            		JOptionPane.showMessageDialog(null, "Welcome!");
	            		setVisible(false);
	            	}
//	            	else {
//	            		JOptionPane.showMessageDialog(null, "Do Remind!");
//	            		break;
//	            	}

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
