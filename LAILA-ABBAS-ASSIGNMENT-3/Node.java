package arrayList_Laila_Abbas;

public class Node {
	private int [] data;
	private Node next;
	private int counter;
	private int customArrSize;
	public Node(int arrSize)
	{
		customArrSize = arrSize;
		data = new int [customArrSize];
		counter = 0;
		//when new array is inserted it will keep it's value just an initiation value to not take much garbage space
		next = null;
	}
	
	public void setData(int newData)
	{
		if(counter == customArrSize)
			return;
		data[counter] = newData;
		counter ++;
	}
	public int [] getDataArr()
	{
		return data;
	}
	public void setNext(Node newNext)
	{
		next = newNext;
	}
	public Node getNext()
	{
		return next;
	}
}
