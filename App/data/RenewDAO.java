package cs5330_lib.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import cs5330_lib.model.*;
import cs5330_lib.util.*;





public class RenewDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();
	
	public int updatemembership(Renewlid renewlid) {
		int status = 0;
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		if (renewlid.getRlid() != null){
			try {
				String queryString = "UPDATE db_library.member SET `Valid_thru` = '" + renewlid.getRvaliddt() 
				+ "', "
				+ "`Validity` = '" + renewlid.getRvalidflag() + "' WHERE `LID` = '" + renewlid.getRlid() + "';";
				stmt = conn.createStatement();
				System.err.println("Printing before execute..."+queryString);
				status = stmt.executeUpdate(queryString);
				conn.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return status;
	}

}
