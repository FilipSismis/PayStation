package test;

import static org.junit.Assert.*;

import org.junit.*;
import java.time.LocalDate;

//import controllayer.ControlPayStation;
//import controllayer.Currency;
//import controllayer.IPayStation;
//import controllayer.IReceipt;
//import controllayer.IllegalCoinException;

import databaselayer.*;
import modellayer.*;
import controllayer.*;

//import static org.junit.Assert.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestDatabaseAccess {
	
	DBConnection con = null;
	static PBuy tempPBuy;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		con = DBConnection.getInstance();
	}
	
	
	@Test
	public void wasConnected() {
		assertNotNull("Connected - connection cannot be null", con);
		
		DBConnection.closeConnection();
		boolean wasNullified = DBConnection.instanceIsNull();
		assertTrue("Disconnected - instance set to null", wasNullified);
		
		con = DBConnection.getInstance();
		assertNotNull("Connected - connection cannot be null", con);		
	}
	
	
	@Test
	public void wasInsertedBuy() throws DatabaseLayerException {
		
		// Arrange
		LocalDate timeNow = java.time.LocalDate.now();
		double payedCentAmount = 100;
		
		tempPBuy = new PBuy();
		
		PPayStation pStat = new PPayStation(1, "P-423E");
		pStat.setAmount(payedCentAmount);
		tempPBuy.setAssociatedPaystation(pStat);
		tempPBuy.setBuyTime(timeNow);
		
		DatabasePBuy dbPbuy = new DatabasePBuy();
		
		// Act
		int key = dbPbuy.insertParkingBuy(tempPBuy);
		
		// Assert
		assertTrue("Buy was inserted if the key is bigger than 0", key > 0);
		
	}	
	
	
	@Test
	public void wasRetrievedPriceDatabaselayer() throws DatabaseLayerException {
		
		// Arrange
		PPrice foundPrice = null;
		int pZoneId = 2;
		DatabasePPrice dbPrice = new DatabasePPrice();
		
		// Act
		foundPrice = dbPrice.getPriceByZoneId(pZoneId);
		
		// Assert
		assertNotNull("Price retrieved - can not be null", foundPrice);
		
	}
	
	@Test(expected = DatabaseLayerException.class)
	public void wasNotRetrievedPriceDatabaselayer() throws DatabaseLayerException {
		
		// Arrange
		PPrice foundPrice = null;
		int pZoneId = -2;
		DatabasePPrice dbPrice = new DatabasePPrice();
		
		// Act
		foundPrice = dbPrice.getPriceByZoneId(pZoneId);
		
		// Assert
		assertNotNull("Price retrieved - can not be null", foundPrice);
		
	}
	
	@Test
	public void wasRetrievedZoneDatabaselayer() throws DatabaseLayerException {
		
		// Arrange
		PZone foundZone = null;
		int pZoneId = 2;
		DatabasePZone dbZone = new DatabasePZone();
		
		// Act
		foundZone = dbZone.getZonebyId(pZoneId);
		
		// Assert
		assertNotNull("Zone retrieved - can not be null", foundZone);
		
	}
	
	@Test(expected = DatabaseLayerException.class)
	public void wasNotRetrievedZoneDatabaselayer() throws DatabaseLayerException {
		
		// Arrange
		PZone foundZone = null;
		int pZoneId = -2;
		DatabasePZone dbZone = new DatabasePZone();
		
		// Act
		foundZone = dbZone.getZonebyId(pZoneId);
		
		// Assert
		assertNotNull("Zone retrieved - can not be null", foundZone);
		
	}
	
	
	@Test
	public void wasRetrievedPriceControllayer() throws DatabaseLayerException {

		// Arrange
		ControlPrice controlPrice = new ControlPrice();
		PPrice price = null;
		int pZoneId = 2;
		// Act
		price = controlPrice.getPriceRemote(pZoneId);
		// Assert
		assertNotNull("Price retrieved - can not be null", price);
		
	}
	
	@Test(expected = DatabaseLayerException.class)
	public void wasNotRetrievedPriceControllayer() throws DatabaseLayerException {

		// Arrange
		ControlPrice controlPrice = new ControlPrice();
		PPrice price = null;
		int pZoneId = -2;
		// Act
		price = controlPrice.getPriceRemote(pZoneId);
		// Assert
		assertNotNull("Price retrieved - can not be null", price);
		
	}
	
	
	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		DBConnection.closeConnection();
	}	
	
	@AfterClass
	public static void cleanUpWhenFinish() {
		// 		
		// Arrange
		DatabasePBuy dbPbuy = new DatabasePBuy();
		int numDeleted = 0;
		
		// Act
		try {
			numDeleted = dbPbuy.deleteParkingBuy(tempPBuy);
		} catch(Exception ex) { 
			System.out.println("Error: " + ex.getMessage());
		} finally {
			DBConnection.closeConnection();
		}
	
		// Assert
		assertEquals("One row deleted", 1, numDeleted );
	}	

}
