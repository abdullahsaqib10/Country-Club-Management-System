package businessLogic;

import java.util.ArrayList;

public class Manager extends User{
	
	//Data members
	private int managerId;
	private ArrayList<Facility> facilityList;
	
	
	//constructors
	public Manager() {
		super();
		this.managerId = 0;
		this.facilityList = new ArrayList<>();
	}
	
	
	public Manager(String name, String phNumber, String email, Account userAccount, int managerId, ArrayList<Facility> facilityList) {
		super(name, phNumber, email, userAccount);
		this.managerId = managerId;
		this.facilityList = facilityList;
	}

}
