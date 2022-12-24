
public class CharNode extends Node{

	//intialize 
	private char charValue;
	
	/**
	 * constructor
	 */
	public CharNode() {
		
	}
	public CharNode(char c) {
		this.charValue = c; 
	}
	/**
	 * getter for the char node 
	 */
	public char getCharNode() {
		return this.charValue;
	}
	/**
	 * Convert type to string 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Char(" + this.charValue + ")"; 
 	}

	
}
