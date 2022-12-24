
import java.util.List;

/**
 * This class is inherted from BuiltInFunctioNode
 * @author choeseoyeon
 *
 */
public class getRandom extends BuiltInFunctionNode {

	/**
	 * constructor 
	 * @param vr
	 */
	public getRandom(List<VariableReferenceNode> vr) {
		super(vr);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Convert to string type 
	 */
	//toString method 
	public String toString() {
		return "getRandomNode"; 
	}

	@Override
	public void Execute(List<InterpreterDataType> dataType) throws Exception {
		// TODO Auto-generated method stub
		
		//List<InterpreterDataType> dataType
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
	}

}
