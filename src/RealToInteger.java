import java.util.List;
/**
 * This class is inherited from builtinfunctionnode class 
 * @author choeseoyeon
 *
 */
public class RealToInteger extends BuiltInFunctionNode {

	/**
	 * constructor 
	 * @param vr
	 */
	public RealToInteger(List<VariableReferenceNode> vr) {
		super(vr);
		// TODO Auto-generated constructor stub
	}
/**
 * convert real value to the integer value 
 * @param a
 * @return
 */
	//convert  real to integer 
	public int RealToInt(FloatDataType a) {
		//check whether vr is integer or float/double 
		IntegerNode intNode = new IntegerNode();  //call IntegerNode 
		int n = intNode.getInt();   // set n as integer value 
		//int n; 
		FloatNode fnode =new FloatNode(); //call floatNode 
		double d  = fnode.getFloat();    //set d as double/float value 
		//double d; 
	   	d = fnode.getFloat(); 
		
		n =(int)Math.floor(d); 
		//check whether the number is integer or float/double value 
		if(n == d) {
			//number is integer -> don't  convert it 
			return n; 
		}else {
			//numbe is Float or Double value -> convert it to the int
			return (int) d; 
		}
		
	}
	/**
	 * excuete 
	 */
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
