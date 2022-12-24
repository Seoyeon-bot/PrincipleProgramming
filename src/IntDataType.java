
public class IntDataType extends InterpreterDataType{

	
	//have a value(of the appropriate type) 
	private int value; 
	
	//call IntegerNode 
	IntegerNode intNode = new IntegerNode();
	//private IntegerNode input; 

	/**
	 * constructor 
	 * 
	 */
	public IntDataType() {
		
	}
	public IntDataType(int value) {
		this.value =value; 
	}
	/**
	 * getter for value 
	 */
	public int getValue() {
		return value; 
	}
	/**
	 * setter for value 
	 */
	public void setValue(int value) {
		this.value = value; 
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(value); 
		//return "Integer( " + this.value + ")";
		
		
	}

	@Override
	// sets the value of the data type by parsing the string ...?
	public void FromString(String input) {
		// TODO Auto-generated method stub
		//this.input2 = intNode; 
		value = Integer.parseInt(input); 
	}
	/**
	 * getter for Name
	 */
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return  Integer.toString(getValue()); //int -> value 
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
