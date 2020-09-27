package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Datasource.DatabaseException;
import Datasource.DatabaseManager;

public class BaseTDG {

	public ArrayList<BaseDTO> getAllBases() 
	{
		ArrayList<BaseDTO> data = new ArrayList<BaseDTO>();
		ResultSet rs;
		
		try {
			Connection cn = DatabaseManager.getSingleton().getConnection();
			rs = cn.createStatement().executeQuery("SELECT * FROM Base");
			//rs.next();
			while(rs.next()) {
				data.add(new BaseDTO(rs.getInt("baseID"), rs.getString("baseName"), rs.getInt("baseSolute")));
				}	
		} catch (Exception e) {
				DatabaseException.detectError(e);	
		}
		
		return data;
	}

}
