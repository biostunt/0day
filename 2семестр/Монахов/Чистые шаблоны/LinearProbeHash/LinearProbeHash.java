
public class LinearProbeHash<Key,Value> {
    private int N, M=16;
    private Key[] keys;
    private Value[] vals;

    public LinearProbeHash(){
        keys=(Key[]) new Object[M];
        vals=(Value[]) new Object[M];
        N=0;
    }
    public LinearProbeHash(int cap){
        M=cap;
        keys=(Key[]) new Object[M];
        vals=(Value[]) new Object[M];
        N=0;
    }
    private int hash(Key key)
    {
        return(key.hashCode() &0x7fffffff) %M;
    }
    private  void resize(int cap){
        LinearProbeHash<Key,Value> temp= new LinearProbeHash<Key,Value>(cap);
        for(int i=0;i<M;i++){
            if(keys[i]!=null)
            {
                temp.put(keys[i],vals[i]);
            }
        }
        keys = temp.keys;
        vals=temp.vals;
        M=temp.M;
    }
    public void put(Key key,Value val){
        if (N>=M/2) resize(M*2);
        int i;
        for(i=hash(key);keys[i]!=null;i=(i+1)%M){
            if (keys[i].equals(key)){
                vals[i]=val;
                return;
            }
        }
        keys[i]=key;
        vals[i]=val;
        N++;
    }
    public Value get(Key key){
        for(int i=hash(key);keys[i]!=null;i=(i+1)%M){
            if (keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }
}
