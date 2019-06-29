package arrayList_Laila_Abbas;

public class MyArrayList {
	private int arrayCapacity;
	//create new linked list each node has array of size array Capacity
	private LinkedList myLinkedList = new LinkedList();
	private int counter = 0;
	
	public MyArrayList()
	{
		arrayCapacity = 32;
		myLinkedList.insertNewArr(arrayCapacity);
	}
	public MyArrayList(int customizedArrCapacity)
	{
		arrayCapacity = customizedArrCapacity;
		myLinkedList.insertNewArr(arrayCapacity);
	}
	
	public void add(int newData)
	{
		if (counter == arrayCapacity)
		{
			counter = 0;
			myLinkedList.insertNewArr(arrayCapacity);
		}
		Node myNode = myLinkedList.getLast();
		myNode.setData(newData);
		counter++;
	}
	
	public boolean contains(int toFindData)
	{
		return(myLinkedList.findData(toFindData, arrayCapacity));
			
	}
}
