package com.rs.login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.rs.dao.UserDAO;
import com.rs.main.Main;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignUpPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField textField_2;
	private JPasswordField passwordField;
	private String name,acc,email,pass,country;
	private JButton btnOk,btnCancel;
	private JComboBox comboBox;
	public SignUpPanel() {
		
		setBackground(Color.LIGHT_GRAY);
		setName("SignUp");
		setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name : ");
		lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFullName.setBounds(25, 61, 123, 27);
		add(lblFullName);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(150, 57, 266, 37);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Acc No : ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(25, 121, 123, 27);
		add(label);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(150, 117, 266, 37);
		add(textField_1);
		
		JLabel label_1 = new JLabel("Email : ");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_1.setBounds(25, 181, 123, 27);
		add(label_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(150, 177, 266, 37);
		add(textField_2);
		
		JLabel label_2 = new JLabel("Password : ");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_2.setBounds(25, 241, 123, 27);
		add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(150, 237, 266, 37);
		add(passwordField);
		
		JLabel label_3 = new JLabel("Country : ");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_3.setBounds(25, 301, 123, 27);
		add(label_3);
		
		String coutrys[]={"Bangladesh","India","USA","UK","Other"};
		comboBox = new JComboBox(coutrys);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(150, 297, 266, 37);
		
		
		add(comboBox);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				name=textField.getText().toString();
				acc=textField_1.getText().toString();
				email=textField_2.getText().toString();		
				pass=String.valueOf(passwordField.getPassword());
				country = comboBox.getSelectedItem().toString();
				System.out.println(name);
				System.out.println(acc);
				System.out.println(email);
				System.out.println(pass);
				System.out.println(country);
				if (name.equals("")||acc.equals("")||email.equals("")||pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Error!\nInput Valid Data");
				}else {
					int status=UserDAO.save(name, acc, email, pass, country);
					if (status>0) {
						JOptionPane.showMessageDialog(null, "Save Success");
						Main.showPanel("homePanel");
						//System.out.println(id);
					}else {
						JOptionPane.showMessageDialog(null, "Error!\nInput Valid Data");
					}
				}		
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnOk.setBounds(208, 392, 117, 37);
		add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.showPanel("homePanel");
			}
		});
		btnCancel.setBounds(360, 392, 101, 35);
		add(btnCancel);
	}

}
