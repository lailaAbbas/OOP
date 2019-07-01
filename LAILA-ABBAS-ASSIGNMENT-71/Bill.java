package vendingMachine;

import java.util.ArrayList;

public class Bill {
	
	ArrayList<Item> itemsList;
	int [] countitemsTaken;
	int totalPrice;
	
	public Bill(ArrayList<Item> itemList,int [] countTaken)
	{
		itemsList = itemList;
		countitemsTaken = countTaken;
		totalPrice = 0;
	}
	
	public int getBillPrice()
	{
		totalPrice = 0;
		if(itemsList == null)
			return 0;
		else
		{
			for(int i=0; i<itemsList.size();i++)
			{
				totalPrice += (itemsList.get(i).getItemPrice()*countitemsTaken[i]);
			}
			return totalPrice;
		}
	}
	
	public void printBill()
	{
		System.out.println("          Bill");
		Inventory.printLine("Item type * count", "Price");
		System.out.println();
		for(int i=0;i< itemsList.size();i++)
		{
			String s1 = itemsList.get(i).getItemName() + " * " + countitemsTaken[i];
			String s2 = "" + (itemsList.get(i).getItemPrice()*countitemsTaken[i]);
			Inventory.printLine(s1 , s2);
		}
		Inventory.printLine("Total Cost", ""+this.getBillPrice());
	}

}
