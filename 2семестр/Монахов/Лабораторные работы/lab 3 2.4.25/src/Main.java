import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap; // Box with CubeSum
import java.util.List;
import java.util.Map; // for Hashmap

public class Main {


    public static void main(String[] args){
        ///------/---
        int n = 1000;
        PriorityQueue<CubeSum> priorityQueue = new PriorityQueue<CubeSum>(n, PriorityQueue.Orientation.MIN);
        ///------/---
        addElements(priorityQueue,n);
        computingElements(priorityQueue,n);
    }

    public static void addElements(PriorityQueue<CubeSum> priorityQueue,int N){
        for(int i = 0 ; i < N; i++){
            BigInteger cubesum = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i));
            priorityQueue.insert(new CubeSum(i,0,cubesum));
        }
    }

    public static void computingElements(PriorityQueue<CubeSum> priorityQueue,int N){
        Map<BigInteger,List<CubeSum>> valuesMap = new HashMap<>();

        while(!priorityQueue.isEmpty()){
            CubeSum temp = priorityQueue.deleteTop();
            checkSum(valuesMap,temp);
            if(temp.getJ()< N){
                BigInteger i = BigInteger.valueOf(temp.getI());
                BigInteger j = BigInteger.valueOf(temp.getJ());
                BigInteger cubesum = i.multiply(i).multiply(i).add(j.multiply(j).multiply(j));
                priorityQueue.insert(new CubeSum(temp.getI(),temp.getJ()+1,cubesum));
            }
        }
    }

    public static void checkSum(Map<BigInteger, List<CubeSum>> valuesMap, CubeSum temp){
        List<CubeSum> values = new ArrayList<>();
        if (valuesMap.containsKey(temp.getCubesum())) {
            values = valuesMap.get(temp.getCubesum());
        }
        for(CubeSum cubeSum : values){
            if(cubeSum.getCubesum().equals(temp.getCubesum())
                    && cubeSum.getI() != cubeSum.getJ()
                    && cubeSum.getI() != temp.getI()
                    && cubeSum.getI() != temp.getJ()
                    && cubeSum.getJ() != temp.getI()
                    && cubeSum.getJ() != temp.getJ()){
                System.out.println("-----------------");
                System.out.println(cubeSum.toString());
                System.out.println(temp.toString());
                System.out.println("-----------------");
            }
        }
        values.add(temp);
        valuesMap.put(temp.getCubesum(), values);
    }
}
