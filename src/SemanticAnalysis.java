import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SemanticAnalysis {

	
	//create method that call CheckAssignments 
	//pass our collection of functions to this method 
	
	
	//call necessary classes 
	private Parser parser;
	
	//initialize 
	private int errors; 
	//List<FunctionNode> flist = new List
			
	/**
	 * constructor 
	 * @param flist
	 */
	public SemanticAnalysis(){
		
	}
	public SemanticAnalysis(FileReader file) throws IOException{
		this.parser = new Parser(null);
	}
	/**
	 * this method will print error 
	 */
		public int getErrors() {
			return errors;
		}
	/**
	 * This method will check each assignment statements. 
	 * @param flist
	 * @throws Exception 
	 */
	public void CheckAssignments(List<StatementNode> slist) throws Exception {
		
		
		for(int i =0; i < slist.size(); i++) {
			StatementNode sNode = slist.get(i); //fist node 
			String s1 = slist.get(i).toString(); // convert first node to string type 
			
			//set interpeterdatatype 
			InterpreterDataType first = null; 
			InterpreterDataType second = null; 
			
			float f1 = 0; 
			float f2 = 0 ; 
			IntegerToReal integerToReal = new IntegerToReal(null); //call class IntergerToReal
			//if s1 contains numbers than check whether both number is int or float. 
			if(s1.contains(Token.Type.Number.toString())) {
				//case if first is int and second is float type 
				if(sNode != null && ((first instanceof IntDataType) &&( second instanceof FloatDataType))) {
					//convert int type to the float type 
					IntDataType a = (IntDataType)first;   //down casting 
					 f1 = integerToReal.IntToReal(a);  //convert int to real value 
					
					FloatDataType b = (FloatDataType)second;  // down casting 
					 f2 = b.getValue(); 
				}
				//case if first is float and second is int type -> convert both as float 
				else if((first instanceof FloatDataType) && (second instanceof IntDataType)) {
					FloatDataType a = (FloatDataType)first; 
					 f1 = a.getValue(); 
					IntDataType b = (IntDataType)second; //down casting 
					 f2 = integerToReal.IntToReal(b); 
				}
				else {
					//this case sNode is null or first and second is not interpreterDataType
					//so just throw exception. 
					System.out.println("This sNode is empty or this is not interpreterDataType. ");
					throw new Exception();  
				}
			}
			//initialize as string type 
			String operator = null; 
			String plus = Token.Type.Plus.toString();
			String minus = Token.Type.Minus.toString(); 
			String multiply = Token.Type.Multiply.toString();
			String divide = Token.Type.Divide.toString(); 
			
			//2+3+4 is allowed expression 
			if(sNode != null &&
			(s1.contains(plus) || s1.contains(minus) || s1.contains(multiply) || s1.contains(divide)))
			{
				//if there are 2 numbers then it need 1 operator, otherwise it is false. 
				
				
				// if f1 was integer type , this already converted to float
				//so just convert float to string
				String num1 = String.valueOf(f1); 
				String num2 = String.valueOf(f2); 
				
				float value; 
				//put if statement inside the for loop. so that this will be recursively repeated. 
				for(int j = 0; j < s1.length(); j++) {
					
					//case 2+3 is true, 2,3 is false; 
					if(s1.contains(num1) && s1.contains(num2)) {
						//check whether s1 contains one operator 
						if(s1.contains(operator)) {
							// always calculate / * + - order. 
							if(operator == divide) {
								value = MathOpNode.DoMathOp(Token.Type.Divide, f1, f2);
							}
							else if(operator == multiply) {
								value = MathOpNode.DoMathOp(Token.Type.Multiply, f1, f2);
							}
							else if(operator == plus) {
								//if case is 2+3 
								value = MathOpNode.DoMathOp(Token.Type.Plus, f1, f2);
							}
							else if(operator == minus) {
								//if case is 2 -3
								value = MathOpNode.DoMathOp(Token.Type.Minus, f1, f2);
							}
						}
						else if(!s1.contains(operator) || (s1.contains(operator) && s1.contains(operator))) {
							// if s1 contains 2 oprator or none of them -> error 
							System.out.println("This is invaild type"); 
							throw new Exception();  
						}
						else {
							//more than 3 operator case 
							System.out.println("There is too many operators compare to numbers. "); 
							throw new Exception(); 
						}
					}
				}
			}
			
			//4>x>9 is not allowd expression 
			// 4>x && x>9 is true 
			// 4>x || x >0 is true 
			
			//if snode is not empty and contains boolean expression 
			if(sNode != null && (isBoolean(s1)) ) {
				
				//if snode contains 2 boolean operator ->need || or && -> otherwise -> false 
				if((s1.contains(">")|| s1.contains(">=") || s1.contains("<") || s1.contains("<="))
				&&(s1.contains(">")|| s1.contains(">=") || s1.contains("<") || s1.contains("<="))){
					
					//check whether s1 contains || or &&
					if(s1.contains("||") || s1.contains("&&")) {
						
						//call interpreter class function 
						Interpreter.class.getMethods();	
					}
					else {
						//throw exception 
						//ex) 4>x>5 is invaild
						System.out.println("You can't use 2 boolean operator without using or or and operator.  "); 
						throw new Exception(); 
					}
					
				}
			}
		
			
		}
	}
	
	/**
	 * check whether it is boolean operator 
	 */
	private boolean isBoolean(String s) {
		return (s == ">") || (s == ">=") || (s == "<") || (s == "<=");
	}
}
