package vendingMachine;

import java.util.ArrayList;

public class AmericanCoins {
	private ArrayList<Coin> coinList = new ArrayList<>(7);
	
	public AmericanCoins()
	{
		coinList.add(new Coin("penny",1));
		coinList.add(new Coin("nickel",5));
		coinList.add(new Coin("dime",10));
		coinList.add(new Coin("quarter",25));
		coinList.add(new Coin("half",50));
		coinList.add(new Coin("oneDollar",100));
		coinList.add(new Coin("twoDollars",200));

	}
	
	public ArrayList<Coin> getCoinList()
	{
		return coinList;
	}

}
