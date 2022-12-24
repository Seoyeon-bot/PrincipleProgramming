/**
 * This clss is for ReapeatNode 
 * @author choeseoyeon
 *
 */
public class RepeatNode extends StatementNode{
	
	//initalize 
    private VariableReferenceNode var;
    private Node repeatNode;

    /**
     * constructor 
     * @param v
     */
    public RepeatNode(VariableReferenceNode v) {
        this.var = v;
    }
/**
 * getter for the variable reference node 
 * @return
 */
    public VariableReferenceNode getVar() {
        return this.var;
    }

/**
 * setter for the node
 * @param n
 */
    public void setRepeat(Node n) {
        this.repeatNode = n;
    }
/**
 * getter for the node 
 * @return Node 
 */
    public Node getRepeat() {
        return this.repeatNode;
    }
/**
 * Convert type to string type 
 */
    public String toString() {
    	String s = var.toString(); 
        return "Next(" + s + ")";
    }
}
