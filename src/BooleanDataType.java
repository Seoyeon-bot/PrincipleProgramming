
/**
 * This class will extends from the interpreterDataType class
 * This class will handle Boolean type  inputs. //true, false
 * @author choeseoyeon
 *
 */
public class BooleanDataType  extends InterpreterDataType{

	//initialize
	private boolean value; 
	
	//call boolenNode 
	
	/**
	 * constructor
	 */
	public BooleanDataType() {
		
	}
	public BooleanDataType(boolean value) {
		 this.value = value;
	}
	/**
	 * getter for the boolean data type value
	 */
	public boolean getValue() {
		return value; 
	}
	/**
	 * setter for the boolean data type value
	 */
	public void setValue(boolean value) {
		 this.value = value; 
	}
	/**
	 * convert to the string data type 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Boolean.toString(value);
	}
/**
 * sets the value of data type 
 */
	@Override
	public void FromString(String input) {
		// TODO Auto-generated method stub
		//value = Boolean.valueOf(input); 
		value = Boolean.parseBoolean(input);
	}
/**
 * getter for the name 
 */
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return Boolean.toString(getValue()); //boolen -> value
	}

	/**
	 * add interpreter data type 
	 */
	@Override
	public void add(InterpreterDataType second) {
		// TODO Auto-generated method stub
		
		InterpreterDataType first = null; 
		InterpreterDataType seconde = null; 
		
		System.out.println(first.getName() + seconde.getName()); 
	}

}
