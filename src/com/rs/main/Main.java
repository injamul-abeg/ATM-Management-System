package com.rs.main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rs.dao.UserDAO;
import com.rs.login.HomePanel;
import com.rs.login.LoginPanel;
import com.rs.login.SignUpPanel;
import com.rs.welcome.WelcomePanel;

import java.awt.CardLayout;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static CardLayout layout;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					System.out.println(UserDAO.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		String title="ATM SYSTEM";
		
		setFont(new Font("Tahoma", Font.PLAIN, 46));
		setTitle(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		layout=new CardLayout();
		contentPane.setLayout(layout);
		
		HomePanel homePanel = new HomePanel();
		contentPane.add(homePanel, "homePanel");
		SignUpPanel signUpPanel = new SignUpPanel();
		contentPane.add(signUpPanel, "signUpPanel");
		LoginPanel loginPanel=new LoginPanel();
		contentPane.add(loginPanel,"loginPanel");
		WelcomePanel welcomePanel=new WelcomePanel();
		contentPane.add(welcomePanel,"welcomePanel");
		
		layout.show(contentPane, "homePanel");
		
	}
	public static void showPanel(String panel) {
		layout.show(contentPane, panel);
	}
	
}
