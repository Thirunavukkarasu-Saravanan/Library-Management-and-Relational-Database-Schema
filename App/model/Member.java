package cs5330_lib.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Member {
	
	private String lid;
	private String ssn;
	private String fname;
	private String mname;
	private String lname;
	private String fullname;
	private String phone;
	//private String mytpe;
	private String haddr;
	private String caddr;
	private String expdt;
	private String valdty;
	//private String isvalid;
	private String mtype;

	//private String role;
	
	
public Member() {}
	
	public Member(String lid, String ssn, String fname, String mname, String lname,
			String fullname, String phone, String mtype, String haddr, String caddr, String expdt,  String valdty) {
		this.setLid(lid);
		this.setSsn(ssn);
		this.setFname(fname);
		this.setMname(mname);
		this.setLname(lname);
		this.setFullname(fullname);
		this.phone = phone;
		this.setMtype(mtype);
		this.setHaddr(haddr);
		this.setCaddr(caddr);
		//this.state = state;
		this.setExpdt(expdt);
		this.setValdty(valdty);
		
		
	}

	






	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getHaddr() {
		return haddr;
	}

	public void setHaddr(String haddr) {
		this.haddr = haddr;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public String getValdty() {
		return valdty;
	}

	public void setValdty(String valdty) {
		this.valdty = valdty;
	}

	public String getExpdt() {
		return expdt;
	}

	public void setExpdt(String expdt) {
		this.expdt = expdt;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}


}
