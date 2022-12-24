/**
 * This class will extends from the interpretereDataType class 
 * This class will handle char type 
 * @author choeseoyeon
 *
 */
public class CharDataType extends InterpreterDataType{

	//initialize 
	private char value; 
	
	//call CharNode
	CharNode cNode = new CharNode(); 
	
	/**
	 * constructor
	 */
	public CharDataType() {
		
	}
	public CharDataType(char value) {
		this.value = value;
	}
	/**
	 * getter for the char type value 
	 */
	public char getValue() {
		return value; 
	}
	/**
	 * setter for the char type value 
	 */
	public void setValue(char value) {
		this.value = value; 
	}
	/**
	 * convert to the string type 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Character.toString(value);
		//return "Character(" + this.value + ")";
 	}
/**
 * sets the value of data type
 */
	@Override
	public void FromString(String input) {
		// TODO Auto-generated method stub
		
		//value = Character.
		char[] myChars = input.toCharArray();
		
		for(int i=0; i > myChars.length; i++) {
			System.out.println(myChars[i]); 
			
		}
	}
/**
 * getter for Name
 */
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return Character.toString(getValue()); //char - > value 
	}

	/**
	 * add interpereter data type 
	 */
	@Override
	public void add(InterpreterDataType second) {
		// TODO Auto-generated method stub
		InterpreterDataType first = null; 
		InterpreterDataType seconde = null; 
		
		System.out.println(first.getName() + seconde.getName());
		
	}

	
}
