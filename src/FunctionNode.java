
import java.util.*;
//public class FunctionNode extends Node{

/**
 * This class is inherited from the CallableNode class 
 * @author choeseoyeon
 *
 */
	public class FunctionNode extends CallableNode  {   
		//initialize 
		
    private String fname; //function name 
    private List<Node> expList; 
    //list of VariableReferenceNode 
    private List<VariableReferenceNode> vrList;

    /**
    public FunctionNode(String f, List<Node> e) {
        this.fname = f;
        this.expList = e;
    }
**/
    
    //constructor 
    public FunctionNode(String f, List<VariableReferenceNode> vr) {
    	this.fname = f; 
    	this.vrList = vr; 
    }
    /**
     * getter for function name 
     */
    public String getFunction() {
        return this.fname;
    }
/**
    public List<Node> getFunctionList() {
        return this.expList;
    }
    **/
    
    /**
    public List<VariableReferenceNode> getFunctionListFromVrNode(){
    	return this.vrList; 
    }
**/
    
    /**
     * getter for the vrList
     */
    @Override
	public List<VariableReferenceNode> getFunctionList() {
		// TODO Auto-generated method stub
		return this.vrList; 
	}
    
    /**
     * Convert to string type 
     */
    public String toString() {
        String s = "Function(" + this.fname+ ", ";
        
        for (Node n : this.vrList) {  //exList
            s += n.toString()+", ";
        }
        return s.substring(0, s.length()-2) + ")";
    }
/**
 * check whether it is empty or not
 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}