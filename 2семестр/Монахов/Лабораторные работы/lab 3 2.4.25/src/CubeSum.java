import java.math.BigInteger;

public class CubeSum implements Comparable<CubeSum> {
    private int i;
    private int j;
    private BigInteger cubesum;
    public CubeSum(int i, int j,BigInteger cubesum){
        this.i = i;
        this.j = j;
        this.cubesum = cubesum;
    }
    public int getI() {
        return this.i;
    }
    public int getJ() {
        return this.j;
    }
    public BigInteger getCubesum() {
        return this.cubesum;
    }
    public String toString() {
        return "i =" + this.i + " j =" + this.j + " cubesum=" + this.cubesum;
    }
    @Override
    public int compareTo(CubeSum that) {
        return this.cubesum.compareTo(that.getCubesum());
    }

}
