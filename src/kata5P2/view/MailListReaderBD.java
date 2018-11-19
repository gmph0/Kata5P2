package kata5P2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
	
	public static List<String> read(String DataBase){
		List<String> lista = new ArrayList<>();	
		String sql = "SELECT * FROM EMAIL";
		
		try (Connection conn = DriverManager.getConnection(DataBase);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)){
			
			// Bucle sobre el conjunto de resgistros.
			while(rs.next()) {
				lista.add(rs.getString("Mail"));
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}


}
