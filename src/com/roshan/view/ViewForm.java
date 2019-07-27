package com.roshan.view;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.roshan.add.AddForm;
import com.roshan.chart.Report;
import com.roshan.home.RegistrationProcess;
import com.roshan.login.LoginForm;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class ViewForm extends JFrame {
	public static String[][] rowData={{"0","0","0","0","0"}};;
	private JTextField search;
	private JTable table;
	public ViewForm(final int userId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Home Expense Managememt");
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(450, 289);
		getContentPane().setBackground(new Color(0, 0, 139));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 139));
		panel_1.add(panel_2, BorderLayout.NORTH);

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblSearch.setForeground(new Color(255, 255, 255));
		panel_2.add(lblSearch);

		search = new JTextField();
		panel_2.add(search);
		search.setColumns(10);




		String[] columnName={"Date","Transaction Id","Purpose","Mode","Amount"};



		table = new JTable(rowData,columnName);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setRowSelectionAllowed(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(155);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(4).setPreferredWidth(91);
		table.setForeground(new Color(255, 255, 240));
		table.setBackground(new Color(0, 0, 139));
		JScrollPane ScrollPane=new JScrollPane(table);
		panel_1.add(ScrollPane, BorderLayout.CENTER);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String input=search.getText().trim();
				RegistrationProcess.search(userId,input);
				new ViewForm(userId);
			}
		});
		panel_2.add(btnSearch);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Report(userId);
			}
		});
		btnReport.setMnemonic('R');
		btnReport.setVerticalAlignment(SwingConstants.TOP);
		btnReport.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(btnReport);

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

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(new Color(0, 0, 139));
		panel.add(panel_3);

		JLabel name = new JLabel(RegistrationProcess.name);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setForeground(new Color(255, 215, 0));
		name.setFont(new Font("Times New Roman", Font.BOLD, 17));
		name.setBackground(new Color(0, 0, 139));
		panel_3.add(name);

		JButton logout = new JButton("Logout");
		logout.setOpaque(false);
		logout.setBorderPainted(false);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginForm();
			}
		});
		logout.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(logout);

		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AddForm(userId);
			}
		});
		panel_3.add(btnAddNew);

	}

}
