package cs5330_lib.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import cs5330_lib.model.*;
import cs5330_lib.util.*;





public class BookDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();
	
	public int insertBook(Book addto) {
		int status = 0;
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		if (addto.getISBN() != null){
			System.out.println(addto.getRentbook());
			try {
				String queryString = "INSERT INTO db_library.book (`ISBN`,`Title`,`Author`,`Availability`,`Location`,`Is_rent`,`Total_copies`) VALUES "
						+ "('" + addto.getISBN() + "','" + addto.getTitle() + "','"
						+ addto.getAuthor() + "','" + addto.getAvailability() + "','" + addto.getLocation() + "'"
						+ ",'"
						+ addto.getRentbook() + "','" + addto.getTotalcopies() + "');";
				
				stmt = conn.createStatement();
				status = stmt.executeUpdate(queryString);
				//System.out.println(addto.getRentbook());
				conn.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return status;
	}
	
	public ArrayList<Book> viewBooks()
	{
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Book> viewbooklist = new ArrayList<Book>();
		Connection conn = SQLConnection.getDBConnection();
		try {
			String queryString = "Select * from db_library.book";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			if(rs != null)
			{
				while(rs.next()){
				Book newbook = new Book(rs.getString("ISBN"),rs.getString("Title"), rs.getString("Author"), rs.getString("Availability"), rs.getString("Location"),
						rs.getString("Is_rent"), rs.getString("Total_copies"));
				viewbooklist.add(newbook);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viewbooklist;
	}

	public ArrayList<Catalogue> viewCatalogue() {
	
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Catalogue> viewcataloguelist = new ArrayList<Catalogue>();
		Connection conn = SQLConnection.getDBConnection();
		try {
			String queryString = "Select * from db_library.catalogue";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			if(rs != null)
			{
				while(rs.next()){
				Catalogue newcatalogue = new Catalogue(rs.getString("ISBN"),rs.getString("Description"), rs.getString("BType"), rs.getString("Subjectarea"), rs.getString("Title"),
						rs.getString("Author"));
				viewcataloguelist.add(newcatalogue);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viewcataloguelist;
	}
	public ArrayList<Member> viewMember() {
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Member> viewmemberlist = new ArrayList<Member>();
		Connection conn = SQLConnection.getDBConnection();
		try {
			String queryString = "Select * from db_library.member";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			if(rs != null)
			{
				while(rs.next()){
				Member newmember = new Member(rs.getString("LID"),rs.getString("SSN"),rs.getString("Fname"),rs.getString("MName"),rs.getString("Lname"), rs.getString("Fullname"), rs.getString("Phone"), rs.getString("Mtype"),
						rs.getString("HAddr"),rs.getString("CAddr"),rs.getString("Valid_thru"),rs.getString("Validity"));
				viewmemberlist.add(newmember);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viewmemberlist;
	}
public ArrayList<Staff> viewStaff() {
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Staff> viewstafflist = new ArrayList<Staff>();
		Connection conn = SQLConnection.getDBConnection();
		try {
			String queryString = "Select * from db_library.staff";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			if(rs != null)
			{
				while(rs.next()){
				Staff newstaff = new Staff(rs.getString("Eno"),rs.getString("SName"),rs.getString("job_type"));
				viewstafflist.add(newstaff);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viewstafflist;
	}
public ArrayList<Notice> viewNotice() {
	
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList<Notice> viewnoticelist = new ArrayList<Notice>();
	Connection conn = SQLConnection.getDBConnection();
	try {
		String queryString = "Select * from db_library.notice";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryString);
		if(rs != null)
		{
			while(rs.next()){
			Notice newnotice = new Notice(rs.getString("NID"),rs.getString("Ret_date"),rs.getString("NType"),rs.getString("NTMType"),rs.getString("Enum"));
			viewnoticelist.add(newnotice);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return viewnoticelist;
}

public Rentbook viewReceipt(String ISBN, String CID)
{
	Rentbook receipt = new Rentbook();
	Statement stmt = null;
	ResultSet rs = null;
	Connection conn = SQLConnection.getDBConnection();
	try {
		String queryString = "select * from db_library.checks_out where CID ='"+CID+"' and O_ISBN = '"+ISBN+"'";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryString);
		if(rs != null)
		{
			while(rs.next()){
			receipt.setCid(rs.getString("CID"));
			receipt.setOisbn(rs.getString("O_ISBN"));
			receipt.setCodt(rs.getString("Check_out_date"));
			receipt.setDuedt(rs.getString("Due_date"));
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return receipt;

}

}

