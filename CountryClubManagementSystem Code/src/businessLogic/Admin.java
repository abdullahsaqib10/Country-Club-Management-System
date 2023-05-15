package businessLogic;

import java.util.ArrayList;

import DB.DBHandler;

public class Admin extends User{
	
	//data members
	private int adminId;
	private ArrayList<Member> memberList;
	
	
	//constructors
	public Admin() {
		super();
		this.adminId = 0;
		this.memberList = new ArrayList<>();
	}
	
	
	public Admin(String name, String phNumber, String email, Account userAccount, int adminId, ArrayList<Member> memberList) {
		super(name, phNumber, email, userAccount);
		this.adminId = adminId;
		this.memberList = memberList;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public ArrayList<Member> getMemberList() {
		return memberList;
	}


	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}
	
	
	
	public void addMember(String name, String phNumber, String email, String userName, String password)
	{
		DBHandler DBObj = new DBHandler();
		
		//creating am account obj for the member
		int lastAccId = DBObj.getLastAccount();
		Account memberAccount = new Account(lastAccId+1,userName, password);
		DBObj.writeAccount(memberAccount);
		
		int lastMemberId = DBObj.getLastMember();
		Member newMember = new Member(name, phNumber, email, memberAccount, lastMemberId+1);
		DBObj.writeMember(newMember, this.adminId);
		
	}
	
	

}
