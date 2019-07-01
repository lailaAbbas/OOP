package vendingMachine;

import java.util.ArrayList;

public class Coin {
	private int coinVal;
	private int countAvailable;
	private String coinName;
	
	public Coin(String name, int coinValue)
	{
		coinName = name;
		coinVal = coinValue;
		countAvailable = 0;
	}
		
	public String getCoinName()
	{
		return coinName;
	}
	public int getCoinValue()
	{
		return coinVal;
	}
	
	public int getCoinCountAvailable()
	{
		return countAvailable;
	}
	
	public void setCoinCountAvailable(int coinCount)
	{
		if(coinCount >= 0)
			countAvailable = coinCount;
	}

}
