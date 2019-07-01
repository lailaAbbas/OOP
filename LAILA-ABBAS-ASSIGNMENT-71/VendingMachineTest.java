package vendingMachine;

import java.util.Scanner;

public class VendingMachineTest {

	public static void main(String[] args) {
		VendingMachine trial = new VendingMachine();
		System.out.println("Hello");
		System.out.println("At choosing between Y/N");
		System.out.println("for Yes enter 1 and for No enter 0");
		boolean complete = true;
		int num;
		while(complete)
		{
		trial.takeOrder();
		System.out.println("\nDo you want to complete Y/N ?");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		if(num != 1)
		{
			complete = false;
			if(num != 0)
				System.out.println("Invalid input and process terminated");
		}
		}
	}

}
