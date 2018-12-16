package BANKPROJECT;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Join extends JFrame implements ActionListener {

    JButton button_ok;
    JButton button_cancel;
    JTextField ID;
    JTextField PW;

    public Join() {

        button_ok = new JButton("OK");
        button_cancel = new JButton("Cancel");

        setTitle("Join");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(new FlowLayout());

        ID = new JTextField(20);
        PW = new JPasswordField(20);

        c.add(new JLabel("ID"));
        c.add(ID);
        c.add(new JLabel("PW"));
        c.add(PW);
        c.add(button_ok);
        c.add(button_cancel);

        setSize(290, 150);
        setVisible(true);

        button_ok.addActionListener(this);
        button_cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ie) {
        if (ie.getSource().equals(button_ok)) {
            String member_info = ID.getText() + "," + PW.getText() + "\n";

            File file = new File("test1.txt");
            FileWriter writer = null;

            try {
                writer = new FileWriter(file, true);
                writer.write(member_info);
                writer.flush();
                JOptionPane.showMessageDialog(null, "Done!");
                setVisible(false);
                new Login();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (writer != null) writer.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}










