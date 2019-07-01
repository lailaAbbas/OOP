package vendingMachine;

public class Item {
	

	private int itemPrice_;
	private int itemCountAvailable;
	private String itemName_;
	
	public Item(String name, int itemValue)
	{
		itemName_ = name + "(" + itemValue + ")";
		itemPrice_ = itemValue;
		itemCountAvailable = 0;
	}
	
	public String getItemName()
	{
		return itemName_;
	}
	public int getItemPrice()
	{
		return itemPrice_;
	}
	
	public int getItemCountAvailable()
	{
		return itemCountAvailable;
	}
	
	public void setItemCountAvailable(int itemCount)
	{
		if(itemCount >= 0)
			itemCountAvailable = itemCount;
	}



}
