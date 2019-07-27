package com.roshan.registration;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.roshan.home.RegistrationProcess;
import com.roshan.login.LoginForm;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {
	private JTextField firstName;
	private JTextField lastName;
	private JTextField password;
	private JPasswordField confirmPassword;
	private void reset() {
		firstName.setText("");
		lastName.setText("");
		password.setText("");
		confirmPassword.setText("");		
	}
	public RegistrationForm() {
		setTitle("Home Expense Management");
		setSize(457, 291);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 0, 128));
		setForeground(new Color(0, 0, 139));
		setBackground(new Color(0, 0, 139));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblfirstName = new JLabel("Firstname:");
		lblfirstName.setVerticalAlignment(SwingConstants.TOP);
		lblfirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblfirstName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblfirstName.setForeground(new Color(248, 248, 255));
		panel.add(lblfirstName);

		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setVerticalAlignment(SwingConstants.TOP);
		lblLastname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblLastname);
		lblLastname.setForeground(new Color(255, 250, 250));
		lblLastname.setFont(new Font("Times New Roman", Font.BOLD, 17));

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setForeground(new Color(255, 248, 220));
		panel.add(lblPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblConfirmPassword.setForeground(new Color(255, 250, 250));
		panel.add(lblConfirmPassword);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(248, 248, 255));
		panel_1.setBackground(new Color(0, 0, 128));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 50, 20));

		firstName = new JTextField();
		firstName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(firstName);
		firstName.setColumns(10);

		lastName = new JTextField();
		lastName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lastName);
		lastName.setColumns(10);

		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(password);
		password.setColumns(10);

		confirmPassword = new JPasswordField();
		confirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(confirmPassword);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(20);
		panel_2.setBackground(new Color(0, 0, 128));
		getContentPane().add(panel_2, BorderLayout.SOUTH);

		final JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(firstName.getText().equals("")){
					firstName.setBackground(new Color(255, 0, 0));
				}else if(lastName.getText().equals("")){
					lastName.setBackground(new Color(255, 0, 0));
				}else if(password.getText().equals(confirmPassword.getText())){

					Registration registration=new  Registration(firstName.getText(), lastName.getText(), password.getText());
					RegistrationProcess.doRegistration(registration);
					JOptionPane.showConfirmDialog(btnRegister, "Registration successfull!\nUsername="+registration.getUsername(), getTitle(),JOptionPane.DEFAULT_OPTION ,EXIT_ON_CLOSE);
					reset();
				}else{
					password.setBackground(new Color(255, 0, 0));
				}
			}
		});
		panel_2.add(btnRegister);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}			
		});
		panel_2.add(btnReset);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginForm();
				dispose();
			}
		});
		panel_2.add(btnLogin);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 128));
		getContentPane().add(panel_3, BorderLayout.NORTH);
		JLabel lblHomeExpenseManagement = new JLabel("Home Expense Management System");
		lblHomeExpenseManagement.setVerticalAlignment(SwingConstants.TOP);
		lblHomeExpenseManagement.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHomeExpenseManagement.setForeground(new Color(240, 248, 255));
		lblHomeExpenseManagement.setBackground(new Color(240, 248, 255));
		panel_3.add(lblHomeExpenseManagement);
	}
}
