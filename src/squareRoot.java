import java.util.List;
/**
 * This class is inherited from builtinfunctionnode class 
 * @author choeseoyeon
 *
 */
public class squareRoot extends BuiltInFunctionNode {

	/**
	 * constructor 
	 * @param vr
	 */
	
public squareRoot(List<VariableReferenceNode> vr) {
		super(vr);
		// TODO Auto-generated constructor stub
	}

/**
 * Convert to string type 
 */
	public String toString() {
		String s = "squareRoot("; 
		for(VariableReferenceNode v : vrList) {
			s+= v.toString() +", ";
		}
		return s.substring(0, s.length()-2) + ")"; 
	}
	
	/**
	 * excuete 
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
		if(!(dataType.get(0) instanceof FloatDataType)) {
			throw new Exception("Invaid dataType to do square root function"); 
		}
		
		FloatDataType fType = (FloatDataType)dataType.get(0); 
		fType.setValue((float)Math.sqrt(fType.getValue()));
	}

}
