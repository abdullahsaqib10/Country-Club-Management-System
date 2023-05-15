package businessLogic;

import DB.*;
import java.util.ArrayList;

public class Controller {

	DBHandler dbObj = new DBHandler();
	static Member memberObj = new Member();
	static Admin adminObj = new Admin();
	static Manager managerObj = new Manager();
	static Facility facilityObj = new Facility();
	
	
	
	
	
	public DBHandler getDbObj() {
		return dbObj;
	}

	public void setDbObj(DBHandler dbObj) {
		this.dbObj = dbObj;
	}

	public static Member getMemberObj() {
		return memberObj;
	}

	public static void setMemberObj(Member memberObj) {
		Controller.memberObj = memberObj;
	}

	public static Admin getAdminObj() {
		return adminObj;
	}

	public static void setAdminObj(Admin adminObj) {
		Controller.adminObj = adminObj;
	}

	public static Manager getManagerObj() {
		return managerObj;
	}

	public static void setManagerObj(Manager managerObj) {
		Controller.managerObj = managerObj;
	}

	public static Facility getFacilityObj() {
		return facilityObj;
	}

	public static void setFacilityObj(Facility facilityObj) {
		Controller.facilityObj = facilityObj;
	}

	//Login
	public ArrayList<Admin> getAdmins()
	{
		return dbObj.getAdmins();
	}
	
	public ArrayList<Member> getMembers()
	{
		return dbObj.getMembers();
	}
	
	public ArrayList<Manager> getManagers()
	{
		return dbObj.getManagers();
	}
	
	
	
	
	public void setCurrentMember(Member member)
	{
		memberObj = member;
	}
	
	public void setCurrentAdmin(Admin admin)
	{
		adminObj = admin;
	}
	
	public void setCurrentManager(Manager manager)
	{
		managerObj = manager;
	}
	
	
	//Add member to the system though admin
	public void addMember(String name, String phNumber, String email, String userName, String password)
	{
		adminObj.addMember(name, phNumber, email, userName, password);
	}
	
	
	
	//display the facilities
	public ArrayList<Facility> displayFacilities()
	{
		return facilityObj.displayFacilities();
	}
	
	
	//select the facilities
	public void selectFacility(Facility obj)
	{
		memberObj.selectFacility(obj);
	}
	
	
	
	
}
