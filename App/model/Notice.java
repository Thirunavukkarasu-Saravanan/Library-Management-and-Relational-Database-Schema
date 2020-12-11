package cs5330_lib.model;

public class Notice {
	
	private String NID;
	private String Ret_date;
	private String NType;
	private String NTMType;
	private String Enum;
	
	public Notice(){}

	public Notice(String nID, String ret_date, String nType, String nTMType, String enum1) {
		
		this.NID = nID;
		this.Ret_date = ret_date;
		this.NType = nType;
		this.NTMType = nTMType;
		this.Enum = enum1;
	}

	public String getNID() {
		return NID;
	}

	public void setNID(String nID) {
		NID = nID;
	}

	public String getRet_date() {
		return Ret_date;
	}

	public void setRet_date(String ret_date) {
		Ret_date = ret_date;
	}

	public String getNType() {
		return NType;
	}

	public void setNType(String nType) {
		NType = nType;
	}

	public String getNTMType() {
		return NTMType;
	}

	public void setNTMType(String nTMType) {
		NTMType = nTMType;
	}

	public String getEnum() {
		return Enum;
	}

	public void setEnum(String enum1) {
		Enum = enum1;
	}
	

}
