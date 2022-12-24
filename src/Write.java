import java.util.List;

/**
 * This class is inherited from BuiltInFunctionNode class 
 * @author choeseoyeon
 *
 */
public class Write extends BuiltInFunctionNode {

	/**
	 * Constructor 
	 * @param vr
	 */
	public Write(List<VariableReferenceNode> vr) {
		super(vr);
		// TODO Auto-generated constructor stub
	}
/**
 * Getter for the variableReferenceNode 
 * @return
 */
	public List<VariableReferenceNode> getVr(){
		return this.vrList;
	}
	
/**
 * Convert to string type 
 */
	public String toString() {
		String s = "Write("; 
		for(VariableReferenceNode v : vrList) {
			s+= v.toString() +", ";
		}
		return s.substring(0, s.length()-2) + ")"; 
	}
	/**
	 * Execute
	 */
	@Override
	public void Execute(List<InterpreterDataType> dataType) throws Exception {
		// TODO Auto-generated method stub
		
		//List<InterpreterDataType> dataType
		/**
				IntDataType intType = new IntDataType();  //call intDataType class 
				FloatDataType floatType = new FloatDataType(); // call floatDataType class 
				
				for(InterpreterDataType d : dataType) {   //repeat loop
					
					if(d.equals(intType) || d.equals(floatType)) { //check whether datatype is vaild 
						System.out.println(d + " ");
						System.out.println(); 
					}
					else {   //invaild case
						throw new Exception("invaild input, not interpreterDataType"); 
					}
					
					
				}
**/
		if(dataType.size() != 1) {
			throw new Exception("invaild input, not interpreterDataType"); 
		}
		else {
			for(int i =0 ; i < dataType.size(); i++) {
				System.out.println(dataType.get(i).toString()); // write dataType
			}
		}
	}
}
