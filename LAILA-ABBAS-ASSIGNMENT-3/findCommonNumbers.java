package arrayList_Laila_Abbas;

import java.util.ArrayList;

public class findCommonNumbers {
	private static void findCommonArrayList(int [] arr1,int []arr2)
	{
		if(arr1 == null || arr2 == null)
			return;
		ArrayList<Integer> addPrevious = new ArrayList<Integer>();
		for(int i=0; i< arr1.length;i++)
			addPrevious.add(arr1[i]);
		for(int i=0; i< arr2.length;i++)
		{
			if(addPrevious.contains(arr2[i]))
				System.out.println(arr2[i]);
				System.out.print("");
		}
	}
	
	private static void findMyCommonArrayList(int [] arr1,int []arr2)
	{
		if(arr1 == null || arr2 == null)
			return;
		MyArrayList addPrevious = new MyArrayList(4);
		for(int i=0; i< arr1.length;i++)
			addPrevious.add(arr1[i]);
		for(int i=0; i< arr2.length;i++)
		{
			if(addPrevious.contains(arr2[i]))
				System.out.println(arr2[i]);
		}
		
	}
	public static void main(String[] args) {
		int[] user1 = {5,10,30,50,70,500,22};
		int[] user2 = {500,1,5,70,20,6,100,30,32,10};
		System.out.println("Common numbers between two arrays using java implemented arrayList");
		findCommonArrayList(user1, user2);//find common numbers using java implemented ArrayList
		System.out.println("Common numbers between two arrays using my implemented arrayList");
		findMyCommonArrayList(user1, user2);//find common numbers using my implemented ArrayList
	
	}

}
