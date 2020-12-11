package cs5330_lib.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import cs5330_lib.model.*;
import cs5330_lib.util.*;





public class MemberDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();
	
	public int insertUser(Member register) {
		int status = 0;
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		if (register.getLid() != null){
			try {
				String queryString = "INSERT INTO db_library.member (`LID`,`SSN`,`FName`,`MName`,`LName`,`Fullname`,`Phone`,`MType`,`HAddr`,`CAddr`,`Valid_thru`,`Validity`) VALUES "
						+ "('" + register.getLid() + "','" + register.getSsn() + "','"
						+ register.getFname() + "','" + register.getMname() + "','" + register.getLname() + "'"
						+ ",'"
						+ register.getFullname() + "','" + register.getPhone() + "','" + register.getMtype() + "','"
						+ register.getHaddr() + "','" + register.getCaddr() + "','" + register.getExpdt() 
						 + "','" + register.getValdty() + "');";
				
				stmt = conn.createStatement();
				status = stmt.executeUpdate(queryString);
				conn.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return status;
	}

}
