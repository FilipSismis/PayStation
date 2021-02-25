package databaselayer;

import java.sql.Connection;
import java.sql.Statement;


import java.sql.SQLException;
import java.sql.ResultSet;

import modellayer.*;


public class DatabasePZone implements IDbPZone { 
	
	public PZone getZonebyId(int zoneId) throws DatabaseLayerException {
		PZone foundZone = null;
		
		Connection con = DBConnection.getInstance().getDBcon();

		String baseSelect = "select * from dbo.PZone where id = " + zoneId;
		System.out.println(baseSelect);
	 
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(baseSelect);
			foundZone = buildObject(rs);
			stmt.close();
		} catch (SQLException ex) {
			foundZone = null;
			DatabaseLayerException dle = new DatabaseLayerException("Error retrieving data");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (NullPointerException ex) {
			foundZone = null;
			DatabaseLayerException dle = new DatabaseLayerException("Null pointer exception - possibly Connection object");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (Exception ex) {
			foundZone = null;
			DatabaseLayerException dle = new DatabaseLayerException("Data not retrieved! Technical error");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} finally {
			DBConnection.closeConnection();
		}
				
		return foundZone;
	}

	private PZone buildObject(ResultSet rs) throws SQLException {
		PZone object = null;
		object = new PZone(rs.getInt("id"), rs.getString("name"));
		return object;
	}
	
}
