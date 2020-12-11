package cs5330_lib.model;

public class Returnbook {
	
	private String risbn;
	private String rid;
	private String rcodt;
	private String rdt;
	
	
public Returnbook() {}
	
	public Returnbook(String risbn, String rid, String rcodt, String rdt) {
		this.setRisbn(risbn);
		this.setRid(rid);
		this.setRcodt(rcodt);
		this.setRdt(rdt);
		
	}

	public String getRisbn() {
		return risbn;
	}

	public void setRisbn(String risbn) {
		this.risbn = risbn;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRcodt() {
		return rcodt;
	}

	public void setRcodt(String rcodt) {
		this.rcodt = rcodt;
	}

	public String getRdt() {
		return rdt;
	}

	public void setRdt(String rdt) {
		this.rdt = rdt;
	}


}
