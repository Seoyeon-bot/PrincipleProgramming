import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is inherited from BuiltInFunctionNode 
 * @author choeseoyeon
 *
 */
public class Read extends BuiltInFunctionNode {

	/**
	 * Constructor
	 * @param vr
	 */
	
	
	public Read(List<VariableReferenceNode> vr) {
		super(vr);
		// TODO Auto-generated constructor stub
	}
 
/**
  * getter for the variableReferenceNode 
  * @return
  */
	public List<VariableReferenceNode> getVr(){
		return this.vrList;
	}
 /**
  * Convert to String type 
  */
	public String toString() {
		String s = "Read(";
		
		for(VariableReferenceNode v : vrList) {
			s+= v.toString() + ", "; 
		}
		return s.substring(0,s.length()-2) + ")"; 
	}
	@Override
	//take collection of InterpreterDataType objects
	public  void Execute(List<InterpreterDataType> dataType) throws Exception {
		// TODO Auto-generated method stub
		
		//check data type - if it is not corret type throw exceptions 
		// Use the collection of InterpreterDataType
		//-> to get parameters and to output to variable parameters. 
		
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
			for(int i =0; i < dataType.size(); i++) {
				dataType.get(i).FromString(data);
			}
			
		
		}
	}

}
