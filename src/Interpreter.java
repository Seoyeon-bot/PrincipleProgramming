
import java.util.*;
/**
 * This class will calculate or interpreter the input based on their type.
 * @author choeseoyeon
 *
 */
public class Interpreter {
	
	//create HashMap< , > 
    static HashMap<String, Integer> SI = new HashMap<String, Integer>(); //string to int 
    static HashMap<String, Float> SF = new HashMap<String, Float>(); // string to float 
    static HashMap<String, String> SS = new HashMap<String, String>();   // string to string 
    static HashMap<String, Node> SN = new HashMap<String, Node>(); // string to Node 
    static HashMap<Integer, Float> IF = new HashMap<Integer,Float>();  //integer to float 
   // static HashMap<>
    static HashMap<String, InterpreterDataType> map = new HashMap<>(); 
	
    public static List<StatementNode> sList;
    public static List<String> inputs; 

    /**
     * This method will interpriate the statementsNode
     * @param statements
     */
    public Interpreter(StatementsNode statements) {
       // sList = new ArrayList<StatementNode>(statements.getStatements());
    }	
    	
    
    /**
     * This method will call other methods. 
     */

    public void callMethods() {
        
    	StatementNameNodeWalk();
        ForWalk();
        linkWalk();
        InterpreterBlock(sList, map); 
    }

    
    /**
     * print the statementNameNode 
     */
    public void StatementNameNodeWalk() {
        for (StatementNode sNode : sList) 
        {
        	 String s = sNode.toString(); 
            if (s.contains("StatementNameNode"))
            {
                System.out.println("it has StatementNameNode");
                StatementNameNode statementName = ( StatementNameNode) sNode;
             //   StatementNameNode.accept();
            }
        }
    }
   
    /**
     * This method will get StatementNameNode's value and statement 
     * it will put value and statemetn in the specific hashMap. 
     * @param name
     */
    public static void StatementNameNodeVisit(StatementNameNode name) {

        String Name = name.getValue();
        StatementNode childNode = name.getStatement();
        
        int i = sList.indexOf((StatementNode)name);
        sList.set(i, childNode); //set
        SN.put(Name , childNode); //push to specific map 
    }
    
    
    /**
     * This method will walk through statement and find ForNode
     */
    public void ForWalk() {
        for (StatementNode sNode : sList) 
        {
        	String s = sNode.toString();
            if (s.contains("For"))
            {
                ForNode forNode = (ForNode) sNode;
                forNode.accept();
            }
        }
    }
    //Visitor method - find Next node for For statement and node after next node
    /**
     * This method will find noes for For statements
     * @param fNode
     */
    public static void forNextVisit(ForNode fNode) {
        for (StatementNode sNode : sList) 
        {
          String s = sNode.toString();
            if (s.contains("Next")) // 
            {
            	//check it again (later)! 
                RepeatNode rNode = (RepeatNode) sNode;
                
              int i =   sList.indexOf((StatementNode)fNode); 
              StatementNode sn = sList.get(i+1);
                rNode.setRepeat((Node)sn);
                
                int sNodeIndex = sList.indexOf(sNode); 
                
                if ( sNodeIndex != sList.size()-1)
                    fNode.setNext((Node)sList.get( sNodeIndex+1));
                else 
                	rNode.setRepeat(null);
            }
        }
    }
    


    /**
     * This method will link the statements. 
     */
    public static void linkWalk() {
    	
        for (StatementNode sNode: sList)
        {
            //sets next statement to null if its the last statement
        	int i = sList.indexOf(sNode); 
            if (i == sList.size()-1) // if i is the last sNode then seet next as null 
                sNode.next = null; 
            //if i is not the last node
            else
                sNode.next = sList.get(i + 1); 
        }
    }

    /**
     * Resture HashMaps 
     * @return
     */
    public HashMap[] getMaps() {
        return new HashMap[]{SS, SI, SF};
    }

    /**
     * This method will return the list that contains StatementNode. 
     * @return List<StatementNode>
     */
    public List<StatementNode> getStatements() {
        return sList;
    }

    /**
     * InterpreterFunction
     * @return 
     */
    public static void InterpreterFunctiion(FunctionNode fnode, List<InterpreterDataType> dataType )
    {
    	
    	//call class 
    	//create hashMap string -> InterpreterDataType   - store variable
    	HashMap<String, InterpreterDataType> hashmap = new HashMap<String, InterpreterDataType>(); 
    	//HashMap<String, Integer> IntegerDataType;
	 
	
    	//add parameter to hashmap 
    	//HashMap<String,>
    	//hashmap.putAll(hashmap);
    	hashmap.put("begin", (InterpreterDataType) dataType);   // start to read 
    	hashmap.put("start", (InterpreterDataType) dataType);  //start to write
    	hashmap.put("end", (InterpreterDataType) dataType);   //end 
    	hashmap.put("var",(InterpreterDataType) dataType); 
    	
    	//Read,  Write,  squareRoot, IntToReal, RealToInt
    	hashmap.put("Read",(InterpreterDataType) dataType); 
    	hashmap.put("Write", (InterpreterDataType)dataType); 
    	hashmap.put("squareRoot", (InterpreterDataType)dataType);
    	hashmap.put("RealToInteger", (InterpreterDataType)dataType);
    	hashmap.put("IntegerToReal", (InterpreterDataType)dataType);
    	
    	InterpreterDataType a = null;
		hashmap.put("integer", a);
		InterpreterDataType c = null;
		hashmap.put("float", c); 
		InterpreterDataType b = null;
		hashmap.put("integer", b);
		hashmap.put("define", a); 
		
    	hashmap.put(":=", (InterpreterDataType) dataType);
    	
    	hashmap.put(Token.Type.Number.toString(),(InterpreterDataType) dataType );  //1,2,3,
    	hashmap.put(Token.Type.Var.toString(),(InterpreterDataType) dataType );  //a,b,c,
    	hashmap.put(Token.Type.String.toString(),(InterpreterDataType) dataType );  //var
    	hashmap.put(Token.Type.identifier.toString(),(InterpreterDataType) dataType );  //identifier ex def
    	
    	//add local variable to hashmaap 
    // map.put("Print", Token.Type.Print);
       
    	//call InterpeterBlock method 
    	 InterpreterBlock(sList, hashmap); 
    	//sList is List<StatementNode> 
    	
    	
    	HashMap<String, InterpreterDataType> map = new HashMap<>(); 
    	
    	for(InterpreterDataType data : dataType) {
    		
    		map.put(data.getName(), data); 
    	}
    //	InterpreterBlock(sList.subList(0, sList.size()), map); 
    	InterpreterBlock(sList, map);
    	
    }

    //take collection of statements and hashmap of variables 
    /**
     * Take collection of statements and hashmap of variables 
     * Interpreter the block 
     * @param statements
     * @param variables
     * @return List<String>
     */
    public static List<String>  InterpreterBlock(
    		List<StatementNode> statements, Map<String, InterpreterDataType> variables) {
    	
    	
    	//crate List<string>  to hold output
    	ArrayList<String> outputList = new ArrayList<>(); 
    	StringBuffer sb = new StringBuffer(); 
    	//append strings and put it into the outputList and return it later. 
    	
    	//for(StatementNode state : statements) {
    		for(int i = 0; i < statements.size(); i++) {
    			
    	//	String s1 = state.toString();
    			String s1 = statements.get(i).toString();
    			
    		if(s1.startsWith("begin") || s1.startsWith("start")) {
    			//check whehther they have read, write, squareroot, IntegerToReal, RealToInteger
    			
    			InterpreterDataType first = variables.get(Token.Type.Number.toString());
    			//InterpreterDataType first = variables.get(IF); //take int/float
				InterpreterDataType second = variables.get(Token.Type.Number.toString()); // take int/float
				float sum = 0;
				
				if ( (first == null)||(second == null)){
					throw new IllegalArgumentException("Unable to get two InterpreterDataType"); 
				}
				
    			if(s1.contains("read")) {
    				
					//begin read add 3,4 var c end  
    				if(s1.matches("read add") || s1.matches("read +")){	
    					//sum = a.getValue() + b.getValue();
    					//check dataType
    					if(first instanceof IntDataType && second instanceof IntDataType) {
    						//int + int 
    						IntDataType a = (IntDataType)first; 
    						IntDataType b = (IntDataType)second; //down casting 
    					//	int sum = 0; 
    						sum = a.getValue() + b.getValue();
    					}
    					//int + flaot , float + int, float + float
    					else{
    						//int + float or float + int  -> set a,b both as float
    						FloatDataType a = (FloatDataType)first;
    						FloatDataType b = (FloatDataType)second; 
    						sum = a.getValue() + b.getValue(); 
    						
    					}
    						if(s1.contains("var")) {
    							if(s1.contentEquals("c")) {
    								String output = "c = " + sum; 
    								
    								//check last index 
    	    						if(s1.endsWith("end")) {
    	    							sb.append("begin read add " + output + "end");
    	    						  //add to outputList x
    	    							//just print 
    	    							String last = sb.toString(); 
    	    							//System.out.println(last);
    	    							outputList.add(i, last);
    	    							//outputList.add(last);
    	    							/**
    	    							List<InterpreterDataType> d; 
    	    							InterpreterDataType dtype = ; 
    	    							
    	    							Read.Execute(sb); 
    	    							**/
    	    							
    	    						}
    							}
    						
    						else if(!s1.contains("var")) {
    							System.out.println("There is no var ,so this is can not be print out. "); 
    						}
    					}
    				}
    				else if(s1.matches("read minus") || s1.matches("read -")) {
    					
    					//check dataType 
    					if(first instanceof IntDataType && second instanceof IntDataType) {
    						//int - int
    						IntDataType a = (IntDataType)first; 
    						IntDataType b = (IntDataType)second; //downcasting 
    						sum = a.getValue() - b.getValue(); 
    					}else {
    						FloatDataType a = (FloatDataType)first;
    						FloatDataType b = (FloatDataType)second; 
    						sum = a.getValue() - b.getValue(); 
    					}
    					if(s1.contains("var")) {
    						if(s1.contentEquals("c")) {
								String output = "c = " + sum; 
								
								//check last index 
	    						if(s1.endsWith("end")) {
	    							sb.append("begin read minus " + output + "end");
	    						  //add to outputList x
	    							//just print 
	    							String last = sb.toString(); 
	    							//System.out.println(last);
	    							outputList.add(i, last);
	    							/**
	    							List<InterpreterDataType> d; 
	    							InterpreterDataType dtype = ; 
	    							
	    							Read.Execute(sb); 
	    							**/
	    							
	    						}
							}
						else if(!s1.contains("var")) {
							System.out.println("There is no var ,so this is can not be print out. "); 
						}
					}
    				}
    				else if(s1.matches("read Multiply") || s1.matches("read *")) {
    					//check dataType 
    					if(first instanceof IntDataType && second instanceof IntDataType) {
    						//int * int
    						IntDataType a = (IntDataType)first; 
    						IntDataType b = (IntDataType)second; //downcasting 
    						sum = a.getValue() * b.getValue(); 
    					}else {
    						FloatDataType a = (FloatDataType)first;
    						FloatDataType b = (FloatDataType)second; 
    						sum = a.getValue() * b.getValue(); 
    					}
    					if(s1.contains("var")) {
    						if(s1.contentEquals("c")) {
								String output = "c = " + sum; 
								
								//check last index 
	    						if(s1.endsWith("end")) {
	    							sb.append("begin read Multiply " + output + "end");
	    						  //add to outputList x
	    							//just print 
	    							String last = sb.toString(); 
	    							//System.out.println(last);
	    							outputList.add(i, last);
	    							/**
	    							List<InterpreterDataType> d; 
	    							InterpreterDataType dtype = ; 
	    							
	    							Read.Execute(sb); 
	    							**/
	    							
	    						}
							}
						else if(!s1.contains("var")) {
							System.out.println("There is no var ,so this is can not be print out. "); 
						}
					}
    				}//division
    				else if(s1.matches("read Divide") || s1.matches("read /")) {
    					//check dataType 
    					if(first instanceof IntDataType && second instanceof IntDataType) {
    						//int * int
    						IntDataType a = (IntDataType)first; 
    						IntDataType b = (IntDataType)second; //downcasting 
    						sum = a.getValue() / b.getValue(); 
    					}else {
    						FloatDataType a = (FloatDataType)first;
    						FloatDataType b = (FloatDataType)second; 
    						sum = a.getValue() / b.getValue(); 
    					}
    					if(s1.contains("var")) {
    						if(s1.contentEquals("c")) {
								String output = "c = " + sum; 
								
								//check last index 
	    						if(s1.endsWith("end")) {
	    							sb.append("begin read Divide " + output + "end");
	    						  //add to outputList x
	    							//just print 
	    							String last = sb.toString(); 
	    						//	System.out.println(last);
	    							outputList.add(i, last);
	    							/**
	    							List<InterpreterDataType> d; 
	    							InterpreterDataType dtype = ; 
	    							
	    							Read.Execute(sb); 
	    							**/
	    							
	    						}
							}
						else if(!s1.contains("var")) {
							System.out.println("There is no var ,so this is can not be print out. "); 
						}
					}
    				}
    			}
    			else if(s1.contains("write")) {
    				//begin write 3,4 var c end
    				//check dataType 
					if(first instanceof IntDataType && second instanceof IntDataType) {
						//int - int
						IntDataType a = (IntDataType)first; 
						IntDataType b = (IntDataType)second; //downcasting 
					
					}else {
						FloatDataType a = (FloatDataType)first;
						FloatDataType b = (FloatDataType)second; 
						
					}
					if(s1.contains("var")) {
						if(s1.contentEquals("c")) {
							String output = " var c " ; 
							
							//check last index 
    						if(s1.endsWith("end")) {
    							sb.append("begin write  " + output + "end"); // begin write 3,4 var  c end
    						  //add to outputList x
    							//just print 
    							String last = sb.toString(); 
    							//System.out.println(last);
    							outputList.add(i, last);
    							/**
    							List<InterpreterDataType> d; 
    							InterpreterDataType dtype = ; 
    							
    							Read.Execute(sb); 
    							**/
    							
    						}
						}
					else if(!s1.contains("var")) {
						System.out.println("There is no var ,so this is can not be print out. "); 
					}
				}
    			}
    			else if(s1.contains("squareroot")) {
    				//begin squareroot 4 var c end 
    				double SValue = 0;  //squre root value 
    				IntegerToReal integerToReal = new IntegerToReal(null); //call class IntergerToReal
    				
    				//check type 
    				if(first instanceof IntDataType) {
    					IntDataType a  = (IntDataType)first; //downcasting 
						float f = integerToReal.IntToReal(a);  //convert int to real value 
						double d = f; //float to double value to use Math.sqrt()
						SValue = Math.sqrt(d);
						
    				}
    				else if(first instanceof FloatDataType) {
    					FloatDataType a = (FloatDataType)first; //downcasting
    					float f = integerToReal.FloatToReal(a); //float -> float
    					double d = f; 
    					SValue = Math.sqrt(d); 
    					
    				}
    				if(s1.contains("var")) {
    					if(s1.contentEquals("c")) {
    						String output = "c = " + SValue;
    						
    						//check last index 
    						if(s1.endsWith("end")) {
    							sb.append("begin square root " + output + " end");
    							String last = sb.toString();
    							//System.out.println(last); 
    							outputList.add(i, last);
    						}
    					}
    					else if(!s1.contains("var")) {
    						System.out.println("There is no var, so this can not be printed");
    					}
    				}
    				
    			}
    			else if(s1.contains("IntegerToReal")) {
    				//begin IntegerToReal 3 var c end 
    				double IRvalue = 0;  //value after changing integer to the real. 
    				
    				//check dataType - if datatype is float then throw exception
    				if(first instanceof FloatDataType) {
    					System.out.println("This is float data Type. unable to conver to real"); 
    				}else if(first instanceof IntDataType) {
    					//int type -> able to use IntergerToReal
    					IntDataType a  = (IntDataType)first; //downcasting 
    					IntegerToReal integerToReal2 = new IntegerToReal(null);
						IRvalue = integerToReal2.IntToReal(a); 
    				}
    				if(s1.contains("var")) {
    					if(s1.contentEquals("c")) {
    						String output = "c = " + IRvalue ;
    						
    						//check last index 
    						if(s1.endsWith("end")) {
    							sb.append("begin IntegerToReal " + output + " end");
    							String last = sb.toString();
    							//System.out.println(last); 
    							outputList.add(i, last);
    						}
    					}
    					else if(!s1.contains("var")) {
    						System.out.println("There is no var, so this can not be printed");
    					}
    				}
    				
    			}
    			else if(s1.contains("RealToInteger")) {
    				// begin RealToInteger 4.2 var c end 
    				int RIValue = 0; //Real to integer value 
    				RealToInteger realToInteger = new RealToInteger(null);
    				//check dataType
    				if(first instanceof IntDataType) {
    					//alreay int so it deosn't have to be changed 
    					IntDataType a = (IntDataType)first; //downcasting 
    					RIValue = a.getValue(); 
    				}
    				else if(first instanceof FloatDataType) {
    					//need to be converted to int type 
    					FloatDataType a = (FloatDataType)first; //downcasting 
    					RIValue = 	realToInteger.RealToInt(a); 
    					
    				}
    				if(s1.contains("var")) {
    					if(s1.contentEquals("c")) {
    						String output = "c = " + RIValue ;
    						
    						//check last index 
    						if(s1.endsWith("end")) {
    							sb.append("begin RealToInteger" + output + " end");
    							String last = sb.toString();
    							//System.out.println(last); 
    							outputList.add(i, last);
    						}
    					}
    					else if(!s1.contains("var")) {
    						System.out.println("There is no var, so this can not be printed");
    					}
    				}
    			}//interpreter the boolean operatorsr < > <= >= 
    			else if(s1.contains(">")) {
    				//begin 23 > 4 end
    				FloatDataType a = (FloatDataType)first; 
    				FloatDataType b = (FloatDataType)second; 
    				
    				Float number1 = a.getValue() - b.getValue(); 
    				Float number2 = b.getValue() - a.getValue();  
    				//let s1 contains 2 numbers 
    				if(s1.contains((CharSequence) a) && s1.contains((CharSequence) b)) {
    					
    					if(s1.contains("var") && s1.contentEquals("c") && s1.endsWith("end")) {
    						
    						if(number1 >  0 && number2 < 0) {
        						//first value is bigger than second value 
        					//isTrue;
        						sb.append("begin " + a + " > " + b + " isTrue  end." ); 
        						String last = sb.toString();
    							//System.out.println(last); 
    							outputList.add(i, last);
        				      }else {
        				    	  //isFalse; 
        				    	  sb.append("begin " + a + " > " + b + " isFalse  end." ); 
        				    	  String last = sb.toString();
      							//System.out.println(last); 
      							outputList.add(i, last);
        				      }
    					}else if(!s1.contains("var")) {
    						System.out.println("There is no var, so this can not be printed");
    					}
    					
    				}
    					
    			}
    			else if(s1.contains("<")) {
    				//begin 2 < 4 end 
    				FloatDataType a = (FloatDataType)first; 
    				FloatDataType b = (FloatDataType)second; 
    				
    				Float number1 = a.getValue() - b.getValue();  
    				Float number2 = b.getValue() - a.getValue();  
    				
    				//let s1 contains 2 numbers 
    				if(s1.contains((CharSequence) a) && s1.contains((CharSequence) b)) {
    					
    					if(s1.contains("var") && s1.contentEquals("c") && s1.endsWith("end")) {
    						
    						if(number1 >  0 && number2 < 0) {
        						//first value is bigger than second value 
        					//isFlase;
        						sb.append("begin " + a + " < " + b + " isFalse  end." ); 
        						String last = sb.toString();
    							//System.out.println(last); 
    							outputList.add(i, last);
        				      }else {
        				    	  //isTrue; 
        				    	  sb.append("begin " + a + " < " + b + " isTrue  end." ); 
        				    	  String last = sb.toString();
      							//System.out.println(last); 
      							outputList.add(i, last);
        				      }
    					}else if(!s1.contains("var")) {
    						System.out.println("There is no var, so this can not be printed");
    					}
    					
    				}
    			}
    			else if(s1.contains("<=")) {
    				//begin 3 <= 3 end 
    				//beign 3 <= 5 end 
    				FloatDataType a = (FloatDataType)first; 
    				FloatDataType b = (FloatDataType)second; 
    				
    				Float number1 = a.getValue() - b.getValue();   //4 <= 3 
    				Float number2 = b.getValue() - a.getValue();  
    				
    				//let s1 contains 2 numbers 
    				if(s1.contains((CharSequence) a) && s1.contains((CharSequence) b)) {
    					
    					if(s1.contains("var") && s1.contentEquals("c") && s1.endsWith("end")) {
    						
    						if((number1  <  0 && number2 >= 0) || ( a == b)) {
        						//second value is bigger than first one 
        					//isTrue;
        						sb.append("begin " + a + " <= " + b + " isTrue  end." ); 
        						String last = sb.toString();
    							//System.out.println(last); 
    							outputList.add(i, last);
        				      } else {
    						    	//isFlase;
            						sb.append("begin " + a + " <= " + b + " isFalse  end." ); 
            						String last = sb.toString();
        							//System.out.println(last); 
        							outputList.add(i, last);
    						    }
    						
    					}else if(!s1.contains("var")) {
    						System.out.println("There is no var, so this can not be printed");
    					}
    					
    				}
    			}
    			//
    			else if(s1.contains(">=")) {
    				//begin 3 >= 3 end 
    				//begin 5 >= 3 end 
    				FloatDataType a = (FloatDataType)first; 
    				FloatDataType b = (FloatDataType)second; 
    				
    				Float number1 = a.getValue() - b.getValue();   //4 <= 3 
    				Float number2 = b.getValue() - a.getValue();  
    				
    				//let s1 contains 2 numbers 
    				if(s1.contains((CharSequence) a) && s1.contains((CharSequence) b)) {
    					
    					if(s1.contains("var") && s1.contentEquals("c") && s1.endsWith("end")) {
    						
    						if( ( number1  >=  0 && number2 < 0 ) || (a == b)) {
        						//First is bigger than second 
        					//isFlase;
        						sb.append("begin " + a + " >= " + b + " isTrue  end." ); 
        						String last = sb.toString();
    							//System.out.println(last); 
    							outputList.add(i, last);
        				      }
    						    else {
    						    	//isFlase;
            						sb.append("begin " + a + " >= " + b + " isFalse  end." ); 
            						String last = sb.toString();
        							//System.out.println(last); 
        							outputList.add(i, last);
    						    }
    						
    					}else if(!s1.contains("var")) {
    						System.out.println("There is no var, so this can not be printed");
    					}
    					
    				}
    			}
    			
    		}
    	}
    	return outputList;  //calculated value is inside the arrylists<String> 
    }
    
//create sb and list for the EvaluateBooleanExpression method and whileRepeatIfExpression method 
    
	static StringBuffer sb = new StringBuffer(); 
	static ArrayList<String> list = new ArrayList<String>(); 
	
    /**
     * EvaluateBoolean Expression 
     * This method will check wehther this boolean expression has to solve int value or float value. 
     */
    public static boolean BooleanExpression(List<StatementNode> statements) {
    	
    	//for(int i = 0; i < statements.size(); i++) {
    		StatementNode sNode = statements.get(0); 
    		String s1 = sNode.toString(); 
    		
    		//initivalize 2 values from interpreterdata type 
    		InterpreterDataType first = null; 
    		InterpreterDataType second = null; 
    		IntegerToReal integerToReal = new IntegerToReal(null);
    		
    		//set float value 
    		float f1 = 0;
    		float f2 = 0; 
    		
    		//check specific data type - float or int
    		//case int ?Type
    		if(first instanceof IntDataType) {
    			//down casting 
    			IntDataType a = (IntDataType)first; 
    			 f1 = integerToReal.IntToReal(a);  //convert int to real(float)  value 
    			
    			if(second instanceof IntDataType) {
    				//convert second int to float value 
    				IntDataType b = (IntDataType)second;
    				f2 = integerToReal.IntToReal(b); 
    			}else if(second instanceof FloatDataType) {
    				// don't convert 
    				FloatDataType b = (FloatDataType)second;
    				f2 = b.getValue(); 
    			}
    			
    		}//case float ?Type
    		else if(first instanceof FloatDataType) {
    			FloatDataType a = (FloatDataType)first; 
    			f1 = a.getValue(); 
    			if(second instanceof FloatDataType) {
    				//dont need to be convert
    				FloatDataType b = (FloatDataType)second;
    				f2 = b.getValue(); 
    			}else if(second instanceof IntDataType) {
    				IntDataType b = (IntDataType)second; 
    				f2 = integerToReal.IntToReal(b);
    				
    			}
    		}
    		
    		float num1 = f1 - f2; 
    		float num2 = f2 - f1; 
    		
    		//list sb
    		
    		//handle the boolean expression
    		if(s1.contains(">")) {
    			if(num1 >= 0 && num2 < 0) {
    				sb.append(f1 + " > " +f2); 
    				String result = sb.toString(); 
    				list.add(result);
    	
    				return true;  
    				//first number is bigger than second 
    				// 3 > 5
    			}else {
    				return false;
    			}
    		}
    		else if(s1.contains(">=")) {
    			if((num1 >= 0 && num2 <0) || ( f1 == f2) ){
    				sb.append(f1 + " >= " +f2); 
    				String result = sb.toString(); 
    				list.add(result);
    				return true; 
    			}else {
    				return false; 
    			}
    		}
    		else if(s1.contains("<")) {
    			if(num1 < 0 && num2 >= 0) {
    				sb.append(f1 + " < " +f2); 
    				String result = sb.toString(); 
    				list.add(result);
    				return true;
    				//second number is bigger than first
    				// 2 < 6
    			}else {
    				return false; 
    			}
    		}
    		else if(s1.contains("<=")) {
    			if((num1 <0 && num2 >= 0 ) || ( f1 == f2)) {
    				sb.append(f1 + " <= " +f2); 
    				String result = sb.toString(); 
    				list.add(result);
    				return true;
    			}else {
    				return false; 
    			}
    		}
			return true;
    		
    	//}
	
    }
    static ArrayList<String> listForLoop = new ArrayList<String>(list); //use list from booleanexpression method
	private static String input;
	
    /**
     * This method will deal with while, repeat, if loops. 
     * If the statement start with while, check boolean contion 
     * by using EvaluateBooleanExpression method. if boolean contion is true, then
     * put it into arraylist<String>. 
     * 
     * @param statements
     */
    //implment while,reap, if 
    public static ArrayList<String> whileRepeatIfExpression(List<StatementNode> statements) {
    	//while( 23 > 3) 
    	//if condition is true then continous or print
    	//if condition is false then print error 
    	
    	StringBuffer sb = new StringBuffer(); 
    	//ArrayList<String> listForLoop = new ArrayList<String>(list); //use list from booleanexpression method
    	
    	for(int i =0; i < statements.size(); i++) {
    		StatementNode sNode = statements.get(i); 
    		String s1 = sNode.toString(); 
    		
    		String message = Token.Type.String.toString();
    		
			if(s1.startsWith("While(") && s1.endsWith(")")) {
    			//while( 23 > 3) 
				// this is while loop -> check the condition 
    			if(s1.contains(">") || s1.contains("<") ||s1.contains(">=")
    					||s1.contains("<=")) {
    				//call EvaluateBooleanExpression 
    				if(BooleanExpression(statements) == true) {
    					//StatementNode s2Node = sNode.next; 
    					sb.append("While(" + list + ")");  // list will contain 23 > 3
    					String result = sb.toString(); 
    					listForLoop.add(result); 
    				}else {
    					break; 
    					
    				}
    			}
    		}
    		
    		else if(s1.startsWith("If(" )&& s1.endsWith(")")){
    			//this is if looop -> check the condition 
    			//ex) if (3<5)
    			if(s1.contains(">") || s1.contains("<") ||s1.contains(">=")
    					||s1.contains("<=")) {
    				//call EvaluateBooleanExpression 
    				if(BooleanExpression(statements) == true) {
    					//StatementNode s2Node = sNode.next; 
    					sb.append("If(" + list + ")"); 
    					String result = sb.toString();
    					listForLoop.add(result); 
    					
    				}else {
    					break; 
    					
    				}
    			}
    		}//else block 
    		else if(s1.contains("else if(") && s1.endsWith(")")) {
    			//else if(3 > 1)
    			if(s1.contains(">") || s1.contains("<") ||s1.contains(">=")
    					||s1.contains("<=")) {
    				//call EvaluateBooleanExpression 
    				if(BooleanExpression(statements) == true) {
    					//StatementNode s2Node = sNode.next; 
    					sb.append("If(" + list + ")"); 
    					String result = sb.toString();
    					listForLoop.add(result); 
    					
    				}else {
    					break; 
    					
    				}
    			}
    		}
    		//else block 
    		else if(s1.contains("else{") && s1.contains(message) && s1.endsWith("}")) {
    			String result; 
    		//	String message = Token.Type.String.toString();
    			// else { printThisValue}
    			sb.append("else{ " + message + "}"); 
    			result = sb.toString();
    			listForLoop.add(result); 
    		}
    		//For loop 
    		else if(s1.startsWith("For(") && s1.endsWith(")")) {
    			
				//repeat it 
    			//ex ) for( int i=0; i < 5; i++) Let integer number 5 be a number
    			/**
    			 * for(int i =0; i <5; i++){ string input}; 
    			 */
    			InterpreterDataType first = null;
    			int intValue = 0; 
    			
    			IntDataType a = (IntDataType)first; //downcasting
    			intValue = a.getValue(); 
    			String number = Integer.toString(intValue); //convert int -> string
    			String result;
    			String input = Token.Type.String.toString();
    			
				if(s1.contains("int i=0;")&& s1.contains(" i< ") && s1.matches(number)) {
					if(s1.contains("; i++") && s1.contains(input)) {
						 // 0 1 2 3 4 
					String s =	repeat(intValue, input); //if input is a then return aaaaa
					sb.append("For(int i=0; i< " + number + "; i++" + s); 
					 result = sb.toString(); 
					 listForLoop.add(result); 
						
					}
					else if(s1.contains("i--")) {
						// int i =0 ; i < 5; i-- -> invaild 
						System.out.println("invalid"); 
					}
    			}
				//ex) for(int i=5; i >0; i--)
				else if(s1.contains("int i =")&&s1.matches(number) && s1.contains("; i>0")) {
					if(s1.contains("; i--") && s1.contains(input)) {
						//5 4 3 2 1 
						//repeat(intValue);
						String s = repeat(intValue, input); 
						sb.append("For( int i =" + number + "; i>0 ;i--" + s);
						 result = sb.toString(); 
						 listForLoop.add(result); 
					}
					else if(s1.contains("i++")) {
						System.out.println("invalid"); 
					}
				}
				
				
    		}//repeat block 
    		else if(s1.contains("Repeat")) {
    			InterpreterDataType first = null;
    			int intValue = 0; 
    			
    			IntDataType a = (IntDataType)first; //downcasting
    			intValue = a.getValue(); 
    			String number = Integer.toString(intValue); //convert int -> string
                String input = Token.Type.String.toString();
    			
    			//repeat 5 times a; 
    			if(s1.matches(number) && s1.contains("times") 
    					&& s1.contains(input)) {
    				String s = repeat(intValue, input);
    				sb.append("Repeat " + intValue + " times" + s);
    				String result = sb.toString(); 
    				 listForLoop.add(result); 
    			}
    			else {
    				System.out.println("invalid"); 
    			}
    		}
    	}
    	return  listForLoop; 
    }
/**
 * This method will repeat the String input as much as int num and return string. 
 * @param num
 * @param input
 * @return String 
 */
	private static String repeat(int num, String input) {
	
		
		//ArrayList<String> list = new ArrayList<String>();
		//if input is 5times a  then print aaaaa 
		ArrayList<String> inputs = new ArrayList<String>(); 
	   for(int i = 0; i< num; i++) {
		//   list.add(); 
		   inputs.add(input); //aaaaa
	   }
	return inputs.toString(); 
	}

	/**
	 * This method will resolve expression that contains boolean expression. 
	 * 
	 * @param statements
	 * @return ArrayList<String>
	 */
	//create ResolveBoolean, ResolveString, ResolveCharacter methos 
	 public static ArrayList<String> ResolveBooleanExpression(List<StatementNode> statements) {
		 
		 StringBuffer sb = new StringBuffer(); 
	    	ArrayList<String> listForExpressions = new ArrayList<String>(list); //use list from booleanexpression method
	    	
	    	for(int i =0; i < statements.size(); i++) {
	    		StatementNode sNode = statements.get(i); 
	    		String s1 = sNode.toString(); 
	    		
	    	   input = Token.Type.String.toString();
	    		
	    		//initialize 
	    		InterpreterDataType first = null;
	    		float number = 0;
	    		
	    		//check data type whether it is integer or float 
	    		if(first instanceof IntDataType) {
	    			IntDataType a = (IntDataType)first; // down casting 
	    			number = a.getValue(); 
	    		}
	    		else if(first instanceof FloatDataType) {
	    			FloatDataType a = (FloatDataType)first; // down casting 
	    			number = a.getValue(); 
	    		}
	    		
	    		String num = String.valueOf(number);  //convert float type number to string 
	    		
	    		
	    		// if (a >0) then a = a+1, else a =a-1.
				if(s1.startsWith("if(") && s1.endsWith(",")) {
					//check the condition (a >0)
	    			if(s1.contains(">") || s1.contains("<") ||s1.contains(">=")||s1.contains("<=")) {
	    				//call EvaluateBooleanExpression 
	    				if(BooleanExpression(statements) == true) {
	    					//StatementNode s2Node = sNode.next; 
	    					sb.append("if(" + list + ")");  // list will contain 23 > 3
	    					String result = sb.toString(); 
	    					listForExpressions.add(result); 
	    					if(s1.contains("then") && s1.contains("var")) {
	    						//a = a+1
	    						if(s1.contentEquals("a = a") && s1.contains(num) ){
	    							//check math operation + - * / 
	    							if(s1.contains("+")) {
	    								//case then a = a+1; 
	    								String output = "then a = a" + "+" + number;  
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    								// so far this listForExpression has if(a>0)then a = a + 1
	    								
	    							}
	    							else if(s1.contains("-")) {
	    								//case then a = a-1; 
	    								String output = "then a = a" + "-" + number; 
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    							}
	    							else if(s1.contains("*")) {
	    								//case then a = a *1
	    								String output = "then a = a" + "*" + number;
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    							}
	    							else if(s1.contains("/")) {
	    								//case then a = a/1
	    								String output = "then a = a" + "/" + number; 
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    							}
	    						}
	    				}else {
	    					// if statment boolean expression is wrong -> go to the else  state ment 
	    				//print out else statement 
	    					// else a = a -1; 
	    			 if(s1.contains("else") && s1.contains("var")) {
	    				 if(s1.contentEquals("a = a") && s1.contains(num) ){
	    					//check math operation + - * / 
 							if(s1.contains("+")) {
 								//case a = a+1; 
 								String output = "a = a" + "+" + number;  
 								String ifstatementResult = sb.append(output).toString();
 								listForExpressions.add(ifstatementResult); 
 								// so far this listForExpression has if(a>0)then a = a + 1
 								
 							}
 							else if(s1.contains("-")) {
 								//case  a = a-1; 
 								String output = "a = a" + "-" + number; 
 								String ifstatementResult = sb.append(output).toString();
 								listForExpressions.add(ifstatementResult); 
 							}
 							else if(s1.contains("*")) {
 								//case  a = a *1
 								String output = "a = a" + "*" + number;
 								String ifstatementResult = sb.append(output).toString();
 								listForExpressions.add(ifstatementResult); 
 							}
 							else if(s1.contains("/")) {
 								//case  a = a/1
 								String output = "a = a" + "/" + number; 
 								String ifstatementResult = sb.append(output).toString();
 								listForExpressions.add(ifstatementResult); 
 							}
	    				}
	    			 }
	    					
	    				}
	    			 if(s1.endsWith(".")) {
	    				 //if you see . this is end of string so end 
	    				 System.out.println("THis is end of input"); 
	    				 break; 
	    			 }	 
	    			 
	    			}
	    		}
				}
				//While(a>0) then a = a+1. 
				if(s1.contains("While(") && s1.endsWith(".")) {
					//check boolean condition 
					if(s1.contains(">") || s1.contains("<") ||s1.contains(">=")||s1.contains("<=")) {
	    				//call EvaluateBooleanExpression 
	    				if(BooleanExpression(statements) == true) {
	    					sb.append("While(" + list + ")");  // list will contain a >0 
	    					String result = sb.toString(); 
	    					listForExpressions.add(result); 
	    					if(s1.contains("then") && s1.contains("var")) {
	    						//a = a+1
	    						if(s1.contentEquals("a = a") && s1.contains(num) ){
	    							//check math operation + - * / 
	    							if(s1.contains("+")) {
	    								//case then a = a+1; 
	    								String output = "then a = a" + "+" + number +".";  
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    								// so far this listForExpression has if(a>0)then a = a + 1.
	    								
	    							}
	    							else if(s1.contains("-")) {
	    								//case then a = a-1; 
	    								String output = "then a = a" + "-" + number +"."; 
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    							}
	    							else if(s1.contains("*")) {
	    								//case then a = a *1
	    								String output = "then a = a" + "*" + number +"."; 
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    							}
	    							else if(s1.contains("/")) {
	    								//case then a = a/1
	    								String output = "then a = a" + "/" + number +"."; 
	    								String ifstatementResult = sb.append(output).toString();
	    								listForExpressions.add(ifstatementResult); 
	    							}
	    						}
	    					}
	    				}
	    					
	    				}
				}
				//for (int i =0; i >4; i++)then a = a+1. 
				if(s1.startsWith("for(") && s1.endsWith(".")){
					if(s1.contains("int i = ;")) {
						input = listForLoop.toString(); 
					 	sb.append("for(" + listForLoop.toString() +"."); //for(int i = 0; i <4; i++) 
					 	String ouput = sb.toString(); 
					 	listForExpressions.add(ouput);
					 	if(s1.contains("then") && s1.contains("var")) {
					 		if(s1.contains("a =a")&& s1.contains(num)) {
					 			//check math operation + - * / 
    							if(s1.contains("+")) {
    								//case then a = a+1; 
    								String output = "then a = a" + "+" + number +".";  
    								String forResult = sb.append(output).toString();
    								listForExpressions.add(forResult); 
    								// so far this listForExpression has for(int i =0; i >4; i++)then a =a+1.
    								
    							}
    							else if(s1.contains("-")) {
    								//case then a = a-1; 
    								String output = "then a = a" + "-" + number +"."; 
    								String forResult = sb.append(output).toString();
    								listForExpressions.add(forResult); 
    							}
    							else if(s1.contains("*")) {
    								//case then a = a *1
    								String output = "then a = a" + "*" + number +"."; 
    								String forResult = sb.append(output).toString();
    								listForExpressions.add(forResult); 
    							}
    							else if(s1.contains("/")) {
    								//case then a = a/1
    								String output = "then a = a" + "/" + number +"."; 
    								String forResult = sb.append(output).toString();
    								listForExpressions.add(forResult); 
    							}
					 		}
					 	}
						
					}
				}
				//while(a >= 3)then a = a+1. 
				if(s1.contains("while(") && s1.endsWith(".")) {
					//check boolean condition 
					if(s1.contains(">") || s1.contains("<") ||s1.contains(">=")||s1.contains("<=")) {
	    				//call EvaluateBooleanExpression 
	    				if(BooleanExpression(statements) == true) {
	    					sb.append("While(" + list + ")");  // list will contain a >0 
	    					String result = sb.toString(); 
	    					listForExpressions.add(result); 
	    					if(s1.contains("then") && s1.contains("var")) {
	    						//a = a+1
	    						if(s1.contentEquals("a = a") && s1.contains(num) ){
	    							
	    							//check math operation + - * / 
	    							if(s1.contains("+")) {
	    								//case then a = a+1; 
	    								String output = "then a = a" + "+" + number +".";  
	    								String wResult = sb.append(output).toString();
	    								listForExpressions.add(wResult); 
	    								// so far this listForExpression has while(int i =0; i >4; i++)then a =a+1.
	    								
	    							}
	    							else if(s1.contains("-")) {
	    								//case then a = a-1; 
	    								String output = "then a = a" + "-" + number +"."; 
	    								String wResult = sb.append(output).toString();
	    								listForExpressions.add(wResult);
	    							}
	    							else if(s1.contains("*")) {
	    								//case then a = a *1
	    								String output = "then a = a" + "*" + number +"."; 
	    								String wResult = sb.append(output).toString();
	    								listForExpressions.add(wResult);
	    							}
	    							else if(s1.contains("/")) {
	    								//case then a = a/1
	    								String output = "then a = a" + "/" + number +"."; 
	    								String wResult = sb.append(output).toString();
	    								listForExpressions.add(wResult); 
	    							}
	    						}
	    					}
	    				}
					}
				}
	    	}
	    	return listForExpressions; 
	 }
	    	 
	    	
	 /**
	  * This method will ResolveStirng and character expression 
	  * 
	  */
         public static ArrayList<String> ResolveStringAndCharExpression(List<StatementNode> statements) {
        	 // string = "hi2;"
        	 //sting a = "hi";
        	 //char c  = 'n';
        	 //char c = '3'
        	 
        	// StringBuffer sb = new StringBuffer(); 
 	    	ArrayList<String> Elist = new ArrayList<String>(list); //use list from booleanexpression method
 	    	
 	    	for(int i =0; i < statements.size(); i++) {
 	    		StatementNode sNode = statements.get(i); 
 	    		String s1 = sNode.toString(); 
 	    		
 	    	   input = Token.Type.String.toString();
 	    		
 	    		//initialize 
 	    		InterpreterDataType first = null;
 	    		float number = 0;
 	    		
 	    		//check data type whether it is integer or float 
 	    		if(first instanceof IntDataType) {
 	    			IntDataType a = (IntDataType)first; // down casting 
 	    			number = a.getValue(); 
 	    		}
 	    		else if(first instanceof FloatDataType) {
 	    			FloatDataType a = (FloatDataType)first; // down casting 
 	    			number = a.getValue(); 
 	    		}
 	    		
 	    		String num = String.valueOf(number);  //convert float type number to string 
 	    		
 	    	   //initliaze 
 	    		String stringInput = Token.Type.String.toString(); //hi
 	    		String doublequoate = Token.Type.Doublequote.toString(); 
 	    		String charInput = Token.Type.Char.toString();
 				String singlequoate = Token.Type.Singlequote.toString(); 
 			// String = "hi"
 				if(s1.startsWith("String = ") && s1.contains(doublequoate)) {
 						if(s1.contains(stringInput)) {
 							String output = sb.append("String =  " + stringInput ).toString(); 
 							Elist.add(output); 
 						}
 				}
 				//case Char = 'c'
 				else if(s1.startsWith("Char = ") && s1.contains(singlequoate)) {
 					if(s1.contains(charInput)) {
 						String ouput = sb.append("Char = " + charInput).toString(); 
 						Elist.add(ouput); 
 					}
 				}
 				
 				}
        	 
			return Elist;
        	 
         }
}


