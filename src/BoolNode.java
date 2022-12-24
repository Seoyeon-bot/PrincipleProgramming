
public class BoolNode extends Node {
	
	private boolean isTrue; 
	
	/**
	 * constuctor 
	 */

	public BoolNode() {
		
	}
	public BoolNode(boolean b) {
		this.isTrue = b; 
	}
	/**
	 * getter for the boolean expression 
	 */
	public boolean getBooleanExpression() {
		return this.isTrue; 
	}
	
	/**
	 * convert to the string type. 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BooleanExpression(" + this.isTrue + ")"; 
	}
	
}
