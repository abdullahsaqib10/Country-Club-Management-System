package businessLogic;

public class Reservation {
	
	//data members
	private int reservationId;
	private int facilityId;
	private int memberId;
	
	
	public Reservation() {
		super();
		this.reservationId = 0;
		this.facilityId = 0;
		this.memberId = 0;
	}
	
	
	public Reservation(int reservationId, int facilityId, int memberId) {
		super();
		this.reservationId = reservationId;
		this.facilityId = facilityId;
		this.memberId = memberId;
	}


	public int getReservationId() {
		return reservationId;
	}


	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}


	public int getFacilityId() {
		return facilityId;
	}


	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
	
	
	

}
