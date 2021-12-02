//hemanta Parajuli
public interface ListInterface<T> {
	/**
	 * Adds a new entry to the end of the list.
	 * @param newEntry
	 */
	public void add(T newEntry);
	
	/**
	 * Adds a new entry at a specific position in the lsit
	 * @param newPosition
	 * @param newEntry
	 */
	public void add(int newPosition, T newEntry);
	
	/**
	 * Removes an entry at a given position from the list.
	 * @param givenPosition
	 * @return
	 */
	public T remove(int givenPosition);
	
	/**
	 * Removes all the entry from the list.
	 */
	public void clear();
	
	/**
	 * Replace the new entry in the given position in the list.
	 * @param givenPosititon
	 * @param newEntry
	 * @return the original entry that was replaced.
	 */
	public T replace(int givenPosititon, T newEntry);
	
	/**
	 * Retrieves the entry at a given position in the list.
	 * @param GivePosition
	 * @return
	 */
	public T getEntry(int givenPosition);
	
	/**
	 * Retrieves all entries in this list.
	 * @return a newly allocated array of all entry in the list.
	 */
	public T[] toArray();
	
	/**
	 * Checks whether this list contains a given entry.
	 * @param anEntry
	 * @return true if it contains the entry else returns false.
	 */
	public boolean contains(T anEntry);
	
	/**
	 * Check whether the list is empty or not.
	 * @return true if the list is empty else returns false.
	 */
	public boolean isEmpty();
	
	/**
	 * gets the length of the list
	 * @return number of entries
	 */
	public int getLength();
}
