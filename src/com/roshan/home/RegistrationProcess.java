package com.roshan.home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;

import com.roshan.add.Add;
import com.roshan.login.Login;
import com.roshan.registration.Registration;
import com.roshan.view.ViewForm;
import com.util.HibernateUtil;

public class RegistrationProcess {

	public static int userId;
	public static String name;
	public static List<Integer> month=new ArrayList<>();
	public static Map<Integer, String> year=new TreeMap<>();
	static Session session=HibernateUtil.getSession();
	public static void doRegistration(Registration registration) {
		session.beginTransaction();
		session.save(registration);
		session.getTransaction().commit();
	}
	public static int check(Login login){
		List<Registration> list=session.createQuery("from Registration").list();
		Registration.userCount=list.size();
		for (Registration registration : list) {
			if(login.getUsername().equals(registration.getUsername()) && login.getPassword().equals(registration.getPassword())){

				name=registration.getFirstName()+" "+registration.getLastName();
				return registration.getUserId();
			}
		}
		return -1;		
	}



	public static void add(Add add){
		session.beginTransaction();
		session.save(add);
		session.getTransaction().commit();
	}

	public static int total(int userId){
		int tmp=0;
		int i=0;
		List<Add> list=session.createQuery("from Add where userId=:userId").setInteger("userId", userId).list();
		int count=list.size();
		ViewForm.rowData=new String[count][5];
		for (Add add : list) {
			ViewForm.rowData[i][0]=add.getDate();
			ViewForm.rowData[i][1]=""+add.getTxn();
			ViewForm.rowData[i][2]=add.getPurpose();
			ViewForm.rowData[i][3]=add.getMode();
			ViewForm.rowData[i][4]=""+add.getAmount();
			i++;
			tmp+=add.getAmount();
		}
		return tmp;
	}

	public static void search(int userId,String input){
		int i=0;
		List<Add> list=session.createQuery("from Add where userId=:userId and (date like '%"+input+"%' or mode like '%"+input+"%' or purpose like '%"+input+"%')").setInteger("userId", userId).list();
		int count=list.size();
		ViewForm.rowData=new String[count][5];
		for (Add add : list) {
			ViewForm.rowData[i][0]=add.getDate();
			ViewForm.rowData[i][1]=""+add.getTxn();
			ViewForm.rowData[i][2]=add.getPurpose();
			ViewForm.rowData[i][3]=add.getMode();
			ViewForm.rowData[i][4]=""+add.getAmount();
			i++;
		}
	}

	public static void reportGeneration(int userId,String input){
		List<Add> list=session.createQuery("from Add where userId=:userId").setInteger("userId", userId).list();
		if(input.equals("Monthly Report")){	
			DateFormat dateFormat=new SimpleDateFormat("yyyy");
			Date date=new Date();
			for (int i = 0; i <12; i++) {
				if(i<10){
					String month="0"+(i+1)+"-"+dateFormat.format(date);
					int total=0;					
					for (Add add : list) {
						if(add.getDate().contains(month)){
							total+=add.getAmount();
						}
					}
					RegistrationProcess.month.add(i,total);
				}else{
					String month="-"+(i+1)+"-"+dateFormat.format(date);
					int total=0;
					for (Add add : list) {
						if(add.getDate().contains(month)){
							total+=add.getAmount();
						}
					}
					RegistrationProcess.month.add(i,total);
				}
			}
		}else{
			for (int i = 0; i <20; i++) {
				if(i<10){
					String year="200"+(i+1);
					int total=0;					
					for (Add add : list) {
						if(add.getDate().contains(year)){
							total+=add.getAmount();
						}
					}
					if(total!=0)
						RegistrationProcess.year.put(total, year);
				}else{
					String year="20"+(i+1);
					int total=0;
					for (Add add : list) {
						if(add.getDate().contains("-"+year)){
							total+=add.getAmount();
						}
					}
					if(total!=0)
						RegistrationProcess.year.put(total, year);
				}
			}

		}
	}

}
