package lailaAbbasAssignment;

public class Sundae extends IceCream {
	private String SundaeName;
	private int toppinPrice;
	
	public Sundae (String iceName, int icePrice ,String toppingName , int toppingPrice)
	{	
		super(iceName,icePrice);
		SundaeName = toppingName + " Sundae with \n" ;
		toppinPrice = toppingPrice;
	}
	
	public int getCost()
	{
		return(toppinPrice+super.getCost());
	}
	
	public String toString()
	{
		String sundaeName =  SundaeName;
		sundaeName +=  this.name;
		String price = DessertShoppe.cents2dollarsAndCents(this.getCost());
		for(int i =0; i< (30-this.name.length()-price.length());i++)
		{
			sundaeName += " ";
		}
		sundaeName += price + "\n";
		return sundaeName;
	}

}
