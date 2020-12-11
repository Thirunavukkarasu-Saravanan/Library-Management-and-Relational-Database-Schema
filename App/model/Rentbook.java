package cs5330_lib.model;

public class Rentbook {

	private String oisbn;
	private String cid;
	private String codt;
	private String duedt;
	private String noofbook;
	private String isovrdue;
	private String grcdt;	
	private String enumb;
	
	public Rentbook() {}
	
	public Rentbook(String oisbn, String cid, String codt, String duedt, String noofbook,
			String isovrdue, String grcdt, String enumb) {
		this.setOisbn(oisbn);
		this.setCid(cid);
		this.setCodt(codt);
		this.setDuedt(duedt);
		this.setNoofbook(noofbook);
		this.setIsovrdue(isovrdue);
		this.setGrcdt(grcdt);
		this.setEnumb(enumb);
		
		
	}

	public String getIsovrdue() {
		return isovrdue;
	}

	public void setIsovrdue(String isovrdue) {
		this.isovrdue = isovrdue;
	}

	public String getCodt() {
		return codt;
	}

	public void setCodt(String codt) {
		this.codt = codt;
	}

	public String getOisbn() {
		return oisbn;
	}

	public void setOisbn(String oisbn) {
		this.oisbn = oisbn;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getDuedt() {
		return duedt;
	}

	public void setDuedt(String duedt) {
		this.duedt = duedt;
	}

	public String getNoofbook() {
		return noofbook;
	}

	public void setNoofbook(String noofbook) {
		this.noofbook = noofbook;
	}

	public String getEnumb() {
		return enumb;
	}

	public void setEnumb(String enumb) {
		this.enumb = enumb;
	}

	public String getGrcdt() {
		return grcdt;
	}

	public void setGrcdt(String grcdt) {
		this.grcdt = grcdt;
	}
	
}
