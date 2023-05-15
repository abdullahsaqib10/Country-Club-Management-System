package businessLogic;

import java.util.ArrayList;

import DB.DBHandler;

public class Member extends User{
	
	private int memberId;
	
	

	//Constructors
	public Member() {
		super();
		this.memberId = 0;
	}

	public Member(String name, String phNumber, String email, Account userAccount, int memberId) {
		super(name, phNumber, email, userAccount);
		this.memberId = memberId;
	}
	
	
	//getters setters
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	

	//select the facilities
	public void selectFacility(Facility obj)
	{
		DBHandler DBObj = new DBHandler();
		
		//creating a reservation for a member facility
		int lastResId = DBObj.getLastReservation();
		Reservation res = new Reservation(lastResId+1,obj.getFacilityId(), this.getMemberId());
		DBObj.writeReservation(res);
		
	}
	
	
	

}
