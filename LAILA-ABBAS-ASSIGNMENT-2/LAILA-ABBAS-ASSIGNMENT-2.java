import java.util.Arrays;
import java.util.HashSet;

public class GetFruit {
	
	private static void getFruitsTCnSquare(int [] arrToSearch,int k)
	{
		System.out.println("Using Time Complexity n^2");
		System.out.print("To get " + k + " kilos of fruit : ");
		boolean empty = false; 
		//k represent number of kilos from this fruit
		if(arrToSearch == null)
			return;
		int found = 0; //so the maximum pairs found are 2 pairs
		for (int i = 0; i<arrToSearch.length; i++)
		{
			for (int j=i+1; j<arrToSearch.length; j++)
			{
				if((arrToSearch[i]+arrToSearch[j])== k)
				{
					System.out.print("( "+arrToSearch[i]+" , " + arrToSearch[j] + " ) ");
					found++;
					empty = true;
					if(found == 2)
						return;
					break;
				}
			}
		}
		if(empty == false)
			System.out.print("The existed ones more than the kilos required");
	}
	
	private static void getFruitsTCnLogn(int [] arrToSearch,int k)
	{
		System.out.println("Using Time Complexity nLogn");
		System.out.print("To get " + k + " kilos of fruit : ");
		boolean empty = false; 
		//k represent number of kilos from this fruit
		if(arrToSearch == null)
			return;
		int found = 0; //so the maximum pairs found are 2 pairs
		
		Arrays.sort(arrToSearch);
		int i = 0;
		int j = arrToSearch.length - 1;
		while (i<j)
		{
			// 1,2,4,5,7
			int nFound = k - arrToSearch[i];
			if(nFound == arrToSearch[j])
			{
				System.out.print("( "+arrToSearch[i]+" , " + arrToSearch[j] + " ) ");
				i++;
				j--;
				found++;
				if(found == 2)
					return;
			}
			else if (nFound < arrToSearch[j])
			{
				j--;
			}
			else
				i++;
		}
		
		if(empty == false)
			System.out.print("The existed ones more than the kilos required");
	}
	
	private static void getFruitsTCn(int [] arrToSearch,int k)
	{
		System.out.println("Using Time Complexity n^2");
		System.out.print("To get " + k + " kilos of fruit : ");
		boolean empty = false; 
		//k represent number of kilos from this fruit
		if(arrToSearch == null)
			return;
		int found = 0; //so the maximum pairs found are 2 pairs
		
		HashSet<Integer> insertionArray =new HashSet<Integer>();
		for(int i=0;i<arrToSearch.length;i++)
		{
			int numberToSeach = k - arrToSearch[i];
			if(insertionArray.contains(numberToSeach))
			{
				System.out.print("( "+numberToSeach+" , " + arrToSearch[i] + " ) ");
				found++;
				empty = true;
				if(found == 2)
					return;
			}
			if(! insertionArray.contains(arrToSearch[i]))
				insertionArray.add(arrToSearch[i]);
		}
		
		if(empty == false)
			System.out.print("The existed ones more than the kilos required");
	}
	
	public static void main (String[] args)
	{
		int [] arr = {4,5,2,1,7};
		int kilos = 9;
		getFruitsTCnSquare(arr, kilos);
		System.out.println("  ");
		getFruitsTCnLogn(arr, kilos);
		System.out.println("  ");
		getFruitsTCn(arr, kilos);
	}
	

}
