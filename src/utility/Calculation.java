package utility;

import modellayer.Coin;
import modellayer.Currency;
import modellayer.PPrice;

public class Calculation {
	
	public Calculation() {}
	
	public double getCoinValueInCent(Coin coin, PPrice currentPrice) {
		double centAmount = 0.0;
		double coinValue = coin.getAmount();
		
		if(coin.getCurrency() == Currency.ValidCurrency.DKK) {
			Currency.ValidCoinType coinType = coin.getCoinType();
			if(coinType == Currency.ValidCoinType.INTEGER) {
				centAmount = (coinValue * 100) / currentPrice.getExchangeEuroDkk();
			}else {
				centAmount = coinValue / currentPrice.getExchangeEuroDkk();
			}
		}else {
			if (coin.getCoinType() == Currency.ValidCoinType.INTEGER) {
				centAmount = coinValue * 100;
			}else {
				centAmount = coinValue;
			}	
		}
		return centAmount;
	}
}

