package BANKPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class View extends JFrame implements ActionListener {
	
	JButton btn1;
	JButton btn2;
	JTextField id;
	JTextField pw;
	
	View() {
		// 버튼 생성
		btn1 = new JButton("OK");
		btn2 = new JButton("Cancel");
		
		setTitle("로그");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("ID"));
		id = new JTextField(20);
		pw = new JTextField(20);
		
		c.add(id);
		c.add(new JLabel("PW"));
		c.add(pw);
		c.add(btn1);
		c.add(btn2);
		
		setSize(290, 150);
		setVisible(true);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	//회원가
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

		if(ie.getSource().equals(btn1)) {
			String account = id.getText()+","+pw.getText();
	        
	        BufferedReader bReader = null;
	        
	        try {
	            
	            String s;
	            File readfile = new File("test1.txt");
	            bReader = new BufferedReader(new FileReader(readfile));
	            System.out.println(account);
	            // 더이상 읽어들일게 없을 때까지 읽어들이게 합니다.
	            while((s = bReader.readLine()) != null) {
	            	if(s.equals(account)) {
	                	
	                	setVisible(false);
	                }
	            }
	        } catch(IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(bReader != null) bReader.close();
	            } catch(IOException e) {
	                e.printStackTrace();
	            }
	        }
	        
		
		}
		
		else if(ie.getSource().equals(btn2) ) {
			System.exit(0);
		}
			
	}
	
	
	public static void main(String[] args) {
		new View();
	}
}
