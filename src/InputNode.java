import java.util.*;

/**
 * This class will handle the inputs.
 * @author choeseoyeon
 *
 */
public class InputNode extends StatementNode{
	//initialize the list for input 
    private List<Node> list; 
    
    /**
     * Constructor for Inputnode class 
     * @param i
     */
    public InputNode(List<Node> i) {
        this.list = i;
    }
//getter
    public List<Node> getString() {
        return this.list;
    }
    /**
     * Convert to string type
     */
    public String toString() {
        String s = "Input(";
       
        for(int i = 0; i < list.size(); i++) {
        	Node n = list.get(i);
        	
        	s = s + n.toString() + ", ";
        }
        return s.substring(0, s.length()-2) + ")"; 
    }
}
