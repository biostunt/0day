public class Main {
    public static int FindKeyPosition(char key){
        char[] alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for(int i = 0; i < alphabet.length; i++)
            if(alphabet[i] == key)
                return i;
        return 0;
    }

    public static void putElement(char key, int a, int M, int k, SeparateChainHashtable hashtable){
        hashtable.put(key,(a * k) % M);
    }
    public static String getElement(char key, SeparateChainHashtable hashtable){

        return "" + hashtable.get(key);
    }
    public static boolean BestFunction(int a,int M,char[] key, int[] keyPositionArray){
        SeparateChainHashtable hashtable = new SeparateChainHashtable();
        for(int i = 0; i < keyPositionArray.length; i++){
            putElement(key[i],a,M,keyPositionArray[i], hashtable);
        }
        if(CheckTheSameHash(key,hashtable)){
            return false;
        } else {
            return true;
        }
    }
    public static boolean CheckTheSameHash(char[] key, SeparateChainHashtable hashtable){
        for(int i = 0; i <key.length; i++){
            for(int j = i + 1; j < key.length; j++){
                if(getElement(key[i],hashtable).equals(getElement(key[j],hashtable))) return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int a,m;
        int MAX = 100;
        int Mmin = Integer.MAX_VALUE;
        String[] answers = new String[MAX * MAX];
        int count_ans = 0;
        char[] key = "SEARCHXMPL".toCharArray();
        int[] keyPositionArray = new int[key.length]; // that's will be k array
        for(int i = 0; i < key.length; i++) keyPositionArray[i] = FindKeyPosition(key[i]);
        for(a = 1;a < MAX; a++ ){
            for(m = 1; m< MAX; m++){
                boolean temp = BestFunction(a,m,key,keyPositionArray);
                if(m <= Mmin && temp){
                    Mmin = m;
                    answers[count_ans] = "a = " + a + " m = " + m;
                    count_ans++;
                }
            }
        }
        int i = 0;
        while(answers[i] != null) System.out.println(answers[i++]);
    }
}
