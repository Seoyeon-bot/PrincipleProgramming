
/**
 * Thsi abstract class will be parent class 
 * @author choeseoyeon
 *
 */
public abstract class InterpreterDataType {

	
	//abstract class
	
	//ToString()
	public abstract String toString();
	
	//FromString()
	public abstract void FromString(String input );

	protected abstract String getName();
/**
 * THis method will add 2 numbers 
 * @param second
 * @return 
 * @return 
 */
	public abstract  void add(InterpreterDataType second);

	
	
	
}
