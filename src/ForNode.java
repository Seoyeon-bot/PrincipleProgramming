
/**
 * This class is for ForNode
 * @author choeseoyeon
 *
 */
public class ForNode extends StatementNode {
	//initialize 
    private VariableReferenceNode vNode;
    private IntegerNode firstV; //first value 
    private IntegerNode lastV;   // last value 
    private IntegerNode step;
    private Node NextNext;

    /**
     * Constructor for ForNode
     * @param v
     * @param n1
     * @param n2
     * @param s
     */
    public ForNode(VariableReferenceNode v, IntegerNode n1, IntegerNode n2, IntegerNode s) {
        this.vNode = v;
        this.firstV = n1;
        this.lastV = n2;
        this.step = s;
    }

    /**
     * getter for variablereferenceNode 
     * @return
     */
    public VariableReferenceNode getVar() {
        return this.vNode;
    }
/**
 * getter for firstValue
 * @return
 */
    public IntegerNode getFirstV() {
        return this.firstV;
    }
/**
 * getter for lastValue
 * @return
 */
    public IntegerNode getLastV() {
        return this.lastV;
    }
/**
 * getter for step 
 * @return
 */
    public IntegerNode getStep() {
        return this.step;
    }
/**
 * setter for the nextnext node
 * @param n
 */
    public void setNext(Node n) {
        NextNext = n;
    }
/**
 * getter for the next next node 
 * @return
 */
    public Node getNext() {
        return this.NextNext;
    }
/**
 * This method will used for Interpreter class forNextVisit method. 
 */
    public void accept() {
        Interpreter.forNextVisit(this);
    }
/**
 * Convert type to string 
 */
    public String toString(){
    	String value = vNode.toString();
    	String first = firstV.toString(); 
    	String last = lastV.toString(); 
    	String steps = step.toString(); 
    	
        return "For("+ value +", "+  first +", "+ last +", "+ steps +")";
    }
}