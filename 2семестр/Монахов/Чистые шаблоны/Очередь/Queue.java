import java.util.Iterator;
public class Queue <Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;
    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public int getSize() {return size;}
    public void enq(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        size++;
    }
    public Item deq()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        size--;
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new QueueIterator();

    }
    private class QueueIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }
}