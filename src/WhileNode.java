import java.util.List;
/**
 * This class will handle the while node
 * @author choeseoyeon
 *
 */

public class WhileNode extends StatementNode{
	
	//create list for the variable reference Node 
    private List<VariableReferenceNode> variableNode;
    
    /**
     * Constructor
     * @param v
     */
    public WhileNode(List<VariableReferenceNode> v) {
        this.variableNode = v;
    }
/**
 * getter for the variable reference Node 
 * @return List<VariableReferenceNode>
 */
    public List<VariableReferenceNode> getVars() {
        return this.variableNode;
    }
/**
 * Convert type to string type 
 */
    public String toString() {
        String s = "While";
        
        for(int i =0; i < variableNode.size(); i++) {
        	String s1 = variableNode.get(i).toString(); 
        	
        	s+= s1 +", ";
        }
        return s.substring(0, s.length()-2) + ")";  //don't print , 
    }
}
