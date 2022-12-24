import java.util.List;
/**
 * This is abstarct class for Built in function node 
 * @author choeseoyeon
 *
 */
public abstract class BuiltInFunctionNode extends CallableNode {

	//make boolean method 
	//make abstract method excute - takes collection of InterpreterDataType objects
	
     String data; 
     //collection of interpreterDataType objects 
     List<InterpreterDataType> dataType ;
	//accept any number of parametr of any type - variadic
	/**
	 * constructor 
	 */
	public BuiltInFunctionNode(String data) {
		this.data = data; 
	}
	/**
	 * constructor with List<VariableRefrenceNode> 
	 * @param vr
	 */
	public BuiltInFunctionNode(List<VariableReferenceNode> vr) {
		this.vrList = vr; 
	}
	
	//make a boolean function 
	/**
	 * boolean function to determine whether the input(data) is variadic or not 
	 * @param data
	 * @return true/ false 
	 */
	public boolean isVariadic(String data) {
		if(data == "read" || data == "write" || data == "squareRoot"
				|| data == "gerRandom" || data == "integerToReal" 
				|| data == "realToInteger") { //any type
			return true; 
		}else {
			return false; 
		}
	}
	//Overrided function from the CallableNode class 
	@Override
	public String getFunction() {
		// TODO Auto-generated method stub
		 return this.fname;
	}
	@Override
	public List<VariableReferenceNode> getFunctionList() {
		// TODO Auto-generated method stub
		return this.vrList;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 String s = "BuiltInFuction("+this.fname+", ";
	        for (Node n : this.vrList) {
	            s += n.toString()+", ";
	        }
	        return s.substring(0, s.length()-2) + ")";
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * this is abstract method 
	 * This will take collection of interpreterdatatype objects 
	 * @param dataType
	 * @throws Exception
	 */
	
	public abstract void Execute( List<InterpreterDataType> dataType) throws Exception; 
	
	/**
	 * read 
	 * write
	 * suareRoot
	 * getRandom
	 * integerToReal
	 * realToInteger
	 * 
	 */
	
	/**
	public String data;
	private Node next; 
	
	public List<VariableReferenceNode> vars;
	//constructor 
	public BuiltInFunctionNode(List<VariableReferenceNode> v) {
		this.vars = v; 
	}
	
	/**
	 * constructor
	 * @author choeseoyeon
	 *
	 */
	/**
	public BuiltInFunctionNode(String data) {
		this.data =data; 
		this.next = null;
	}
	
	//getter for node 
	public Node getNextNode() {
		return this.next;
	}
	//setter
	public void setNextNode(Node node) {
		this.next = node; 
	}
	//subclass-read 
	
	class read extends BuiltInFunctionNode{
		public read(List<VariableReferenceNode> v) {
			super(v);
			// TODO Auto-generated constructor stub
		}
		//useReadNode 
		//private  List<VariableReferenceNode> vars;
		//getter for var
		public List<VariableReferenceNode> getVars(){
			return this.vars;
		}
		//toString
		public String toString() {
			String s = "Read(";
			for(VariableReferenceNode v : vars) {
				s+= v.toString() + ", ";
			}
			return s.substring(0,s.length()-2) + ")"; 
		}
	}
	
	class write extends BuiltInFunctionNode{
		//constructor
		public write(List<VariableReferenceNode> v) {
			super(v);
			// TODO Auto-generated constructor stub
		}
		
		//call variableReferenceNode class 
	VariableReferenceNode vrnode = new VariableReferenceNode(data); 
	//call IntDataType
	boolean intType = new IntDataType(); 
	//call FloatDataType()
	FloatDataType = floatType = new FloatDataType(); 
	
	Token.Type type; 
	//toString
	public String toString() {
		//the type is integer
				if(intType = vrnode.getType(type) != null) {
					//write function with integer type 
					
					
				}else if(floatType = vrnode.getType(type)) {
					
				}else {
					//string type 
					
				}
	}
	
	}
	class squareRoot{
		
	}
	class getRandom{
		
	}
	class integerToReal{
		
	}
	class realToInteger{
		
	}
	**/
	
}
