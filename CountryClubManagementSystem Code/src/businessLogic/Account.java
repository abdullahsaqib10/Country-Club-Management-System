package businessLogic;

public class Account {
	
	//data members
	private int accountId;
	private String userName;
	private String pass;
	
	
	//Constructors
	public Account()
	{
		super();
		this.accountId = 0;
		this.userName = null;
		this.pass = null;
	}
	
	public Account(int accountId, String userName, String password) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.pass = password;
	}
	
	
	
	//getters and setters
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String password) {
		this.pass = password;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userName=" + userName + ", pass=" + pass + "]";
	}
		
		
	
	

}
