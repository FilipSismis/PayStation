package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.Currency;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyDkk {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Entering 50 øre should make the display report 3 minutes parking time.
	 */
	@Test
	public void shouldDisplay3MinFor50Ore() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 3;	// In minutes
		int coinValue = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 3 min for 50 øre", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay6MinFor1kr() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 6;	// In minutes
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 6 min for 1 kr.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay11MinFor2kr() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 11;	// In minutes
		int coinValue = 2;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 11 min for 2 kr.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay27MinFor5kr() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 27;	// In minutes
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 27 min for 5 kr.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay54MinFor10kr() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 54;	// In minutes
		int coinValue = 10;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 54 min for 10 kr.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay107MinFor20kr() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 107;	// In minutes
		int coinValue = 20;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 107 min for 20 kr.", expectedParkingTime, ps.readDisplay());
	}

	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}	
	
}
