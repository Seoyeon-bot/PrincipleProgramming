/**
 * This class will hold String Node 
 * @author choeseoyeon
 *
 */
public class StringNode extends Node {
	
	//initalize 
    private String stringValue;
    /**
     * Constructer 
     * @param q
     */
    public StringNode(String s) {
        this.stringValue = s;
    }
public StringNode() {
		// TODO Auto-generated constructor stub
	}
/**
 * getter for stringNode 
 * @return
 */
    public String getString() {
        return this.stringValue;
    }
    /**
     * setter for stringNode 
     */
    public void setString() {
    	this.stringValue = stringValue; 
    }
   /**
    * Convert type to String type. 
    */
    public String toString() {
        return "String(" + stringValue + ")";
    }
}
