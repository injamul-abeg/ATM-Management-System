package com.rs.login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.rs.dao.UserDAO;
import com.rs.main.Main;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private static String name,acc_no,password;
	
	public LoginPanel() {
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setName("Log In");
		JLabel label = new JLabel("Acc No : ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(34, 156, 123, 27);
		add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(159, 152, 266, 37);
		add(textField);
		
		JLabel label_1 = new JLabel("Password : ");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_1.setBounds(34, 216, 123, 27);
		add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(159, 216, 266, 37);
		add(passwordField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.showPanel("homePanel");
			}
		});
		btnCancel.setBounds(371, 299, 103, 37);
		add(btnCancel);
		
		JButton button = new JButton("Log In");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(UserDAO.getId());
				acc_no=textField.getText().toString();
				password=String.valueOf(passwordField.getPassword());
				name=UserDAO.getName(UserDAO.getId());
				String pass=UserDAO.getPass(UserDAO.getId());
				String acc=UserDAO.getAccNo(UserDAO.getId());
				System.out.println(acc_no+" "+password+" "+name+" "+pass+" "+acc);
				if (acc_no.equals(acc)&&password.equals(pass)) {
					JOptionPane.showMessageDialog(null, "Login Success");
					Main.showPanel("welcomePanel");
				}else {
					JOptionPane.showMessageDialog(null, "Error!\nEnter valid Acc_No or Password");
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button.setBounds(204, 299, 117, 37);
		add(button);
	}
}
