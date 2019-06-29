package arrayList_Laila_Abbas;

public class LinkedList {
	
	private Node head;
	
	public LinkedList ()
	{
		head =null;
	}
	
	public void insertNewArr(int newArrSize)
	{
		Node newNode = new Node(newArrSize);
		if(head == null)
			head = newNode;
		else
		{
			Node search = head;
			while(search.getNext()!= null) {
				search = search.getNext();
			}
			search.setNext(newNode);
		}
	}
	
	public Node getLast()
	{
		if (head == null)
			throw new IllegalArgumentException("Empty Linked List");
		Node search = head;
		while(search.getNext()!= null) {
			search = search.getNext();
		}
		return search;
	}
	
	public boolean findData(int toFindData, int arraySize)
	{
		if (head == null)
			return false;
		else
		{
			Node search = head;
			while(search != null)
			{
				for(int i=0;i< arraySize;i++) {
				if(search.getDataArr()[i]== toFindData)
					return true;
				}
				search = search.getNext();
			}
			return false;
		}
	}

}
