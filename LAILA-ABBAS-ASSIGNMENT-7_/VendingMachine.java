package vendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine extends Inventory{
	
	private AmericanCoins myCoins;
	//variables to save entered coins and taken items by user
	private AmericanCoins enteredCoins;
	private int[] itemsTaken;
	public static Scanner input = new Scanner(System.in);
	
	public VendingMachine()
	{
		//add inventory items
		this.addItem("CANDY",10);
		this.addItem("SNACK",50);
		this.addItem("NUTS",90);
		this.addItem("Coke",25);
		this.addItem("Pepsi",35);
		this.addItem("Soda",45);
		
		//add 20 count for each coin type
		myCoins = new AmericanCoins();
		for(int i=0; i < myCoins.getCoinList().size();i++)
			myCoins.getCoinList().get(i).setCoinCountAvailable(20);

		//add100 count for each item type
		for(int i=0; i < this.getItemList().size();i++)
			this.getItemList().get(i).setItemCountAvailable(100);
		
		enteredCoins = new AmericanCoins();//the coins entered by user later
		itemsTaken = new int[this.getItemList().size()];
	}
	
	public void takeOrder()
	{
		//refreshing variables and check system working properly
		//checkMachineErrors();
		refreshVariables();
		
		//to check inventory is not empty
		if(this.getItemList().size()==0)
		{
			System.out.println("Empty Inventory");
			System.out.println("Can't proceed the request");
		}
		
		//first ask if wanted to display inventory and take action
		System.out.println("Do you want to display the inventory ? Y/N");
		int switchNum = input.nextInt();
		if(switchNum == 1)
			displayInventory();
		else if(switchNum != 0)
		{
			System.out.println("Not Available Response..Order Cancelled");
			return;
		}
		
		//take user order
		System.out.print("\nFor each item enter the number wanted");
		for(int i=0;i < this.getItemList().size();i++)
		{
			System.out.print("\n" + this.getItemList().get(i).getItemName() + " : ");
			int countItem = input.nextInt();
			int prevCount = this.getItemList().get(i).getItemCountAvailable();
			if((prevCount - countItem) >= 0)
			{
				itemsTaken[i] = countItem;
				this.getItemList().get(i).setItemCountAvailable(prevCount - countItem);
			}
			else
			{
				System.out.println("Request is cancelled");
				try {
				throw new SoldOutException();}
				catch(SoldOutException e)
				{
					returnItems();
				}
				return;
			}
		}
		
		this.takeMoney();
			
	}
	
	private void takeMoney()
	{
		//print Bill
		Bill b = new Bill(this.getItemList(),itemsTaken);
		b.printBill();
		int totalPrice = b.getBillPrice();
		
		//first take money from user and check if it's enough
		System.out.println();
		System.out.println("Enter your amount of money for each coin ");
		int rcvdSum = 0;
		int prevCoinCount;
		for(int i=0;i < myCoins.getCoinList().size();i++)
		{
			System.out.println(myCoins.getCoinList().get(i).getCoinName() + " : ");
			int num = input.nextInt();
			enteredCoins.getCoinList().get(i).setCoinCountAvailable(num);
			prevCoinCount = myCoins.getCoinList().get(i).getCoinCountAvailable();
			myCoins.getCoinList().get(i).setCoinCountAvailable(prevCoinCount + num);
			rcvdSum  += (num * myCoins.getCoinList().get(i).getCoinValue());
		}
		if(rcvdSum < totalPrice)
		{
			try {
			throw new NotSufficientPaidException();}
			catch(NotSufficientPaidException e)
			{
				returnItems();
				takeRefund();
				return;
			}
			
		}
		
		//Return the change to user
		returnChange(rcvdSum - totalPrice);
		
	}
	
	private void returnChange(int returnedMoney)
	{
		System.out.println("Here is the change");
		int expectedCount;
		int [] ifProcessCancelled = new int [myCoins.getCoinList().size()];
		int prevCount;
		
		for(int i= myCoins.getCoinList().size()-1;i>(-1);i--)
		{
			if(returnedMoney == 0)
				return;
			
			expectedCount = returnedMoney / myCoins.getCoinList().get(i).getCoinValue();
			prevCount = myCoins.getCoinList().get(i).getCoinCountAvailable();
			if(expectedCount <= prevCount)
				myCoins.getCoinList().get(i).setCoinCountAvailable(prevCount - expectedCount);
			else
			{
				myCoins.getCoinList().get(i).setCoinCountAvailable(0);
				expectedCount = prevCount;
			}
			
			ifProcessCancelled[i] = expectedCount;
			returnedMoney -= (expectedCount * myCoins.getCoinList().get(i).getCoinValue());
			printLine(myCoins.getCoinList().get(i).getCoinName(),""+expectedCount);
		}
		
		if(returnedMoney != 0)
		{
			try {
				throw new NoChangeAvailableException();
			}
			catch(NoChangeAvailableException e) {
				int prevCoin;
				for(int i =0;i< myCoins.getCoinList().size();i++)
				{
					prevCoin = myCoins.getCoinList().get(i).getCoinCountAvailable();
					myCoins.getCoinList().get(i).setCoinCountAvailable(prevCoin + ifProcessCancelled[i]);
				}
				takeRefund();
				returnItems();
			}
		}
	}
	
	private void returnItems()
	{
		if(itemsTaken == null)
			return;
		else
		{
			for(int i=0; i< itemsTaken.length;i++)
			{
				int prevCount = this.getItemList().get(i).getItemCountAvailable();
				this.getItemList().get(i).setItemCountAvailable(prevCount + itemsTaken[i]);
			}
		}
	}
	private void enterMoney()
	{
		System.out.println("For each coin type appeared enter your input count of it");
		for(int i =0; i< enteredCoins.getCoinList().size();i++)
		{
			System.out.print("\n" + enteredCoins.getCoinList().get(i).getCoinName()+ " : ");
			enteredCoins.getCoinList().get(i).setCoinCountAvailable(input.nextInt()); 
			
		}
	}
	
	private void takeRefund()
	{
		System.out.println("Here is your money");
		for(int i =0; i< enteredCoins.getCoinList().size();i++)
		{
			int num = enteredCoins.getCoinList().get(i).getCoinCountAvailable();
			int prevCoinCount;
			if(num != 0)
			{
				printLine(enteredCoins.getCoinList().get(i).getCoinName(), ""+num);
				prevCoinCount = myCoins.getCoinList().get(i).getCoinCountAvailable();
				myCoins.getCoinList().get(i).setCoinCountAvailable(prevCoinCount - num);
				num = 0;
			}
		}
	}
	
	private void refreshVariables()
	{
		for(int i=0;i< (enteredCoins.getCoinList().size());i++)
		{
			enteredCoins.getCoinList().get(i).setCoinCountAvailable(0);
		}
		for(int i=0;i< (itemsTaken.length);i++)
		{
			itemsTaken[i] = 0;
		}
	}
	
	private void checkMachineErrors()
	{
		if(itemsTaken == null)
			return;
		if((this.getItemList().size() != itemsTaken.length) || (myCoins.getCoinList().size()!= enteredCoins.getCoinList().size()))
		{
			throw new IllegalArgumentException("Machine error");			
		}
	}
}
