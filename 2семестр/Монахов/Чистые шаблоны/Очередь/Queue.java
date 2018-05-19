
public class Queue {
	private int[] queue;
    private int mSize;
    private int first;  
    private int front;
    private int rear;
	
    public Queue(int mSize) {
        this.mSize = mSize;
        queue = new int[mSize];
        rear = -1;
        front = 0;
        first = 0;
    }
    public void addElement(int elem) {
        if (rear == mSize - 1) {  
            rear = -1;
        }
     
        queue[++rear] = elem; 
        first++;  
    }
    public int deleteElement() {
    	int temp = queue[front++]; 
    	 
    	    if (front == mSize) {
    	        front = 0;
    	    }
    	    first--; 
    	    return temp;
    	 
    	    }   
    public boolean isEmpty() {
        return (first == 0);
    }
     
}
