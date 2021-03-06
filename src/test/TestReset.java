package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestReset {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Verify that the pay station is cleared and display shows 0 after a buy scenario
	 */
	@Test
	public void shouldClearAfterBuy() throws IllegalCoinException, Exception {
		//Arrange
		int coinValue = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		ps.buy();
		//Assert
		assertEquals("After buy the display should reset to 0", 0, ps.readDisplay());
	}

	/**
	 * Verify that cancel() clears the pay station
	 */
	@Test
	public void shouldClearAfterCancel() throws IllegalCoinException {
		//Arrange
		int coinValue = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		ps.cancel();
		//Assert
		assertEquals("After cancel the display should reset to 0", 0, ps.readDisplay());
	}
	
	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}	
	
}
