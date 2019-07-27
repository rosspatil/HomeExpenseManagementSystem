package com.roshan.chart;

import java.awt.Color;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.roshan.add.AddForm;
import com.roshan.home.RegistrationProcess;
import com.roshan.login.LoginForm;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.awt.event.ActionEvent;

public class Report extends JFrame {

	public Report(final int userId) {
		getContentPane().setBackground(new Color(0, 0, 139));
		setSize(485,165);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
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

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setBackground(new Color(0, 0, 139));
		panel.add(panel_1);

		JLabel name = new JLabel(RegistrationProcess.name);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setForeground(new Color(255, 215, 0));
		name.setFont(new Font("Times New Roman", Font.BOLD, 17));
		name.setBackground(new Color(0, 0, 139));
		panel_1.add(name);

		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginForm();
				dispose();				
			}
		});
		logout.setOpaque(false);
		logout.setHorizontalAlignment(SwingConstants.RIGHT);
		logout.setBorderPainted(false);
		panel_1.add(logout);

		JButton addNew = new JButton("Add New");
		addNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddForm(userId);
				dispose();
			}
		});
		panel_1.add(addNew);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 139));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 139));
		panel_2.add(panel_3);

		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Report Type", "Monthly Report", "Yearly Report"}));
		panel_3.add(comboBox);
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationProcess.reportGeneration(userId,comboBox.getSelectedItem().toString());

				DefaultCategoryDataset dcd=null;
				if(comboBox.getSelectedItem().toString().equals("Monthly Report")){
					int i=0;
					String months[]={"JAN","FEB","MARCH","APRIL","MAY","JUNE","JULY","AUG","SEPT","OCT","NOV","DEC"};
					dcd=new DefaultCategoryDataset();
					for (Integer num : RegistrationProcess.month) {
						if(num!=0)
							dcd.setValue(num, "Expenses",months[RegistrationProcess.month.indexOf(num)]);

					}
				}else{
					dcd=new DefaultCategoryDataset();
					Set<Map.Entry<Integer,String>> list=RegistrationProcess.year.entrySet();
					for (Entry<Integer, String> entry : list) {
						dcd.setValue(entry.getKey(), "Expenses", entry.getValue());
					}
					RegistrationProcess.year.clear();
				}
				JFreeChart chart=ChartFactory.createBarChart(getTitle(), "Months", "Amount", dcd,PlotOrientation.VERTICAL,true,true,false);
				ChartFrame chartFrame=new ChartFrame("Report", chart);
				CategoryPlot plot=chart.getCategoryPlot();
				plot.setNotify(true);
				chartFrame.setVisible(true);
				chartFrame.setResizable(false);
				chartFrame.setSize(600,300);
			}
		});
		panel_3.add(btnGenerate);





	}
}
