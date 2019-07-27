package com.roshan.add;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.roshan.home.RegistrationProcess;
import com.roshan.login.LoginForm;
import com.roshan.view.ViewForm;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class AddForm extends JFrame {
	private JTextField purpose;
	private JTextField amount;
	private JTextField total;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	void reset(int userId) {
		dateChooser.cleanup();
		comboBox.setSelectedIndex(0);
		amount.setText("");
		purpose.setText("");
		total.setText(""+RegistrationProcess.total(userId));
	}
	
	public AddForm(final int userId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Home Expense Managememt");
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(450, 289);
		getContentPane().setBackground(new Color(0, 0, 139));
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label = new JLabel("Home Expense Management System");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setForeground(new Color(240, 248, 255));
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label.setBackground(new Color(240, 248, 255));
		panel.add(label);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_4.setBackground(new Color(0, 0, 139));
		panel.add(panel_4);
		
		JLabel name = new JLabel(RegistrationProcess.name);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setForeground(new Color(255, 215, 0));
		name.setFont(new Font("Times New Roman", Font.BOLD, 17));
		name.setBackground(new Color(0, 0, 139));
		panel_4.add(name);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginForm();
			}
		});
		logout.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(logout);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 139));
		getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblDate = new JLabel("Date:");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDate.setForeground(new Color(255, 255, 224));
		panel_1.add(lblDate);

		JLabel lblPurpo = new JLabel("Purpose:");
		lblPurpo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPurpo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPurpo.setForeground(new Color(255, 255, 240));
		panel_1.add(lblPurpo);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAmount.setForeground(new Color(255, 255, 224));
		panel_1.add(lblAmount);

		JLabel lblSpendBy = new JLabel("Spend By:");
		lblSpendBy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpendBy.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblSpendBy.setForeground(new Color(255, 255, 224));
		panel_1.add(lblSpendBy);

		JLabel lbltotal = new JLabel("Total:");
		lbltotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltotal.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbltotal.setForeground(new Color(255, 255, 224));
		panel_1.add(lbltotal);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 139));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 5));

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		panel_2.add(dateChooser);

		purpose = new JTextField();
		purpose.setText("");
		panel_2.add(purpose);
		purpose.setColumns(10);

		amount = new JTextField();
		amount.setText("");
		panel_2.add(amount);
		amount.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select mode", "Credit Card", "Cheque", "By Cash"}));
		comboBox.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		panel_2.add(comboBox);
		
		 

		total = new JTextField();
		total.setEditable(false);
		total.setText(""+RegistrationProcess.total(userId));
		total.setHorizontalAlignment(SwingConstants.LEFT);
		total.setFont(new Font("Times New Roman", Font.BOLD, 20));
		total.setForeground(new Color(139, 0, 0));
		panel_2.add(total);
		total.setColumns(10);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(10);
		panel_3.setBackground(new Color(0, 0, 139));
		getContentPane().add(panel_3, BorderLayout.SOUTH);

		final JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				Add add=new Add(userId,date, purpose.getText(), Integer.parseInt(amount.getText()), comboBox.getSelectedItem().toString());
				RegistrationProcess.add(add);
				JOptionPane.showMessageDialog(btnAdd, "Transaction successfull!");
				reset(userId);
			}
		});
		panel_3.add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(userId);
			}
		});
		panel_3.add(btnReset);

		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ViewForm(userId);
				dispose();
			}
		});
		panel_3.add(btnView);
	}
	

}
