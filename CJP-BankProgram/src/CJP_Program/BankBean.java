package CJP_Program;

public class BankBean {
	private int id;
	private String email;
	private String password;
	public float balance;
	private String name;
	private int Transferid;
	
	public int getTransferid() {
		return Transferid;
	}
	public void setTransferid(int transferid) {
		Transferid = transferid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
