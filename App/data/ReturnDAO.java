package cs5330_lib.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import cs5330_lib.model.*;
import cs5330_lib.util.*;






public class ReturnDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	
	public int returnupdate(Returnbook  returnbook) {
		int status = 0;
		int status1 = 0;
		Statement stmt;
		Statement stmt1;
		Connection conn = SQLConnection.getDBConnection();
		if (returnbook.getRisbn() != null){
			System.out.println("inside insertCheckout....");
			try {
				String queryString = "UPDATE db_library.book SET `Availability` = `Availability` + 1 WHERE `ISBN` = '" + returnbook.getRisbn() + "';";
//						+ "('" + rentbook.getOisbn() + "','" + rentbook.getCid() + "','"
//						+ rentbook.getCodt() + "','" + rentbook.getDuedt() + "','" + rentbook.getNoofbook() + "'"
//						+ ",'"
//						+ rentbook.getIsovrdue() + "','" + rentbook.getGrcdt() + "','" + rentbook.getEnumb() + "');";				
				
				stmt = conn.createStatement();
			//	System.err.println("Printing before execute..."+queryString);
				status = stmt.executeUpdate(queryString);
				conn.commit();
				//System.out.println("Printing status inside insertCheckout...."+status);
				if (status == 1){
					
					//String temp = book.getAvailability();
					stmt1 = conn.createStatement();
					int temp = 0;
					int retstat = 2;
					System.out.println(returnbook.getRisbn());
					System.out.println("Printing inside insertCheckout....");
					//int temp = Integer.parseInt(book.getAvailability()) -1;
					String queryString1 = "UPDATE db_library.checks_out SET `Due_date` = '" + returnbook.getRdt() + "', " + "`No_books` = '" + temp + "', " + "`is_overdue` ='" + retstat + "'   WHERE `O_ISBN` = '" + returnbook.getRisbn() +"';";
					System.err.println("Printing before execute..."+queryString1);
					status1 = stmt1.executeUpdate(queryString1);
					conn.commit();
				}
				else{ 
					System.out.println("insert checkout failed");
				}
				//status1 = stmt1.executeUpdate(queryString1);
				//System.out.println(addto.getRentbook());
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
			return status;
		
			
	}
	
	public static Book selectBook(String ISBN) {
		//Rentbook rentbook = new Rentbook();
		Book book = new Book();
//		int status_upd = 0
		Statement stmt;
		Connection conn = SQLConnection.getDBConnection();
		
		//System.out.println("Inside selectbook");
		//System.out.println(book.getISBN());
		//System.out.println(book.getAvailability());
		//System.out.println(Rentbook.class );
			try {
				
				String queryString = "Select `ISBN`,`Availability` from db_library.book where `ISBN` = '" + ISBN + "';";
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(queryString);
//				System.out.println("checking inside" + rs.next());
//				System.out.println(rs.getString("ISBN"));
//				System.out.println(rs.getString("Availability"));
				while(rs.next()){
					book.setISBN(rs.getString("ISBN"));
					book.setAvailability(rs.getString("Availability"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}	
		return book;
	}

}
