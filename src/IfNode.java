
/**
 * This class will handle boolean expressions 
 * @author choeseoyeon
 *
 */
public class IfNode extends StatementNode{
	
	//initialize 
    private Node boolExp; //booleanExpression node 
    private String label;

    /**
     * constructor 
     * @param b
     * @param l
     */
    public IfNode(Node b, String l) {
        this.boolExp = b;
        this.label = l;
    }
/**
 * getter for boolean expression 
 * @return
 */
    public Node getBool() {
        return this.boolExp;
    }
/**
 * get the label
 * @return
 */
    public String getLabel() {
        return this.label;
    }
/**
 * Convert to String type 
 */
    public String toString() {
    	String bexpression = this.boolExp.toString(); 
    	String l = this.label.toString(); 
        return "If(" + bexpression + ", " + l + ")";
    }
}