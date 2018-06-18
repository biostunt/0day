import java.util.LinkedList;

public class SeparateChainHashtable<Key extends Comparable<Key>,Value> {
    private int N;
    private int M;
    private RBT<Key,Value>[] st;
    public  SeparateChainHashtable(int M)
    {
        this.M=M;
        st=(RBT<Key,Value>[]) new RBT[M];
        for(int i=0;i<M;i++){
            st[i]=new RBT<Key,Value>();
        }
    }
    public SeparateChainHashtable(){
        this(997);
    }
    private int hash(Key key){
        return(key.hashCode()&0x7fffffff)%M;
    }
    public Value get(Key key){
        return st[hash(key)].get(key);
    }
    public void put(Key key,Value val){
        st[hash(key)].put(key,val);
    }
}
