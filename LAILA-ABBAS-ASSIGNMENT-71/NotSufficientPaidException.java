package vendingMachine;

public class NotSufficientPaidException extends Exception {
	public NotSufficientPaidException()
	{
		System.out.println("The paid money is not sufficient");
	}

}
