package CJP_Program;

import java.io.IOException;
import java.util.Scanner;

public class Customer{
	public void withdraw(BankBean b) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount you want to withdraw");
//		float balance=sc.nextFloat();
		float withdraw=sc.nextFloat();
		if(withdraw>0)
		{
			BankDao bd=new BankDao();
			bd.withdrawMoney(b,withdraw);
		}
		else
		{
			System.out.println("Negative amount cannot be withdrawn");
		}
		
	}
	
	public void deposit(BankBean b) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount you want to deposit");
//		float balance=sc.nextFloat();
		float deposit=sc.nextFloat();
		if(deposit>0)
		{
			BankDao bd=new BankDao();
			bd.depositMoney(b,deposit);
		}
		else
		{
			System.out.println("Negative amount cannot be deposited");
		}
		
		//how to put this balance into query
		
	}
	public void transfer(BankBean b)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount you want to transfer");
		float transfer=sc.nextFloat();
		
		System.out.println("Enter the email id of the beneficiary:");
		String email=sc.next();
		
		System.out.println("Enter the name of the beneficiary:");
		String name=sc.next();
		
		if(transfer>0)
		{
			BankDao bd=new BankDao();
			bd.TransferMoney(b, transfer, email, name);
		}
		
		else
		{
			System.out.println("Negative amount cannot be transferred");
		}
		
		
	}
}
