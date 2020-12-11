package cs5330_lib.model;

public class Catalogue {
	
	private String ISBN;
	private String Description;
	private String BType;
	private String Subjectarea;
	private String Title;
	private String Author;
	
	public Catalogue(){}
	public Catalogue(String iSBN, String description, String bType, String subjectarea, String title, String author) {
		this.setISBN(iSBN);
		this.setDescription(description);
		this.setBType(bType);
		this.setSubjectarea(subjectarea);
		this.setTitle(title);
		this.setAuthor(author);
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBType() {
		return BType;
	}

	public void setBType(String bType) {
		BType = bType;
	}

	public String getSubjectarea() {
		return Subjectarea;
	}

	public void setSubjectarea(String subjectarea) {
		Subjectarea = subjectarea;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

}
