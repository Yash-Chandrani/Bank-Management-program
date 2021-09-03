package CJP_Program;

import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;


public class BankProgram{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String adminUsername = "admin";
		String adminPassword = "admin";
		String bankname = "SBI";
		String bankaddress = "Prahladnagar";
		System.out.println("-----" + bankname + "---");
		System.out.println("---" + bankaddress + "----");
		while(true)
		{
		System.out.println("\n1->\t\tAdmin Login");
		System.out.println("\n2->\t\tCustomer Login");
		System.out.println("\n3->\t\tExit");
		int choice;
		choice=s.nextInt();
		
		switch (choice) {
		case 1:
			String username,password;
			System.out.println("Enter your username:");
			username = s.next();
			System.out.println("Enter your  password:");
			password = s.next();
			if(username.equals(adminUsername) && password.equals(adminPassword))
			{
				System.out.println("\n1->\t\tCreate user");
				System.out.println("\n2->\t\tDisplay all users");
				System.out.println("\n3->\t\tDelete User");
				System.out.println("\n4->\t\tUpdate User");
				System.out.println("\n5->\t\tGo to main menu");
				
				int ch;
				ch=s.nextInt();
				switch(ch)
				{
					case 1:
						Account obj=new Account();
						obj.createUser();
						break;
					
					case 2:
						Account obj2=new Account();
						obj2.displayUsers();
						break;
					case 3:
						Account obj3=new Account();
						obj3.deleteUser();
						break;
					case 4:
						Account obj4=new Account();
						obj4.updateUser();;
						break;	
					case 5:break;
					default:
						System.out.println("Please enter a valid choice");
						
				}
			}
			else
			{
				System.out.println("Please enter a valid username");
			}
			break;
			
		case 2:
			System.out.println("Enter your email:");
			username = s.next();
			System.out.println("Enter your  password:");
			password = s.next();
			BankBean b=BankDao.viewUser(username, password);
			if(b==null)
			{
				System.out.println("This user does not exist in our database.");
			}
			else
			{
				System.out.println("\n1->\t\tWithdraw");
				System.out.println("\n2->\t\tDeposit");
				System.out.println("\n3->\t\tTransfer Money");
				System.out.println("\n4->\t\tCheck Balance");
				System.out.println("\n5->\t\tGo to main menu");
//				System.out.println("\n4->\t\tCheck balance");
				int chUser;
				chUser=s.nextInt();
				switch(chUser)
				{
					case 1:
						Customer cWithdraw=new Customer();
						cWithdraw.withdraw(b);
						System.out.println("Your balance is: "+BankDao.viewBalance(username, password));
						break;
					case 2:
						Customer cDeposit=new Customer();
						cDeposit.deposit(b);
						System.out.println("Your balance is: "+BankDao.viewBalance(username, password));
						break;
					case 3:
						Customer cTransfer=new Customer();
						cTransfer.transfer(b);
						System.out.println("Your balance is: "+BankDao.viewBalance(username, password));
						break;
					
					case 4:
						float BB=BankDao.viewBalance(username, password);
						System.out.println(BB);
						break;
					default:
						System.out.println("Please enter a valid choice");
				}
			}
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Please enter a valid choice");
			break;
		
		
		}
		}
	}
}
