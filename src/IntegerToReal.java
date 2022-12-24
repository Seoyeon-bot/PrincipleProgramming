
import java.util.List;

/**
 * This class is inherted from BuiltInFunctionNode 
 * @author choeseoyeon
 *
 */
public class IntegerToReal extends BuiltInFunctionNode {
//intiger to real number - real number can contail float value , decimal values
	/**
	 * constructor
	 * @param vr
	 * @return 
	 */
	
	public void IntegerToReal(String data) {
		this.data = data; 
	}
	
	public IntegerToReal(List<VariableReferenceNode> vr) {
		super(vr);
		// TODO Auto-generated constructor stub
	}
	
	
//change integer to realnumber 
	/**
	 * change integer value to real value 
	 * @param a
	 * @return
	 */
	public float IntToReal(IntDataType a) {
		/**
		//if input is integer 
		IntegerNode intValue = new IntegerNode(); 
		int a = intValue.getInt();
		float floatNumber;
		//how to figuare whethe theinput is float or int..? 
		FloatNode floatValue = new FloatNode(); 
		float f  = floatValue.getFloat(); 
		
		if (v.equals(a)) {
			//conver to a to real number (has decimals)  ex) float
			floatNumber = a; 
		}//if input is alrady float number ( real number) 
		else if(v.equals(f)) {
			return; 
		}
		**/
		IntegerNode intNode = new IntegerNode(); 
		int n = intNode.getInt();
		//int n; 
		FloatNode fnode =new FloatNode(); 
		double d  = fnode.getFloat(); 
		//double d; 
		d = fnode.getFloat(); 
		
		n =(int)Math.floor(d); 
		//check whether the number is integer or float/double value 
		if(n == d) {
			//number is integer -> need to be conver to real value 
			d = n; 
			return (float) d; 
		}else {
			//numbe is Float or Double value 
			return (float) d; 
		}
	}
	/**
	 * this method will used to check whether input is InterpreterDataType and 
	 * output to variable parameters
	 */
	@Override
	public void Execute(List<InterpreterDataType> dataType) throws Exception {
		// TODO Auto-generated method stub
		
		/**
		IntDataType intType = new IntDataType();  //call intDataType class 
		FloatDataType floatType = new FloatDataType(); // call floatDataType class 
	          for(int i =0; i < dataType.size(); i++) {
		          if(i == intType.a) {
		        	  //i is interdataType  - > able to execute 
		        		System.out.println(i+" ");   
		          }else if( i == floatType.f) {
		        	  //i is floatDataType  -> able to execute 
		        	  System.out.println(i + " "); 
		          }else if( !dataType.contains(i)) {
		        	  //if type is not interpreterDataType - throw exception 
		        	  throw new Exception("invaild input, not interpreterDataType"); 
		        	  
		          }
			
	          }
	          **
	          */
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
/**
 * convert InterpreterDataType float to Real value. 
 * This method will be used in interpreter class 
 * @param a
 * @return
 */
	public float FloatToReal(FloatDataType a) {
		// TODO Auto-generated method stub
		
		IntegerNode intNode = new IntegerNode(); 
		int n = intNode.getInt();
		//int n; 
		FloatNode fnode =new FloatNode(); 
		double d  = fnode.getFloat(); 
		//double d; 
		d = fnode.getFloat(); 
		
		n =(int)Math.floor(d); 
		//check whether the number is integer or float/double value 
		if(n == d) {
			//number is integer -> need to be conver to real value 
			d = n; 
			return (float) d; 
		}else {
			//numbe is Float or Double value 
			return (float) d; 
		}
	}

}
