
public class Llist<T> implements ListInterface<T> {
    
	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;
	public Llist()
	{
	initializeDataFields();
	} // end default constructor
	
	private void initializeDataFields()
	{
	firstNode = null;
	numberOfEntries = 0;
	} // end initializeDataFields
	
	
	
	@Override
	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if (isEmpty())
		firstNode = newNode;
		else // Add to end of nonempty list
		{
		Node lastNode = getNodeAt(numberOfEntries);
		lastNode.setNextNode(newNode); // Make last node reference new node
		} // end if
		numberOfEntries++;

	}

	private Node getNodeAt(int givenPosition) {
		
		Node currentNode = firstNode;
		
		for (int counter = 1; counter < givenPosition; counter++)
		currentNode = currentNode.getNextNode(counter);
		
		return currentNode;
	}

	@Override
	public void add(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
		{
		Node newNode = new Node(newEntry);
		if (givenPosition == 1) // Case 1
		{
		newNode.setNextNode(firstNode);
		firstNode = newNode;
		}
		else // Case 2: list is not empty
		{ // and givenPosition > 1
		Node nodeBefore = getNodeAt(givenPosition - 1);
		Node nodeAfter = nodeBefore.getNext();
		newNode.setNextNode(nodeAfter);
		nodeBefore.setNextNode(newNode);
		} // end if
		numberOfEntries++;
		}
		else
		throw new IndexOutOfBoundsException(
		"Illegal position given to add operation.");
	}

	@Override
	public T remove(int givenPosition) {
		T result = null; // Return value
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
		// Assertion: !isEmpty()
		if (givenPosition == 1) // Case 1: Remove first entry
		{
		result = firstNode.getData(); // Save entry to be removed
		firstNode = firstNode.getNextNode(); // Remove entry
		}
		else // Case 2: Not first entry
		{
		Node nodeBefore = getNodeAt(givenPosition - 1);
		Node nodeToRemove = nodeBefore.getNextNode();
		result = nodeToRemove.getData(); // Save entry to be removed
		Node nodeAfter = nodeToRemove.getNextNode();
		nodeBefore.setNextNode(nodeAfter); // Remove entry
		} // end if
		numberOfEntries--; // Update count
		return result; // Return removed entry
		}
		else
		throw new IndexOutOfBoundsException(
		"Illegal position given to remove operation.");
	}

	@Override
	public void clear() {
		initializeDataFields();

	}

	@Override
	public T replace(int givenPosititon, T newEntry) {
		if ((givenPosititon >= 1) && (givenPosititon <= numberOfEntries))
		{
		// Assertion: !isEmpty()
		Node desiredNode = getNodeAt(givenPosititon);
		T originalEntry = desiredNode.getData();
		desiredNode.setData(newEntry);
		return originalEntry;
		}
		else
		throw new IndexOutOfBoundsException(
		"Illegal position given to replace operation.");
	}

	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
		// Assertion: !isEmpty()
		return getNodeAt(givenPosition).getData();
		}
		else
		throw new IndexOutOfBoundsException(
		"Illegal position given to getEntry operation.");
		} // end getEntry
	

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null))
		{
		if (anEntry.equals(currentNode.getData()))
		found = true;
		else
		currentNode = currentNode.getNext();
		} // end while
		return found;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if (numberOfEntries == 0) // Or getLength() == 0
		{
		// Assertion: firstNode == null
		result = true;
		}
		else
		{
		// Assertion: firstNode != null
		result = false;
		} // end if
		return result;	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

}
