/**
 * This class is child class of InterpreterDataType
 * This class will hendle Float data type
 * @author choeseoyeon
 *
 */
public class FloatDataType extends InterpreterDataType {

	//have a value(of the appropriate type
	//initialize 
	private	float value; 
		//call IntegerNode 
		FloatNode fNode = new FloatNode();
		//private FloatNode input1; 
		
		/**
		 * constructor
		 */
		public FloatDataType() {
			
		}
		public FloatDataType(float value) {
			this.value = value;
		}
		/**
		 * getter for value 
		 */
		public float getValue() {
			return value; 
		}
		/**
		 * setter for value 
		 */
		public void setValue(float value) {
			this.value = value; 
		}
//toString method 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Float.toString(value); 
		//return "FloatDataType(" + this.value + ")"; 
	}

	@Override
	//read from the string 
	public void FromString(String input) {
		// TODO Auto-generated method stub
		value = Float.parseFloat(input);
		//System.out.println(input1); 
	}
	/**
	 * getter for name 
	 */
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return String.valueOf(getValue());   //float - > string 
	}
	/**
	 * add interpreter data type 
	 */
	@Override
	public void add(InterpreterDataType second) {
		// TODO Auto-generated method stub
		InterpreterDataType first = null; 
		InterpreterDataType seconde = null; 
		
		 System.out.println(first .getName() + seconde.getName()); 

	}

	
}
