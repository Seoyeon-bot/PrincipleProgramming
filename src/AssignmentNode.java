
/**
 * this node class will handle assignment node
 * this node class have left and right.
 * @author choeseoyeon
 *
 * @param <Mathoptype>
 */
 
public class AssignmentNode extends StatementNode {
	//initialize 
     private VariableReferenceNode varNode; // variableNode 
     private Node val;

/**
 * THis is constructor 
 * @param n
 * @param v
 */
     public AssignmentNode(VariableReferenceNode n, Node v) {
         this.varNode = n;
         this.val = v;
     }
/**
 * getter for varNode 
 * @return
 */
     public VariableReferenceNode getVar() {
         return this.varNode;
     }
/**
 * getter for Node val
 * @return
 */
     public Node getVal() {
         return this.val;
     }
/**
 * Convert to Stirng type 
 */
     public String toString() {
    	 String vrNode = this.varNode.toString(); 
    	 String value = this.val.toString(); 
         return "Assignment(" + vrNode + ", " + value + ")";
     }
 }