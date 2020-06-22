
public abstract class OrderedList extends List {

	public OrderedList() {
		super("Ordered list");
	}
	
	public OrderedList(String listName) {
		super(listName);
	}
	
	//comnpare two object
	protected abstract int compare(Object obj1, Object obj2);
	
	//find the list node which contain the object newData
	public ListNode find (Object newData) {
		ListNode current = getFirst();
		while (current != null && compare(current.data, newData) < 0) {
			current = current.next;
		}
		if (current == null || compare(current.data, newData) == 0)
			return current;
		return null;
	}
	
	//insert newData into the list at appropriate position
	public boolean insert (Object newData) {
		if (firstNode == null) {
			firstNode = lastNode = new ListNode(newData, null);
			return true;
		}
		ListNode current = getFirst();
		ListNode prev = null;
		//find the appropriate position
		while (current != null && compare(current.data, newData) < 0) {
			prev = current;
			current = current.next;
		}
		ListNode newNode = new ListNode(newData, null);
		if (current != null) {
			if (compare(current.data, newData) > 0) {// if the data is not in the list already
				newNode.next = current;
				if (prev == null) // the data is smallest
					firstNode = newNode;
				else
					prev.next = newNode;
				return true;
			}
		} else {// the new data is biggest and not exists in the list
			prev.next = newNode;
			lastNode = newNode;
			return true;
		}
		return false;
	}
	
	//remove an object from the list
	public ListNode remove (Object remData) {
		ListNode current = getFirst();
		ListNode prev = null;
		//find the node (or use find() function)
		while (current != null && compare(current.data, remData) < 0) {
			prev = current;
			current = current.next;
		}
		//the object exists in the list
		if (current != null && compare(current.data, remData) == 0) {
			if (current == lastNode) // the node is last node
				lastNode = prev;
			if (prev == null) // the node is first node
				firstNode = current.next;
			else
				prev.next = current.next;
		}
		return current;
	}

	@Override
	public void insertAtFront(Object newData) {
		System.out.println("Error: insertAtFront can still be used while it should not");
	}

	@Override
	public void insertAtBack(Object newData) {
		System.out.println("Error: insertAtBack can still be used while it should not");
	}
	
	
}
