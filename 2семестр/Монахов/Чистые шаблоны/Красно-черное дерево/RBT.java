public class RBT <Key extends Comparable<Key>, Value> {
    private static boolean RED=true;
    private static boolean BLACK=false;
    private class Node
    {
        Key key;
        Value val;
        Node left,right;
        int N;
        boolean color;
        Node(Key key,Value val,int N,boolean color)
        {
            this.key=key;
            this.val=val;
            this.N=N;
            this.color=color;
        }
    }
    private Node root;
    public int size() {return size(root); }
    private int size(Node x)
    {
        if(x==null) return 0;
        else return x.N;
    }
    private boolean isRed(Node x){
        if(x==null) return false;
        else return x.color==RED;
    }
    private Node rotateLeft(Node h)
    {
        Node x=h.right;
        h.right=x.left;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }
    private Node rotateRight(Node h)
    {
        Node x=h.left;
        h.left=x.right;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }
    void flipColors(Node h)
    {
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
    public void put (Key key,Value val){
        root=put(root,key,val);
        root.color=BLACK;
    }
    private Node put(Node h,Key key,Value val)
    {
        if(h==null)return new Node(key,val,1,RED);
        int cmp=key.compareTo(h.key);
        if(cmp<0) h.left=put(h.left,key,val);
        else if(cmp>0) h.right=put(h.right,key,val);
        else h.val=val;
        if(isRed(h.right)&& !isRed((h.left))) h=rotateLeft(h);
        if(isRed(h.left)&& isRed(h.left.left))h=rotateRight(h);
        if(isRed(h.right)&& isRed(h.left))flipColors(h);
        h.N=size(h.left)+size(h.right)+1;
        return h;
    }
    public Value get (Key key)
    {
        return get(root, key);
    }
    private Value get(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0)return get(x.left,key);
        if(cmp>0) return get(x.right,key);
        else return x.val;
    }
}
