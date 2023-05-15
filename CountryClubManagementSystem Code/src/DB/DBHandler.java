package DB;

import java.sql.*;
import businessLogic.*;
import java.util.ArrayList;





public class DBHandler {
	
	String userName = "root"; //The username of the sql database
	String pass = "Barcelonano1"; //The pass of your database
	Connection con; //Connection object
	
	
	public DBHandler()
	{
		//Connect to DB
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/countryclubdb", userName, pass);
			System.out.println("Connected to DB");
		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
	}
	
	
	
	//Read all admins
	public ArrayList<Admin> getAdmins()
	{
		ArrayList<Admin> admins = new ArrayList<Admin>();
		
		Statement st;
		String query1 = "select * from Admin";
		
		try 
		{
			
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				ArrayList<Account> accounts = getAccounts();
				Account adminAcc = new Account();
				
				for (Account obj : accounts)
				{
					if (rs.getInt(5) == obj.getAccountId())
					{
						adminAcc = obj;
						break;
					}
						
				}
				
				Admin admin = new Admin(rs.getString(2), rs.getString(3), rs.getString(4), adminAcc, rs.getInt(1), null);
				//System.out.println(s.toString());
				
				admins.add(admin);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return admins;
		
	}
	
	
	//Read all members
	public ArrayList<Member> getMembers()
	{
		ArrayList<Member> members = new ArrayList<Member>();
		
		Statement st;
		String query1 = "select * from Member";
		
		try 
		{
			
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				ArrayList<Account> accounts = getAccounts();
				Account memberAcc = new Account();
				
				for (Account obj : accounts)
				{
					if (rs.getInt(5) == obj.getAccountId())
					{
						memberAcc = obj;
						break;
					}
						
				}
				
				Member member = new Member(rs.getString(2), rs.getString(3), rs.getString(4), memberAcc, rs.getInt(1));
				//System.out.println(s.toString());
				
				members.add(member);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return members;
		
	}
	
	
	
	//Read all members
	public ArrayList<Manager> getManagers()
	{
		ArrayList<Manager> managers = new ArrayList<Manager>();
		
		Statement st;
		String query1 = "select * from Manager";
		
		try 
		{
			
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				ArrayList<Account> accounts = getAccounts();
				Account managerAcc = new Account();
				
				for (Account obj : accounts)
				{
					if (rs.getInt(5) == obj.getAccountId())
					{
						managerAcc = obj;
						break;
					}
						
				}
				
				Manager manager = new Manager(rs.getString(2), rs.getString(3), rs.getString(4), managerAcc, rs.getInt(1), null);
				//System.out.println(s.toString());
				
				managers.add(manager);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return managers;
		
	}
	
	
	//InsertAccount
	public void writeMember(Member member, int adminId)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Member values('"+member.getMemberId()+"' ,'" + member.getName() + "','" + member.getPhNumber() + "','" + member.getEmail() + "','" + member.getUserAccount().getAccountId() + "','" + adminId +"')";
			st.executeUpdate(query1);
			System.out.println("Member Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in Member insertion");
			e.printStackTrace();
		}
	}
	
	
	
	//GetLast from Member table
	public int getLastMember()
	{
		int lastId = 0;
		
		Statement st;
		String query1 = "SELECT * FROM Member ORDER BY memberID DESC LIMIT 1;";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			if (rs.next()) //not empty
			{
				lastId = rs.getInt(1);
			}
			else //is empty
			{
				lastId = 0;
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	
	
	//Read all accounts
	public ArrayList<Account> getAccounts()
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		Statement st;
		String query1 = "select * from Account";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				Account acc = new Account(rs.getInt(1), rs.getString(2), rs.getString(3));
				accounts.add(acc);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	
	//InsertAccount
	public void writeAccount(Account acc)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Account values('"+acc.getAccountId()+"' ,'" + acc.getUserName() + "','" + acc.getPassword() +"')";        
			st.executeUpdate(query1);
			System.out.println("Account Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in Account insertion");
			e.printStackTrace();
		}
	}
	
	
	//GetLast from Accounts table
	public int getLastAccount()
	{
		int lastId = 0;
		
		Statement st;
		String query1 = "SELECT * FROM Account ORDER BY accountID DESC LIMIT 1;";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			if (rs.next()) //not empty
			{
				lastId = rs.getInt(1);
			}
			else //is empty
			{
				lastId = 0;
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	
	
	
	
	
	
	
	//Read all facilities
	public ArrayList<Facility> getFacilities()
	{
		ArrayList<Facility> facilities = new ArrayList<Facility>();
		
		Statement st;
		String query1 = "select * from Facility";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				Facility facility = new Facility(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				facilities.add(facility);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return facilities;
	}
	
	
	
	
	
	
	
	
	//Read all reservations
	public ArrayList<Reservation> getReservations()
	{
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		
		Statement st;
		String query1 = "select * from Reservation";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				Reservation reservation = new Reservation(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				reservations.add(reservation);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reservations;
	}
	
	
	//GetLast from Reservation table
	public int getLastReservation()
	{
		int lastId = 0;
		
		Statement st;
		String query1 = "SELECT * FROM Reservation ORDER BY reservationID DESC LIMIT 1;";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			if (rs.next()) //not empty
			{
				lastId = rs.getInt(1);
			}
			else //is empty
			{
				lastId = 0;
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	
	
	//Insert Reservation
	public void writeReservation(Reservation res)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Reservation values('"+res.getReservationId()+"' ,'" + res.getFacilityId() + "','" + res.getMemberId() +"')";        
			st.executeUpdate(query1);
			System.out.println("Reservation Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in Reservation insertion");
			e.printStackTrace();
		}
	}

}





