package cs5330_lib.model;

public class Staff {
	
	private String Eno;
	private String SName;
	private String job_type;
	
	public Staff(){}

	public Staff(String eno, String sName, String job_type) {
		this.Eno = eno;
		this.SName = sName;
		this.job_type = job_type;
	}

	public String getEno() {
		return Eno;
	}

	public void setEno(String eno) {
		Eno = eno;
	}

	public String getSName() {
		return SName;
	}

	public void setSName(String sName) {
		SName = sName;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	
	

}
