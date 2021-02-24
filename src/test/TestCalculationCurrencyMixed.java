package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyMixed {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Entering 5 cent and 50 øre should make the display report 5 minutes parking time.
	 */
	@Test
	public void shouldDisplay4MinFor5CentAnd5Cent() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 4;	// In minutes
		int coinValue1 = 5;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.FRACTION;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		// Assert
		assertEquals("Should be displayed 4 min for 5 cents and 5 cents", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test
	public void shouldDisplay11MinFor1DkrAnd1Dkr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 11;	// In minutes
		int coinValue1 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.INTEGER;
;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		// Assert
		assertEquals("Should be displayed 11 min for 1 Dkr and 1 Dkr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test
	public void shouldDisplay7MinFor5CentsAnd1Dkr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 7;	// In minutes
		int coinValue1 = 5;
		int coinValue2 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.FRACTION;
		Currency.ValidCurrency coinCurrency2 = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType2 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue2, coinCurrency2, coinType2);
		// Assert
		assertEquals("Should be displayed 7 min for 5 cents and 1 Dkr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay0MinFor1NkrAnd1Nkr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 0;	// In minutes
		int coinValue1 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		// Assert
		assertEquals("Should be displayed 0 min for 1Nkr and 1 Nkr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay5MinFor1DkrAnd1Nkr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 5;	// In minutes
		int coinValue1 = 1;
		int coinValue2 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.INTEGER;
		Currency.ValidCurrency coinCurrency2 = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType2 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue2, coinCurrency2, coinType2);
		// Assert
		assertEquals("Should be displayed 5 min for 1Dkr and 1 Nkr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay2MinFor5CentsAnd1Nkr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 2;	// In minutes
		int coinValue1 = 5;
		int coinValue2 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.FRACTION;
		Currency.ValidCurrency coinCurrency2 = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType2 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue2, coinCurrency2, coinType2);
		// Assert
		assertEquals("Should be displayed 5 min for 5 cents and 1 Nkr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay0MinFor1SkrAnd1Skr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 0;	// In minutes
		int coinValue1 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.SEK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		// Assert
		assertEquals("Should be displayed 0 min for 1 Skr and 1 Skr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay5MinFor1DkrAnd1Skr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 5;	// In minutes
		int coinValue1 = 1;
		int coinValue2 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.INTEGER;
		Currency.ValidCurrency coinCurrency2 = Currency.ValidCurrency.SEK;
		Currency.ValidCoinType coinType2 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue2, coinCurrency2, coinType2);
		// Assert
		assertEquals("Should be displayed 5 min for 1 Dkr and 1 Skr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay2MinFor5CentsAnd1Skr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 2;	// In minutes
		int coinValue1 = 5;
		int coinValue2 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.FRACTION;
		Currency.ValidCurrency coinCurrency2 = Currency.ValidCurrency.SEK;
		Currency.ValidCoinType coinType2 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue2, coinCurrency2, coinType2);
		// Assert
		assertEquals("Should be displayed 2 min for 5 cents and 1 Skr", expectedParkingTime,ps.readDisplay());		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay0MinFor1SkrAnd1Nkr() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 0;	// In minutes
		int coinValue1 = 1;
		int coinValue2 = 1;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.SEK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.FRACTION;
		Currency.ValidCurrency coinCurrency2 = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType2 = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue1, coinCurrency1, coinType1);
		ps.addPayment(coinValue2, coinCurrency2, coinType2);
		// Assert
		assertEquals("Should be displayed 0 min for 1 Skr and 1 Nkr", expectedParkingTime,ps.readDisplay());		
	}
	
	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}
	
}
