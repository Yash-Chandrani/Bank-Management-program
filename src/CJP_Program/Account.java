package CJP_Program;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Account {
	//method to insert user
	public void createUser() 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email");
		String email=sc.next();
		
		System.out.println("Enter password");
		String password=sc.next();
		
		System.out.println("Enter balance");
		float balance=sc.nextFloat();
		
		System.out.println("Enter name");
		String name=sc.next();
		
		BankBean b=new BankBean();
		b.setEmail(email);
		b.setPassword(password);
		b.setBalance(balance);
		b.setName(name);
		BankDao bd=new BankDao();
		bd.insert(b);	
	}
	
	//method to update user
	public void updateUser() 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email");
		String email=sc.next();
		
		System.out.println("Enter password");
		String password=sc.next();
		
		System.out.println("Enter balance");
		float balance=sc.nextFloat();
		
		System.out.println("Enter name");
		String name=sc.next();
		
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		BankBean b=new BankBean();
		b.setEmail(email);
		b.setPassword(password);
		b.setBalance(balance);
		b.setName(name);
		b.setId(id);
		BankDao bd=new BankDao();
		bd.update(b);	
	}
	
	//method to delete user
	public void deleteUser() 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);		
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		BankBean b=new BankBean();
		b.setId(id);
		BankDao bd=new BankDao();
		bd.delete(b);	
	}
	
	//method to select all users
	public void displayUsers()
	{
//		BankDao.selectAll();
		ArrayList<BankBean> a=BankDao.selectAll();
		for (Iterator iterator = a.iterator(); iterator.hasNext();) {
			BankBean bankBean = (BankBean) iterator.next();
			System.out.print(bankBean.getId());
			System.out.print("|");
			System.out.print(bankBean.getEmail());
			System.out.print("|");
			System.out.print(bankBean.getPassword());
			System.out.print("|");
			System.out.print(bankBean.getBalance());
			System.out.print("|");
			System.out.print(bankBean.getName());
			System.out.print("|\n");
			System.out.println("-----------------------------------------------------");
			
		}

	}
		
}
