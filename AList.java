//hemanta Parajuli

import java.util.Arrays;

public class AList<T> implements  ListInterface<T>{
	private T[] list;
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 1000;

	public AList() throws Exception {
		this(DEFAULT_CAPACITY);
	}
	
	public AList(int initialCapacity) throws Exception {
		integrityOK = false;
		// is capacity too small?
		if(initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else
			checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		integrityOK = true;
	}

	private void checkCapacity(int capacity) throws Exception {
		if(capacity > MAX_CAPACITY)
			throw new Exception("Attempt to create a list whos capacity exceeds the max.");
	}

	@Override
	public void add(T newEntry) {
		add(numberOfEntries + 1, newEntry);
	}

	@Override
	public void add(int newPosition, T newEntry) {
		try {
			checkIntegrity();
			if((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
				if(newPosition <= numberOfEntries)
					makeRoom(newPosition);
				list[newPosition] = newEntry;
				numberOfEntries++;
				ensureCapacity();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void ensureCapacity() throws Exception {
		int capacity = list.length - 1;
		if(numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity + 1);
		}
		
	}

	private void makeRoom(int newPosition) {
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		
		for(int index = lastIndex; index >= newIndex; index--) {
			list[index + 1] = list[index];
		}
	}

	private void checkIntegrity() throws Exception {
		if(!integrityOK)
			throw new Exception("AList object is corrupt.");
	}

	@Override
	public T remove(int givenPosition) {
		T itemRemoved = list[givenPosition];
		for(int i = givenPosition; i < numberOfEntries; i++)
		{
			list[i] = list[i + 1];
		}
		numberOfEntries--;
		return itemRemoved;
	}

	@Override
	public void clear() {
		for(int i = 1; i <= numberOfEntries; i++)
		{
			remove(i);
		}
		numberOfEntries = 0;

	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		T currentEntry = list[givenPosition];
		list[givenPosition] = newEntry;
		return currentEntry;
	}

	@Override
	public T getEntry(int givenPosition) {
		try 
		{
			checkIntegrity();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		T entry = list[givenPosition];
		return entry;
	}
   
	// method to convert elements to list
	@Override
	public T[] toArray() {
		try {
			checkIntegrity();
			T[] result = (T[]) new Object[numberOfEntries];
			for(int index = 0; index < numberOfEntries; index++)
				result[index] = list[index + 1];
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		for(int i = 1; i <= numberOfEntries; i++)
		{
			if(list[i].equals(anEntry))
			{
				found = true;
			}
		}
		return found;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}
	
    //constructor to the class “AList” that creates a list from a given array of objects
	@SuppressWarnings("unchecked")
	public AList(T[] givenArray)
	{
		int length = givenArray.length;
		list = (T[]) new Object[length];
		for (int index = 0; index < length;
				index++)
		list[index+1] = givenArray[index];
	}
	@SuppressWarnings("null")
	public int getPosition(T anObject)
	{
		for(int i = 1; i <= numberOfEntries; i++)
		{
			//Comparing the object with the object in the list.
			if(list[i].equals(anObject))
			{
				return i;
			}
		}
		return (Integer) null;
	}
}