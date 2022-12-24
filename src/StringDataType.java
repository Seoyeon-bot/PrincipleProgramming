
/**
 * This class will extends from the interpreterDataType class 
 * This class will handle string type inputs. 
 * @author choeseoyeon
 *
 */
public class StringDataType extends InterpreterDataType{

	//initialize 
	private String value; 
	//call StringNode 
	StringNode  sNode = new StringNode(); 
	
	/**
	 * Constructor 
	 */
	public StringDataType() {
		
	}
	public StringDataType(String value) {
		this.value = value; 
	}
	/**
	 * getter for the string data type value
	 */
	public String getValue() {
		return value; 
	}
	/**
	 * setter for the string data type value 
	 */
	public void setValue(String value) {
		this.value = value; 
	}
	/**
	 * convert to the string data type 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;  //data type is string so it is not necessary to convert.  
	}
/**
 * set the value of data type 
 */
	@Override
	public void FromString(String input) {
		// TODO Auto-generated method stub
		
		value = input; 
	}
/**
 * getter for the Name 
 */
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return value; 
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
