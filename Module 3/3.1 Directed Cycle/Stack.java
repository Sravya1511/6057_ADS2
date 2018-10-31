/**
 * class list.
 *
 * @param      <Item>  The item
 */
public class Stack<Item> {
    /**
     * size of the stack.
     */
    private int N;
    /**
     * Node type.
     */
    private Node first;

    /**
     * Class for node.
     */
    private class Node {
        /**
         * item of type item.
         */
        private Item item;
        /**
         * Node next.
         */
        private Node next;
    }

    /**
     * Constructs the object.
     */
    public Stack() {
        first = null;
        N = 0;
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * size of the stack.
     *
     * @return     { int }
     */
    public int size() {
        return N;
    }
    /**
     * pushes element.
     *
     * @param      item  The item
     */

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
}

