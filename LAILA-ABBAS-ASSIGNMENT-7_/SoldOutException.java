package vendingMachine;

public class SoldOutException extends Exception {
	
	public SoldOutException()
	{
		System.out.println("Some of the items are sold out");
	}
}
