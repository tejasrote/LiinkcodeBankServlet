package Linkcode.bank.Model;

public class Account {
	private int accno;
	private String cname;
	private String uname;
	private String pass;
	
	
	private int bal;
	public Account() {
		super();
		this.accno = accno;
		this.cname = cname;
		this.uname = uname;
		this.pass = pass;
		this.bal = bal;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	

}
