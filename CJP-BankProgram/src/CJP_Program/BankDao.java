package CJP_Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankDao {
	//method to insert user
	public int insert(BankBean b) 
	{
		// TODO Auto-generated method stub
		String insertQuery="INSERT INTO BankUsers(email,password,balance,name)VALUES(?,?,?,?)";
		Connection conn=DbConnection.getConnection();
		PreparedStatement pstmt=null;
		int rowsEffected=0;
		if(conn!=null)
		{
			try
			{
				pstmt=conn.prepareStatement(insertQuery);
				pstmt.setString(1,b.getEmail());
				pstmt.setString(2,b.getPassword());
				pstmt.setFloat(3,b.getBalance());
				pstmt.setString(4,b.getName());
				rowsEffected=pstmt.executeUpdate();
				if(rowsEffected>0)
					System.out.println("Data inserted successfully");
				else
					System.out.println("Data failed to be inserted");
				
				
			}
			catch(SQLException e)
			{
					e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Oops. Seems that our we have issues with our databse.Please wait till it is fixed.We regret any inconvenience caused.");
		}
		return rowsEffected;

	}
	
	//method to update user
	public int update(BankBean bankbean)
	{
		Connection conn=DbConnection.getConnection(); 
		String updateQuery="update BankUsers set email=?,password=?,balance=?,name=? where id=?;";
		
		PreparedStatement pstmt=null;
		int rowsEffected=0;
		if(conn!=null)
		{
			try
			{
				pstmt=conn.prepareStatement(updateQuery);
				
				pstmt.setString(1,bankbean.getEmail());
				pstmt.setString(2,bankbean.getPassword());
				pstmt.setFloat(3,bankbean.getBalance());
				pstmt.setString(4,bankbean.getName());
				pstmt.setInt(5,bankbean.getId());
				rowsEffected=pstmt.executeUpdate();
				if(rowsEffected>0)
					System.out.println("Data updated successfully");
				else
					System.out.println("Data failed to updated");
			}
			catch(SQLException e)
			{
					e.printStackTrace();
			}	
		}
		else
		{
			System.out.println("Oops. Seems that our we have issues with our databse.Please wait till it is fixed.We regret any inconvenience caused.");
		}
		return rowsEffected;
	}
	
	////method to delete user
	public int delete(BankBean bankbean)
	{
		Connection conn=DbConnection.getConnection(); 
		String deleteQuery="delete from BankUsers where id=?";
		
		PreparedStatement pstmt=null;
		int rowsEffected=0;
		if(conn!=null)
		{
			try
			{
				pstmt=conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1,bankbean.getId());
				rowsEffected=pstmt.executeUpdate();
				if(rowsEffected>0)
					System.out.println("Data deleted successfully");
				else
					System.out.println("Data failed to be deleted");
			}
			catch(SQLException e)
			{
					e.printStackTrace();
			}	
		}
		else
		{
			System.out.println("Oops. Seems that our we have issues with our databse.Please wait till it is fixed.We regret any inconvenience caused.");
		}
		return rowsEffected;
	}
	
	//method to select all users
	public static ArrayList<BankBean> selectAll()
	{
		Connection conn=DbConnection.getConnection();
		ResultSet rs=null;
		BankBean bb;
		String selectQuery="select * from BankUsers";
		
		ArrayList<BankBean>list=new ArrayList<BankBean>();
		
		if(conn!=null)
		{
			try
			{	
				PreparedStatement pstmt=conn.prepareStatement(selectQuery);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bb=new BankBean();
					bb.setId(rs.getInt("id"));
					bb.setEmail(rs.getString("email"));
					bb.setPassword(rs.getString("password"));
					bb.setBalance(rs.getFloat("balance"));
					bb.setName(rs.getString("name"));
					list.add(bb);
				}
			}
			catch(SQLException e)
			{
					e.printStackTrace();
			}	
		}
		else
		{
			System.out.println("Oops. Seems that our we have issues with our databse.Please wait till it is fixed.We regret any inconvenience caused.");
		}
		return list;
		
	}
	
	//method to withdraw money
	public int withdrawMoney(BankBean bBean,float withdraw)
	{
		Connection conn=DbConnection.getConnection(); 
		String updateQuery="update BankUsers SET balance=balance-? where id=?;";
		
		PreparedStatement pstmt=null;
		int rowsEffected=0;
		if(conn!=null)
		{
			try
			{
				pstmt=conn.prepareStatement(updateQuery);
				
				pstmt.setFloat(1,withdraw);
				pstmt.setInt(2,bBean.getId());
				rowsEffected=pstmt.executeUpdate();
				if(rowsEffected>0)
					System.out.println("Data updated successfully");
				else
					System.out.println("Data failed to updated");
			}
			catch(SQLException e)
			{
					e.printStackTrace();
			}	
		}
		else
		{
			System.out.println("Oops. Seems that our we have issues with our databse.Please wait till it is fixed.We regret any inconvenience caused.");
		}
		return rowsEffected;
	}
	
	//method to deposit money
	public int depositMoney(BankBean bBean,float deposit)
	{
		Connection conn=DbConnection.getConnection(); 
		String updateQuery="update BankUsers SET balance=balance+? where id=?;";
		
		PreparedStatement pstmt=null;
		int rowsEffected=0;
		if(conn!=null)
		{
			try
			{
				pstmt=conn.prepareStatement(updateQuery);
				
				pstmt.setFloat(1,deposit);
				pstmt.setInt(2,bBean.getId());
				rowsEffected=pstmt.executeUpdate();
				if(rowsEffected>0)
					System.out.println("Data updated successfully");
				else
					System.out.println("Data failed to updated");
			}
			catch(SQLException e)
			{
					e.printStackTrace();
			}	
		}
		else
		{
			System.out.println("Oops. Seems that our we have issues with our databse.Please wait till it is fixed.We regret any inconvenience caused.");
		}
		return rowsEffected;
	}
	
	//method to check if user exists
	public static BankBean viewUser(String email,String password)
	{
		Connection conn=DbConnection.getConnection();
		 
		String checkQuery="SELECT * from BankUsers where email=? AND password=?;";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(checkQuery);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			BankBean b = null;
			while(rs.next())
			{
				b=new BankBean();
				b.setId(rs.getInt("id"));
				b.setEmail(rs.getString("email"));
				b.setPassword(rs.getString("password"));
				b.setBalance(rs.getFloat("balance"));
				b.setName(rs.getString("name"));
			}
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//method to transfer money
	public int TransferMoney(BankBean bBean,float transfer,String email,String name)
	{
		Connection conn=DbConnection.getConnection(); 
		String transferQuery="update BankUsers SET balance=balance-? where id=?;";
		String beneficiaryQuery="update BankUsers SET balance=balance+? where email=? and name=?";
		
		
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		
		int rowsEffected=0;
		int rowsEffected2=0;
		
		if(conn!=null)
		{
			try
			{
				pstmt=conn.prepareStatement(transferQuery);
				pstmt2=conn.prepareStatement(beneficiaryQuery);
				
				pstmt.setFloat(1,transfer);
				pstmt.setInt(2, bBean.getId());
				pstmt2.setFloat(1, transfer);
				pstmt2.setString(2, email);
				pstmt2.setString(3, name);
				
				
				
				rowsEffected=pstmt.executeUpdate();
				rowsEffected2=pstmt2.executeUpdate();
				
				if(rowsEffected>0 && rowsEffected2>0)
				{
					System.out.println("Data updated successfully");	
				}
				else if(rowsEffected>0 && rowsEffected2<=0 || rowsEffected2>0 && rowsEffected<=0)
				{
					System.out.println("Data may have been updated partially. Please check your balance.");
				}
				
					
				else
				{
					System.out.println("Data failed to updated");
				}
					
			}
			catch(SQLException e)
			{
					e.printStackTrace();
			}	
		}
		else
		{
			System.out.println("Oops. Seems that our we have issues with our databse.Please wait till it is fixed.We regret any inconvenience caused.");
		}
		return rowsEffected+rowsEffected2;
		
	}
	
	//method to check balance
	public static float viewBalance(String email,String password)
	{
		Connection conn=DbConnection.getConnection();
		 
		String checkQuery="SELECT balance from BankUsers where email=? AND password=?;";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(checkQuery);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			float b=0;
			while(rs.next())
			{
				b=rs.getFloat("balance");
			}
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}


