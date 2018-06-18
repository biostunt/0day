

public class Stack<T>{
    protected T[] Container = (T[]) new Object[1];
    private int top = 0;
    public Stack(){}

    public void add(T e){
        this.Container[this.top] = e;
        this.top++;
        if(this.top == this.Container.length) appendSize();
    }

    private void appendSize() {
        T[] temp = (T[]) new Object[this.Container.length];
        System.arraycopy(this.Container, 0, temp, 0, this.Container.length - 1);
        this.Container = (T[]) new Object[this.Container.length + this.Container.length / 2 + 1];
        System.arraycopy(temp, 0, this.Container, 0, temp.length - 1);
    }

    public T delete(){
        T temp = this.Container[this.top];
        this.top--;
        if(this.top > 1) reduceSize();
        return temp;
    }

    private void reduceSize(){
        T[] temp = (T[]) new Object[this.Container.length];
        System.arraycopy(this.Container, 0, temp, 0, this.Container.length - 2);
        this.Container = (T[]) new Object[this.Container.length - 1];
        System.arraycopy(temp, 0, this.Container, 0, temp.length - 1);
    }

    public boolean isEmpty(){
        return this.top==0 ? true:false;
    }
}