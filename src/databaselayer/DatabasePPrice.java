package databaselayer;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import java.sql.SQLException;
import java.sql.ResultSet;

import modellayer.*;

public class DatabasePPrice implements IDbPPrice {
	
	//Hardcoded for now. TODO: Use database
	public PPrice getCurrentPrice() {
		return new PPrice();
	}
	
	public PPrice getPriceByZoneId(int zoneId) throws DatabaseLayerException {
		PPrice foundPrice = null;
		
		Calendar calendar = Calendar.getInstance();
		java.sql.Date dateNow = new java.sql.Date(calendar.getTime().getTime());
		
		Connection con = DBConnection.getInstance().getDBcon();

		String baseSelect = "select top 1 price, pZone_id from PPrice ";
		baseSelect += "where pZone_id = " + zoneId + " and starttime < '" + dateNow + "' ";
		baseSelect += "order by starttime desc";
		System.out.println(baseSelect);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(baseSelect);
			foundPrice = buildObject(rs);
			stmt.close();
		} catch (SQLException ex) {
			foundPrice = null;
			DatabaseLayerException dle = new DatabaseLayerException("Error retrieving data");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (NullPointerException ex) {
			foundPrice = null;
			DatabaseLayerException dle = new DatabaseLayerException("Null pointer exception - possibly Connection object");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (Exception ex) {
			foundPrice = null;
			DatabaseLayerException dle = new DatabaseLayerException("Data not retrieved! Technical error");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} finally {
			DBConnection.closeConnection();
		}
				
		return foundPrice;
	}
	
	private PPrice buildObject(ResultSet rs) throws SQLException, DatabaseLayerException {
		PPrice object = null;
		DatabasePZone dbZone = new DatabasePZone();
		object = new PPrice(rs.getInt("price"), dbZone.getZonebyId(rs.getInt("pZone_id")));
		return object;
	}
	
	
}
