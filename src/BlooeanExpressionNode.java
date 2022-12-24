
/**
 * This class will handle the boolean expression 
 * @author choeseoyeon
 *
 */
public class BlooeanExpressionNode extends Node{
	//initialize 
    private Token.Type operation;
    private Node e1;
    private Node e2;

    /**
     * constructor
     * @param o
     * @param e1
     * @param e2
     */
    public BlooeanExpressionNode(Token.Type o, Node e1, Node e2) {
        this.operation = o;
        this.e1 = e1;
        this.e2 = e2;
    }

    //getter
    public Token.Type getOperation() {
        return this.operation;
    }
//getter for first expression 
    public Node getE1() {
        return this.e1;
    }
//getter for second expression 
    public Node getE2() {
        return this.e2;
    }
/**
 * Convert to string type
 */
    public String toString() {
    	
    	String s = this.e1.toString(); 
    	String s2 = this.e2.toString();
    	
        return "BooleanExpressionOP(" + s + ", " + this.operation+ ", " + s2 + ")";
    }

	

}
