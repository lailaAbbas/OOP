import java.util.Arrays;

public class findCommonNumbers {

private static int lenArr(int[] arr)
{
	int lenArray;
	if(arr != null)
		lenArray = arr.length;
	else
		lenArray = 0 ;
	return(lenArray);
}
	
private static void findTimeComplexityNlogn (int []arrToSearch)
{
	Arrays.sort(arrToSearch); 
	int lenArray = lenArr(arrToSearch);
	int i = 0;
	boolean printAny = false;
	System.out.println("");
	
	while(i<lenArray)
	{
		boolean available = true;
		int j = i+1;
		while(available && j<lenArray)
		{
			// to find if the numbers after it resembles it or not
			if(arrToSearch[i] == arrToSearch[j])
			{
				j++;
				System.out.print(arrToSearch[i] + "  " );
				printAny = true;
			}
			else
			{
				available = false;
			}
		}
		i = j;
	}
	if(printAny == false)
		System.out.print("not found");
}

private static void findTimeComplexityNsquare (int []arrToSearch)
{
	//to find repeated roots by algorithm of n*n time complexity 
	System.out.println("");
	//consider they are repeated two times only
	int lenArray = lenArr(arrToSearch);
	/*Make new array to find repeated ones */
	int [] arrToCompare = new int [lenArray];
	if(lenArray!= 0)
		arrToCompare[0]= arrToSearch[0];
	int count = 1; //counter to fill  arrToCompare
	
	boolean printAny = false;
	
	for(int i=1; i<lenArray;i++)
	{
		boolean found = false;
		for(int j=0; j< count;j++)
		{
			if (arrToSearch[i] == arrToCompare[j])
			{
				System.out.print(arrToSearch[i] + "  ");
				found = true;
				printAny = true;
			}
		}
		if (found == false)
		{
			arrToCompare[count] = arrToSearch[i];
			count ++;
		}
		
	}
	if(printAny == false)
		System.out.print("not found");
}
	
public static void main (String[] args)
{
	int [] arr = {2 , 8 ,6 ,7 ,3 ,2 ,1 ,6,9,3};
	
	//find common numbers with time complexity nlogn
	System.out.println("Repeated Numbers by algorithm of nlogn time complexity :");
	findTimeComplexityNlogn(arr);
	System.out.println("");
	
	//find common numbers with time complexity n^2
	System.out.println("");
	System.out.println("Repeated Numbers by algorithm of n^2 time complexity :");
	findTimeComplexityNsquare(arr);
	
}

}
