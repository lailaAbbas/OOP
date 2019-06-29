package lailaAbbasAssignment;

import java.util.ArrayList;

public class Checkout {
	//maintain vector of dessert items

	private ArrayList <DessertItem > dessertList;
	private int itemCounter;
	private int totalCost;
	private String printedCache;
	
	public Checkout() {
		dessertList = new ArrayList<DessertItem>();
		itemCounter = 0;
		totalCost = 0;
		printedCache = "\n"+"     "+ "M & M Dessert Shoppe"+ "\n";
		printedCache +="     "+ "--------------------"+ "\n"+"\n";
	}
	
	public int numberOfItems()
	{
		return(itemCounter);
	}
	
	public void enterItem(DessertItem item)
	{
		dessertList.add(item);
		itemCounter++;
		totalCost += item.getCost();
		printedCache += item.toString();
	}
	
	public void clear()
	{
		dessertList.clear();
		itemCounter = 0;
		totalCost = 0;
		printedCache = "\n"+"     "+ "M & M Dessert Shoppe"+ "\n";
		printedCache +="     "+ "--------------------"+ "\n"+"\n";
	}
	
	public int totalCost()
	{
		return totalCost;
	}
	
	public int totalTax()
	{
		/* Tax amounts should be rounded to the nearest cent.
		 *  For example, the calculating the tax on a food item with a cost of 199
		 *   cents with a tax rate of 2.0% should be 4 cents. 
		 */
		int tax = (int) Math.round(0.065 * totalCost);
		return(tax);
	}
	
	public String toString()
	{
		//total string length 35
		String finalPrintedCache = printedCache;
		finalPrintedCache += "\n" + "Tax";
		String tx = DessertShoppe.cents2dollarsAndCents(this.totalTax());
		for(int i =0; i< (30-"Tax".length()-tx.length());i++)
		{
			finalPrintedCache += " ";
		}
		finalPrintedCache += tx +"\n";
		
		finalPrintedCache += "Total Cost";
		tx = DessertShoppe.cents2dollarsAndCents(this.totalTax()+ this.totalCost());
		for(int i =0; i< (30-"Total Cost".length()-tx.length());i++)
		{
			finalPrintedCache += " ";
		}
		finalPrintedCache += tx +"\n";
		return(finalPrintedCache);
		
		
	}
}
