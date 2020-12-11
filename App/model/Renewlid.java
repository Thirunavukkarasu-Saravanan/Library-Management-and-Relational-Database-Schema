package cs5330_lib.model;

public class Renewlid {
	
	private String rlid;
	private String rvaliddt;
	private String rvalidflag;
	
 public Renewlid() {}
	
	public Renewlid(String rlid, String rvaliddt, String rvalidflag ) {
		this.setRlid(rlid);
		this.setRvaliddt(rvaliddt);
		this.setRvalidflag(rvalidflag);		
		
	}

	public String getRlid() {
		return rlid;
	}

	public void setRlid(String rlid) {
		this.rlid = rlid;
	}

	public String getRvaliddt() {
		return rvaliddt;
	}

	public void setRvaliddt(String rvaliddt) {
		this.rvaliddt = rvaliddt;
	}

	public String getRvalidflag() {
		return rvalidflag;
	}

	public void setRvalidflag(String rvalidflag) {
		this.rvalidflag = rvalidflag;
	}


}
