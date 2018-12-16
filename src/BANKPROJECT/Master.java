package BANKPROJECT;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class Master extends JFrame {
	
	public Master() {
		String all="";
		
		try {
			File file = new File("members.txt");
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				all+=(scan.nextLine()+"\n");
			}
			scan.close();
			
		} catch(FileNotFoundException e) {
			
		}

		JOptionPane.showMessageDialog(null, all, "MASTER MODE", getDefaultCloseOperation(), null);
		new Login();
	}
}
