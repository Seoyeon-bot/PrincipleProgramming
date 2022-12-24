

/**
 * this class one of AST nodes.
 * @author choeseoyeon
 *
 */
	public class VariableReferenceNode extends Node{
		
		//initalize 
		private String var;
		/**
		 * constructor 
		 * @param s
		 */
	    public VariableReferenceNode(String s) {
	        this.var = s;
	    }
       /**
        * getter  for the varible 
        * @return
        */
	    public String getVarName() {
	        return this.var;
	    }
	    /**
	     * Convert to string type 
	     */
	    
	    public String toString() {
	        return "Variable("+this.var+")";
	    }
/**
 * getter for the token type 
 * @param type
 * @return
 */
		public IntDataType getType(Token.Type type) {
			// TODO Auto-generated method stub
			return this.getType(null);
		}
	}