package modellayer;

import controllayer.ControlPrice;
import controllayer.IllegalCoinException;
import utility.*;

/**
 * Inspired by the book: Flexible, Reliable Software
 * Henrik Bærbak Christensen: Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class PPayStation {
	
	// PayStation ident
	private int id;	
	// PayStaion model
	private String payStationModel;
	// Amount inserted in pay station
	private double amount = 0;
	private ControlPrice controlPrice;
	private Calculation calc;
	
	
	public PPayStation(int id, String payStationModel) {
		this.id = id;
		this.payStationModel = payStationModel;
		
		this.controlPrice = new ControlPrice();
		this.calc = new Calculation();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayStationModel() {
		return payStationModel;
	}

	public void setPayStationModel(String payStationModel) {
		this.payStationModel = payStationModel;
	}	
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void addAmount(Coin coin, PPrice currentPrice) {	
		this.amount += calc.getCoinValueInCent(coin, currentPrice);
	}
	
	public int getTimeBoughtInMinutes() {
		
		PPrice aPrice = controlPrice.getCurrentPrice();
		int timeBoughtInMinutes = 0;

		double timeBoughtInSeconds = this.amount * aPrice.getParkingPrice();
		timeBoughtInMinutes = (int) ((timeBoughtInSeconds + 59) / 60);

		return timeBoughtInMinutes;
	}
	
	public void validateCoin(Coin coin) throws IllegalCoinException {
		Validation.validateCoin(coin);	
	}
	
}
