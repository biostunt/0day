public class Queue {
    private int[] arr;
    private int top = 0;
    private int now = 0;
    private int size;
    public Queue(int size){
        this.size = size;
        this.arr = new int[this.size];
    }
    public boolean isEmpty(){
        if(this.now == this.top) return true;
        else return false;
    }
    public void addElement(int e){

        this.arr[this.top] = e;
        this.top++;
    }
    public int deleteElement(){
        int temp = this.arr[this.now];
        this.now++;
        return temp;
    }
}
