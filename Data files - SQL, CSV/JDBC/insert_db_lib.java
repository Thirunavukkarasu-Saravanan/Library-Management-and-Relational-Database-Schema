package db_lib;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class insert_db_lib {
public static void main(String[] args) {
		
		try {

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library", "root", "worldshaker");
			BufferedReader in=new BufferedReader( new FileReader("src/db_lib/book.csv"));
			BufferedReader in3=new BufferedReader( new FileReader("src/db_lib/catalogue.csv"));
			BufferedReader in1=new BufferedReader( new FileReader("src/db_lib/member.csv"));
			BufferedReader in4=new BufferedReader( new FileReader("src/db_lib/staff.csv"));
			
			String line="";
			String line1="";
			String line3="";
			String line4="";

//Book
			 while( (line=in.readLine())!=null)
	            {
	                line=line.replace("'","");
	                String[] temp=line.split( ",");
	                String query="insert into book values('"+Integer.parseInt(temp[0])+"','"+temp[1]+"','"+temp[2]+"','"+Integer.parseInt(temp[3])+"','"+temp[4]+"','"+Integer.parseInt(temp[5])+"','"+Integer.parseInt(temp[6])+"')";
	                PreparedStatement stmt = conn.prepareStatement(query);
	                stmt.executeUpdate(query);
	                stmt.close();
	            }		
			 
//Catalogue
			while( (line3=in3.readLine())!=null)
            {
                line3=line3.replace("'","");
                String[] temp=line3.split( ",");
                String query="insert into catalogue values('"+Integer.parseInt(temp[0])+"','"+temp[1]+"','"+temp[2]+"','"+temp[3]+"','"+temp[4]+"','"+temp[5]+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
            }
			 
// Member
			 while( (line1=in1.readLine())!=null)
	            {

	                line1=line1.replace("'","");
	                String[] temp=line1.split( ",");
	                String query="insert into member values('"+Integer.parseInt(temp[0])+"','"+Integer.parseInt(temp[1])+"','"+temp[2]+"','"+temp[3]+"','"+temp[4]+"','"+temp[5]+"','"+Integer.parseInt(temp[6])+"','"+temp[7]+"','"+temp[8]+"','"+temp[9]+"','"+temp[10]+"','"+Integer.parseInt(temp[11])+"')";
	                PreparedStatement stmt = conn.prepareStatement(query);
	                stmt.executeUpdate(query);
	                stmt.close();
	            }
			

// Staff
			while( (line4=in4.readLine())!=null)
            {

                line4=line4.replace("'","");
                String[] temp=line4.split( ",");
                String query="insert into staff values('"+Integer.parseInt(temp[0])+"','"+temp[1]+"','"+temp[2]+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
            }
			 
			in.close();
			in1.close();
			in3.close();
			in4.close();
		
	}
		catch(Exception ex){
			ex.printStackTrace();
			
		}

	}
}
