package com.roshan.login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.roshan.add.AddForm;
import com.roshan.home.RegistrationProcess;
import com.roshan.registration.RegistrationForm;

import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;

public class LoginForm extends JFrame {
	private JTextField username;
	private JPasswordField password;
	public LoginForm() {
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Home Expense Management");
		setSize(450, 187);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 0, 139));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblHomeExpenseManagement = new JLabel("Home Expense Management System");
		lblHomeExpenseManagement.setVerticalAlignment(SwingConstants.TOP);
		lblHomeExpenseManagement.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHomeExpenseManagement.setForeground(new Color(240, 248, 255));
		lblHomeExpenseManagement.setBackground(new Color(240, 248, 255));
		getContentPane().add(lblHomeExpenseManagement, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(240, 248, 255)));
		panel.setBackground(new Color(0, 0, 128));
		panel.setForeground(new Color(0, 0, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUsername.setForeground(new Color(240, 248, 255));
		lblUsername.setBackground(new Color(240, 248, 255));
		panel.add(lblUsername);

		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(username);
		username.setColumns(25);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setForeground(new Color(240, 248, 255));
		panel.add(lblPassword);

		password = new JPasswordField();
		password.setColumns(25);
		password.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(password);

		final JLabel lblloginIncorrect = new JLabel("*Login Incorrect!");
		lblloginIncorrect.setLabelFor(this);
		lblloginIncorrect.setBackground(new Color(0, 0, 139));
		lblloginIncorrect.setVerticalAlignment(SwingConstants.BOTTOM);
		lblloginIncorrect.setHorizontalAlignment(SwingConstants.RIGHT);
		lblloginIncorrect.setForeground(new Color(0, 0, 139));
		lblloginIncorrect.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(lblloginIncorrect);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 139));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton login = new JButton("Login");
		JButton reset = new JButton("Reset");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(username.getText()!=null && password.getText()!=null){
					Login login1=new Login(username.getText(), password.getText());
					int userId=0;
					if((userId=RegistrationProcess.check(login1))!=-1){
						new AddForm( userId);
						dispose();

					}else{						
						lblloginIncorrect.setForeground(new Color(255, 0, 0));
						password.setText("");
					}
				}
			}
		});
		panel_1.add(login);

		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				new RegistrationForm();
				dispose();

			}
		});
		panel_1.add(register);

		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username.setText("");
				password.setText("");
			}
		});
		panel_1.add(reset);
	}
	
	
}
