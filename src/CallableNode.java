import java.util.ArrayList;
import java.util.List;

/**
 * This is abstract class and super class of BuiltInFunctionNode class 
 * @author choeseoyeon
 *
 */
public abstract class CallableNode {

	//function name, list of VRN for paramether 
	
	//function name 
	 protected String fname; 
	 //list of VariableReferenceNode 
    protected  List<VariableReferenceNode> vrList = new ArrayList<VariableReferenceNode> (); 
    //get function name 
    public abstract String getFunction();
    //get function list 
    public abstract List<VariableReferenceNode> getFunctionList(); 
    //toString() method 
    public abstract String toString();
    // check whether node is empty or not 
    public abstract boolean isEmpty(); 
    
    
}
