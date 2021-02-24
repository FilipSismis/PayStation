package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyEuro {

	private ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}
	
	/**
	 * Entering no coins should make the display report 0 minutes parking time.
	 */
	@Test
	public void shouldDisplay0() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 0;
		
		// Act
		// No action
		
		// Assert
		assertEquals("Should display 0 min for no coins", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay0MinFor1Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 0;	// In minutes		
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 0 min for 1 cents.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay1MinFor2Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 1;	// In minutes		
		int coinValue = 2;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 1 min for 2 cents.", expectedParkingTime, ps.readDisplay());
	}

	/**
	 * Entering 5 cents should make the display report 2 minutes parking time
	 */
	@Test
	public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 2;	// In minutes		
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 2 min for 5 cents.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay4MinFor10Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 4;	// In minutes		
		int coinValue = 10;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 4 min for 10 cents.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay8MinFor20Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 8;	// In minutes		
		int coinValue = 20;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 8 min for 20 cents.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay20MinFor50Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 20;	// In minutes		
		int coinValue = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 20 min for 50 cents.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay40MinFor1Euro() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 40;	// In minutes		
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 40 min for 1 euro.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay80MinFor2Euro() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 80;	// In minutes		
		int coinValue = 2;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 80 min for 2 euro.", expectedParkingTime, ps.readDisplay());
	}
	
	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}

	
}
