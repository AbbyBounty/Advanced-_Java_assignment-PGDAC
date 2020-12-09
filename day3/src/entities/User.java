package entities;

public class User {
	String uid,password,fname,mname,lname,emailid,contact;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uid, String password, String fname, String mname, String lname, String emailid, String contact) {
		super();
		this.uid = uid;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.emailid = emailid;
		this.contact = contact;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", password=" + password + ", fname=" + fname + ", mname=" + mname + ", lname="
				+ lname + ", emailid=" + emailid + ", contact=" + contact + "]";
	}

	
	
	
}
