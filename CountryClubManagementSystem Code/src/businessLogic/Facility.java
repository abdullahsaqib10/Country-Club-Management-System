package businessLogic;
import java.util.ArrayList;

import DB.DBHandler;


public class Facility {
	
	//Data members
	private int facilityId;
	private String name;
	private int capacity;
	private int price;
	private ArrayList<Member> reservedMembers;
	
	
	public Facility() {
		super();
		this.facilityId = 0;
		this.name = null;
		this.capacity = 0;
		this.price = 0;
		this.reservedMembers = new ArrayList<>();
	}
	
	
	
	public Facility(int facilityId, String name, int capacity, int price) {
		super();
		this.facilityId = facilityId;
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		this.reservedMembers = new ArrayList<>();
	}



	public int getFacilityId() {
		return facilityId;
	}



	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public ArrayList<Member> getMembers() {
		return reservedMembers;
	}



	public void setMembers(ArrayList<Member> members) {
		this.reservedMembers = members;
	}
	
	
	
	public ArrayList<Facility> displayFacilities()
	{
		ArrayList<Facility> tempFacilities = new ArrayList<Facility>();
		ArrayList<Facility> facilities = new ArrayList<Facility>();
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		ArrayList<Member> members = new ArrayList<Member>();
		DBHandler DBObj = new DBHandler();
		
		tempFacilities = DBObj.getFacilities();
		reservations = DBObj.getReservations();
		members = DBObj.getMembers();
		
		for (Facility facility : tempFacilities)
		{
			Facility fac = facility;
			ArrayList<Member> facMembers = new ArrayList<Member>();
			for (Reservation res : reservations)
			{
				if (res.getFacilityId() == facility.getFacilityId())
				{
					for (Member memObjs : members)
					{
						if (memObjs.getMemberId() == res.getMemberId())
						{
							facMembers.add(memObjs);
							fac.setCapacity(fac.getCapacity()-1);
							break;
						}
					}
					
				}
			}
			fac.setMembers(facMembers);
			facilities.add(fac);
		}
		
		
		
		return facilities;
	}
	
	

}
