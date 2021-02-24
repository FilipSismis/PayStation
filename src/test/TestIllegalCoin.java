package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import controllayer.*;
import modellayer.Currency;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestIllegalCoin {

	ControlPayStation ps;
	int expectedParkingTime;
	
	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
		expectedParkingTime = 0;
	}

	/**
	 * Verify that illegal coins are rejected.
	 */
		
	// unknown Euro coin value
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalEuroCoinFraction() throws IllegalCoinException {
		//Arrange
		int coinValue = 37;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 0 min for 37 cents.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalEuroCoin() throws IllegalCoinException {
		//Arrange
		int coinValue = 6;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 0 min for 6 euro.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalDKKCoinFraction() throws IllegalCoinException {
		//Arrange
		int coinValue = 10;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 0 min for 10 ore.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalDKKCoin() throws IllegalCoinException {
		//Arrange
		int coinValue = 17;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 0 min for 17 Dkr.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalNOKCoin() throws IllegalCoinException {
		//Arrange
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 0 min for 1 Nkr.", expectedParkingTime, ps.readDisplay());
	}
	
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalSEKCoin() throws IllegalCoinException {
		//Arrange
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.SEK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 0 min for 1 Skr.", expectedParkingTime, ps.readDisplay());
	}
	
	@After
	public void cleanUp() {
		ps.setReady();
	}

	
}
