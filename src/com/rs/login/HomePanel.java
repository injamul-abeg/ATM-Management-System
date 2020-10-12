package com.rs.login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.rs.dao.UserDAO;
import com.rs.main.Main;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePanel extends JPanel {

	public HomePanel() {
		setBackground(Color.black);
		setLayout(null);
		
		JLabel lblAtmSystem = new JLabel("ATM SYSTEM");
		lblAtmSystem.setBackground(Color.MAGENTA);
		lblAtmSystem.setForeground(Color.yellow);
		lblAtmSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtmSystem.setFont(new Font("Showcard Gothic", Font.PLAIN, 46));
		lblAtmSystem.setBounds(58, 107, 352, 103);
		add(lblAtmSystem);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.showPanel("loginPanel");
			}
		});
		btnLogin.setBounds(155, 254, 147, 49);
		btnLogin.setFont(new Font("Gothic", Font.PLAIN, 26));
		add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.showPanel("signUpPanel");
			}
		});
		btnSignUp.setBounds(345, 355, 89, 23);
		add(btnSignUp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(345, 444, 89, 23);
		add(btnExit);

	}
}
