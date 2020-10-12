package com.rs.welcome;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.rs.dao.UserDAO;
import com.rs.login.LoginPanel;
import com.rs.login.SignUpPanel;
import com.rs.main.Main;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePanel extends JPanel {

	
	public WelcomePanel() {
		
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel label = new JLabel("WELCOME");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.CYAN);
		label.setFont(new Font("Showcard Gothic", Font.PLAIN, 46));
		label.setBackground(Color.WHITE);
		label.setBounds(66, 41, 352, 103);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setText(UserDAO.getName(UserDAO.getId()));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.CYAN);
		label_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(10, 141, 480, 103);
		add(label_1);
		
		JButton button = new JButton("Deposit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bal=JOptionPane.showInputDialog("Enter Amount to Deposit",null );
				System.out.println("Deposit :"+bal);
				int amount=Integer.parseInt(bal)+UserDAO.getBalance(UserDAO.getId());
				UserDAO.updateBalance(UserDAO.getId(), amount);
				
				//System.out.println(amount);
				JOptionPane.showMessageDialog(null, "Deposit Successfull");
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button.setBounds(175, 285, 204, 37);
		add(button);
		
		JButton button_1 = new JButton("Withdraw");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String balance= JOptionPane.showInputDialog("Enter Amount to Withdraw",null );
				System.out.println("Withdraw : "+balance);
				int amount=UserDAO.getBalance(UserDAO.getId());
				amount=amount-Integer.parseInt(balance);
				if (amount>=0) {
					UserDAO.updateBalance(UserDAO.getId(), amount);
					JOptionPane.showMessageDialog(null, "Withdraw Successfull");
				} else {
					JOptionPane.showMessageDialog(null, "Not Enough Money");
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_1.setBounds(175, 345, 204, 37);
		add(button_1);
		
		JButton button_2 = new JButton("Check Balance");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount=UserDAO.getBalance(UserDAO.getId());
				JOptionPane.showMessageDialog(null, "Your Balance is : "+amount);
				System.out.println("Your Balance is : "+amount);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_2.setBounds(175, 405, 204, 37);
		add(button_2);
		
		JButton button_3 = new JButton("Log Out");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.showPanel("homePanel");
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_3.setBounds(175, 465, 204, 37);
		add(button_3);

	}

}
