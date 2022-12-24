
/**
 * This class will handle mathoperation with left , right nodes. 
 * @author choeseoyeon
 *
 */
public class MathOpNode extends Node{
	
	/**
	 * create enum type
	 * @author choeseoyeon
	 *
	 */
    public enum Operations{
        add, subtract, multiply, divide
    }
    
    //initalize 
    Node left;
	Node right;
    FunctionNode right1;
    private Operations operation;
    
    /**
     * Constructor 
     * @param op
     * @param e1
     * @param op2
     */
    public MathOpNode(Operations op, Node e1, Node op2) {
        this.left = e1;
        this.right = op2;
        this.operation = op;
    }
   /**
    * Constructor 
    * @param op
    * @param op1
    * @param functionNode
    */
    //extra changes
    public MathOpNode(Operations op, Node op1, FunctionNode functionNode) {
        this.left = op1;
        this.right1 = functionNode;
        this.operation = op;
    }
    /**
     * extra method for math operator 
     */
    public static  float  DoMathOp(Token.Type type, float num1, float num2) {
    	float output = 0; 
    	if(type == Token.Type.Plus) {
    		output = num1 + num2; 
    		return output; 
    	}
    	else if(type == Token.Type.Minus) { 
    		output = num1 - num2; 
    		return output;
    	}
    	else if(type == Token.Type.Multiply) {
    		output = num1 * num2; 
    		return output;
    	}
    	else if(type == Token.Type.Divide)
    		output = num1 / num2; 
    	return output; 
    }
/**
 * getter for left node 
 * @return
 */
    public Node getLeft() {
        return this.left;
    }
/**
 * getter for right side node 
 * @return
 */
    public Node getRight() {
        return this.right;
    }
/**
 * getter for operation
 * @return
 */
    public Operations getOp() {
        return this.operation;
    }
/**
 * Convert to string type
 */
    public String toString() {
        char c = ' ';
        switch (this.operation)
        {
            case add: c='+'; break;
            case subtract: c='-'; break;
            case multiply: c='*'; break;
            case divide: c='/'; break;
            default: break;
        }
        return ("MathOpNode("+c+", "+this.left.toString()+", "+this.right.toString()+")");
    }
}