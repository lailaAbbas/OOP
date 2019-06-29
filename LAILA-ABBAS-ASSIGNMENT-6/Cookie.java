package lailaAbbasAssignment;

public class Cookie extends DessertItem {
	
	private int cookieNum;
	private int cookiePrice; //price per dozen
	
	public Cookie(String cookieName,int cookieNumber,int cookiePricePerDozen)
	{
		this.name = cookieName;
		cookieNum = cookieNumber;
		cookiePrice = cookiePricePerDozen;
	}
	
	public int getCost() {
		double price = cookiePrice * (cookieNum* 1.0 / 12);
		return (int) (Math.round(price));
	}
	
	public String toString()
	{
		/*4 @ 3.99 /dz.
Oatmeal Raisin Cookies     1.33*/
		String cookieName = cookieNum + " @ "+DessertShoppe.cents2dollarsAndCents(cookiePrice) + " /dz. \n";
		cookieName +=  this.name;
		String price = DessertShoppe.cents2dollarsAndCents(this.getCost());
		for(int i =0; i< (30-this.name.length()-price.length());i++)
		{
			cookieName += " ";
		}
		cookieName += price + "\n";
		return cookieName;
	}

}
