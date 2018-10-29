import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
	/**
	 *  number of elements in bag.
	 */
    private int N;
    /**
     * beginning of bag
     */
    private Node first;

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Constructs the object.
     */

    public Bag() {
        first = null;
        N = 0;
    }

    /**
     * Determines if empty.
     * The time complexity is O(1).
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * returns size of the bag.
     * The time complexity is O(1).
     *
     *
     * @return     { int }
     */
    public int size() {
        return N;
    }

    /**
     * adds element into bag.
     * The time complexity is O(1).
     *
     *
     * @param      item  The item
     */
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    /**
     * determines if there is vertex or not.
     * The time complexity is O(N).
     *
     *
     * @param      item  The item
     *
     * @return     { true or false }
     */

    public boolean contains(Item item) {
    	Node n = first;
    	while (n!= null) {
    		if (n.item == item) {
    			return true;
    		}
    		n = n.next;
    	}
    	return false;
    }


   /**
     * Return an iterator that iterates over the items in the bag.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext()  {
        	return current != null;
        }
        /**
         * removes.
         */
        public void remove() {
        	throw new UnsupportedOperationException();
        }
        /**
         * gives next node.
         *
         * @return     { item }
         */

        public Item next() {
            if (!hasNext()) {
            	 throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
