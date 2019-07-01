package vendingMachine;

import java.util.ArrayList;

public abstract class Inventory {
	
	private ArrayList<Item> itemList = new ArrayList<>(6);
	
	public void displayInventory()
	{
		if(itemList.size() == 0)
			System.out.println("Nothing stored in the inventory");
		else
		{
			printLine("Item(price)", "Count");
			System.out.println();
			for(int i=0;i<itemList.size();i++)
			{
				printLine(itemList.get(i).getItemName(), ""+itemList.get(i).getItemCountAvailable());
			}
		}
	}
	
	public static void printLine(String start, String end)
	{
		int strSize = 25;
		System.out.print("\n"+start);
		for(int m = 0;m<(strSize - start.length()-end.length());m++)
			System.out.print(" ");
		System.out.print(end);
		
	}
	
	public void addItem(String itemName, int itemPrice)
	{
		if(itemPrice >= 0)
			itemList.add(new Item(itemName, itemPrice));
		else
			System.out.println("Item not added as price is not available");
	}
	
	public ArrayList<Item> getItemList()
	{
		return itemList;
	}
	
}
