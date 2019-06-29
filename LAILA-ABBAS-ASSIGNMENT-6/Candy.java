package lailaAbbasAssignment;

public class Candy extends DessertItem {
	//weight in lbs
	private double candyWeight;
	//price per pound
	private int candyPrice;
	public Candy(String canName,double canWeight,int canPrice)
	{
		this.name = canName;
		candyWeight = canWeight;
		candyPrice = canPrice;		
	}
	
	public int getCost() {
		return (int) Math.round(((double)candyPrice*candyWeight));
	}
	
	public String toString()
	{
		String candyName =  candyWeight + " lbs. @ "+ DessertShoppe.cents2dollarsAndCents(candyPrice)+" /lb.\n";
		candyName +=  this.name;
		String price = DessertShoppe.cents2dollarsAndCents(this.getCost());
		for(int i =0; i< (30-this.name.length()-price.length());i++)
		{
			candyName += " ";
		}
		candyName += price + "\n";
		return candyName;
	}

}
