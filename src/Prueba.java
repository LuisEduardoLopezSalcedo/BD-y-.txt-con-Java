import java.io.*;
import java.sql.*;
import java.util.*;

public class Prueba {

	public static void main(String[] args) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		Connection con = null;
		
		Properties props = new Properties();
		props.put("user", "postgres");
		props.put("password", "123456");
		
		try {
			fw = new FileWriter("BD.txt");
			bw = new BufferedWriter(fw);
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from personas");
			
			while(rs.next()) {
				bw.write(rs.getString("nombre") + " " + rs.getInt("edad") + "\r\n" );
				System.out.print(rs.getString("nombre") + " " + rs.getInt("edad")  );			
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null) {
				try {
					con.close();					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}			
			if(bw != null) {
				try {
					bw.close();					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}			
		}
	}	
}
