package lailaAbbasAssignment;

public class IceCream extends DessertItem {
	
	private int icePrice;
	
	public IceCream(String iceName, int iceCreamPrice)
	{
		this.name = iceName;
		icePrice = iceCreamPrice;
	}
	
	public int getCost() {
		
		return icePrice;
	}
	
	public String toString()
	{
		String iceName;
		iceName =  this.name;
		String price = DessertShoppe.cents2dollarsAndCents(this.getCost());
		for(int i =0; i< (30-this.name.length()-price.length());i++)
		{
			iceName += " ";
		}
		iceName += price + "\n";
		return iceName;
	}

}
