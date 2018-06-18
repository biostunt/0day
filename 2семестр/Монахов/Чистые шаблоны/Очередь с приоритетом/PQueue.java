public class PQueue <Key extends  Comparable<Key>> {
    private Key[] pq;
    private int N;
    private boolean isMaxPQ=false;
    public PQueue(int size,boolean isMax)
    {
        pq=(Key[]) new Comparable[size+1];
        isMaxPQ=isMax;
    }
    public boolean isEmpety()
    {return N==0;}
    public int size()
    {return N;}
    private boolean less(int i,int j)
    {
        if(!isMaxPQ)
            return(pq[i].compareTo(pq[j])<0);
        else
            return (pq[i].compareTo(pq[j])>0);
    }
    private void exch(int i,int j){
        Key t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }
    private void sink(int k){
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(j,j+1))j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }
    private void swim(int k){
        while(k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    public void insert(Key v){
        pq[++N]=v;
        swim(N);
    }
    public Key delete(){
        Key tmp=pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return tmp;
    }
}
