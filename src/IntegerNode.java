
/**
 * This class will handle integer type node 
 * @author choeseoyeon
 *
 */
public class IntegerNode extends Node{
	//initialize number 
    private int num;
/**
 * constructor 
 */
    public IntegerNode() {
    	
    }
    /**
     * constructor 
     * @param n
     */
    public IntegerNode(int n) {
        this.num = n;
    }
    /**
     * getter for integer number 
     * @return
     */
    public int getInt() {
        return this.num;
    }
    /**
     * Convert type to string 
     */
    public String toString() {
        return "Int("+this.num+")";
    }
}