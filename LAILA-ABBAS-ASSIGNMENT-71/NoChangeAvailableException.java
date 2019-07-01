package vendingMachine;

public class NoChangeAvailableException extends Exception {
	public NoChangeAvailableException ()
	{
		String s = "There is no change Available";
		System.out.println(s);
	}
}
