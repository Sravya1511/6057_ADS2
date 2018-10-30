import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */

class Bag<Item> implements Iterable<Item> {
    /**
     *  number of elements in bag.
     */
    private int num;
    /**
     * beginning of bag.
     */
    private Node first;

    /**
     * Class for node.
     */

    private class Node {
        /**
         * item of type node.
         */
        private Item item;
        /**
         * Node of type node.
         */
        private Node next;
    }

    /**
     * Constructs the object.
     */

    public Bag() {
        first = null;
        num = 0;
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
        return num;
    }

    /**
     * adds element into bag.
     * The time complexity is O(1).
     *
     *
     * @param      item  The item
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        num++;
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

    public boolean contains(final Item item) {
        Node n = first;
        while (n != null) {
            if (n.item == item) {
                return true;
            }
            n = n.next;
        }
        return false;
    }


    /**
     * Return an iterator that iterates over the items in the bag.
     *
     *
     * @return     { iterator }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */

    private class ListIterator implements Iterator<Item> {
        /**
         * Node.
         */
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



/**
 * Class for graph class.
 */

class GraphClass {
    /**
     * number of vertices.
     */
    private int vertex;
    /**
     * number of edges.
     */
    private int edge;
    /**
     * adj array of bag class type.
     */
    Bag<Integer>[] adj;

    /**
     * Gets the e.
     * The time complexity is O(1).
     *
     * @return     The e of int type.
     */

    public int getedge() {
        return edge;
    }
    /**
     * Constructs the object.
     * The time complexity is O(N).
     *
     *
     * @param      vertex1     { number of vertices }
     */

    GraphClass(final int vertex1) {
        this.vertex = vertex1;
        adj = (Bag<Integer>[]) new Bag[vertex1];
        for (int v = 0; v < vertex1; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * number of integers.
     * The time complexity is O(1).
     *
     *
     * @return     { int }
     */

    public int vertex() {
        return vertex;
    }

    /**
     * number of vertices.
     * The time complexity is O(1).
     *
     *
     * @return     { int }
     */

    public int edge() {
        return edge;
    }
    /**
     * Adds an edge.
     * The time complexity is O(N).
     *
     *
     * @param      v     { vertex }
     * @param      w     { edge }
     */

    public void addEdge(final int v, final int w) {
        if (v == w) {
            return;
        }
        if (!hasedgedge(v, w)) {
            edge++;
        }

        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * determines if vertices are connected or not.
     * The time complexity is O(N).
     *
     *
     * @param      v     { vertex. }
     * @param      w     { edge }
     *
     * @return     True if has edge, False otherwise.
     */

    public boolean hasedgedge(final int v, final int w) {
        if (adj[v].contains(w)) {
            return true;
        }
        return false;

    }
    /**
     * prints the list of cities connected to other cities.
     * The time complexity is O(N^2).
     *
     *
     * @param      cities  The cities
     *
     * @return     { description_of_the_return_value }
     */

    public String printList(final String[] cities) {
        StringBuilder s = new StringBuilder();
            for (int v = 0; v < vertex; v++) {
            s.append(cities[v] + ": ");
            for (int w : adj[v]) {
                s.append(cities[w] + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}