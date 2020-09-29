package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class BaseTDG {

	public static ArrayList<BaseDTO> getAllBases() {
		ArrayList<BaseDTO> list = new ArrayList<BaseDTO>();
		Connection c;
		
		try {
			c = DatabaseManager.getSingleton().getConnection();
			Statement stmt = c.createStatement();
			stmt.executeQuery("SELECT * FROM Base");
			ResultSet rs = stmt.getResultSet();

			while(rs.next()) {
				BaseDTO dto = new BaseDTO(rs.getInt(1), rs.getInt(2));
				list.add(dto);
			}
		} catch (Exception e) {
			DatabaseException.detectError(e, "Exception in BaseDTO.getAllBases()");
		}
		
		return list;
	}

}
