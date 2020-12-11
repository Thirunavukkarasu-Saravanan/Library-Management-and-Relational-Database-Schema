package cs5330_lib.model;

import java.util.Objects;
import java.util.regex.Pattern;
// import dao

public class Book {
	
	private String ISBN;
	private String title;
	private String author;
	private String availability;
	private String location;
	private String rentbook;
	private String totalcopies;
	
	public Book() {}
	
	public Book(String isbn, String title, String author, String availability, String location,
			String rentbook, String totalcopies) {
		this.setISBN(isbn);
		this.setTitle(title);
		this.setAuthor(author);
		this.setAvailability(availability);
		this.setLocation(location);
		this.setRentbook(rentbook);
		this.setTotalcopies(totalcopies);
		
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRentbook() {
		return rentbook;
	}

	public void setRentbook(String rentbook) {
		this.rentbook = rentbook;
	}

	public String getTotalcopies() {
		return totalcopies;
	}

	public void setTotalcopies(String totalcopies) {
		this.totalcopies = totalcopies;
	}
	

}
