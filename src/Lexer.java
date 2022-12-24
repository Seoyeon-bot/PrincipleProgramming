import java.util.*;
 
/*
 * make list of token
 */
 public class Lexer{
	
	 /**
	  * Declare enum types. 
	  * @author choeseoyeon
	  *
	  */
	 //add Var in Lexer
	 public enum states
	    {
	        SPACE, WHOLENUMBER, OPERATE, DECLARE, PAREN, STRING, CHAR,
	        WORD, LABEL, DECIMAL, PRINT,Var, REVERSE, BOOLEANEXPRESSION, Quote;
	        //booleanexpression is fr true/ false
	    }
	private static char c;
	 
	   
	 /**
	  * check whether token type is valid input or not 
	  * @param Type
	  * @return boolean 
	  */
	    public static boolean checkValue(Token.Type t) {
	        switch(t)
	            {         
	                case Number:
	                case String:
	                case Char:
	                case identifier:
	                case Doublequote:
	                case Singlequote:
	                case BooleanExpression:
	                case label:
	          
	                    return true;
	                default:
	                    return false;    //for invalid input type. 
	            }
	        }
	    /**
	     * This method will check whether the character value is vaild or invaild input. 
	     * @param state
	     * @param c
	     * @return boolean 
	     */
	    public static boolean checkChar(states state, char c) {
	    	
	    	if (c == '.' && state == states.DECIMAL) {
	        	return false;
	    	
	    	}else if (c == ':' || c == '$' || c == '%') {
	        
	            if (state == states.WORD || state == states.STRING || state == states.CHAR
	            		|| state == states.Quote || state == states.BOOLEANEXPRESSION)
	            	return true;
	            else 
	            	return false;
	        }else {
	        	return true;
	        } 	
	    }
	    
	    //looks at the current character and returns an associated state to change into
	    /**
	     * This method will return specific state enum type based on character  value. 
	     * @param c
	     * @return states
	     * @throws Exception
	     */
	    public static states getState(char c) throws Exception {
	    	
	    
	    	 if (Character.isDigit(c)) 
		        	return states.WHOLENUMBER;
	    	 else if(isSingleQuote(c))
	    		 return states.Quote;
	    	 else if(isDoubleQuote(c))
	    		 return states.Quote;
	    	 else if(isTrue(c) || isFalse(c))
	    		 return states.BOOLEANEXPRESSION;
	    	 else if (Character.isLetter(c))
	    		// if(c == 'V') {
	    		//	 return states.Var; 
	    		// }
	    		// else
	    		 return states.WORD;
	    	 
	    	 switch(c) {
	    	 case '.':
	    		 return states.WHOLENUMBER;
	    	 case'$':
	    		 return states.WORD;
	    	 case'%':
	    		 return states.WORD;
	    	 case'+':
	    		 return states.OPERATE;
	    	 case'-':
	    		 return states.OPERATE;
	    	 case'*':
	    		 return states.OPERATE;
	    	 case'/':
	    		 return states.OPERATE;
	    	 case'=':
	    		 return states.DECLARE;
	    	 case'<':
	    		 return states.DECLARE;
	    	 case'>':
	    		 return states.DECLARE;
	    	 case'(':
	    		 return states.PAREN;
	    	 case')':
	    		 return states.PAREN;
	    	 case'"':
	    		 return states.STRING;
	    	 case'c':
	    		 return states.CHAR;
	    	 case':':
	    		 return states.LABEL;
	    	 case' ':
	    		 return states.SPACE;
	    	 case'\t':
	    		 return states.SPACE;
	    	case't':
	    		 return states.BOOLEANEXPRESSION;   //add boolean expression types 
	    	 case'f':
	    		 return states.BOOLEANEXPRESSION;
	    		
	    	 case',':
	    		 return states.PRINT;
	    		 default:
	    			 throw new Exception("Invaild");
	    	 }
	    }
	   /**
	    * check whether char is digit or not  
	    * @param c
	    * @return boolean 
	    */
	    private boolean isDigit(char c) {
	    	return (c >= '0' && c <= '9'); 
	    }
	    
	    /**
	     * check whether char c is quote or not 
	     * 
	     */
	    private static boolean isSingleQuote(char c) {
	    	return (c == '\'' );
	    }
	    private static boolean isDoubleQuote(char c) {
	    	return (c == '\"' );
	    }
	    /**check whether cahr c is boolean expression true or false 
	     * 
	     */
	    private static boolean isTrue(char c) {
	    	return (c == 't'); 
	    }
	    private static boolean isFalse(char c) {
	    	return (c == 'f');
	    }
	    /**
	     * This method will compare character value and 
	     * get the specific token type from the Token class. 
	     * @param c
	     * @return
	     * @throws Exception
	     */
	    public static Token.Type getType(char c) throws Exception {
	    	
	        if (Character.isDigit(c) || c == '.') 
	        	return Token.Type.Number;
	        else if(isSingleQuote(c))
	        	return Token.Type.Singlequote;   //add quote 
	        else if(isDoubleQuote(c))
	        	return Token.Type.Doublequote;
	        else if(isTrue(c))
	        	return Token.Type.True;   //add boolean expression
	        else if(isFalse(c))
	        	return Token.Type.False;
	        else if (Character.isLetter(c)) {
	        	
	        	char c1 = 0 ;
	        	if(c == 'S' && c1 == 't') { //String
	        		return Token.Type.String; 
	        	}else if(c == 'C' && c1 == 'h') { //Char
	        		return Token.Type.Char; 
	        	}else {
	        		return Token.Type.identifier;
	        	}
	        
	        }
	        	
	        
	        switch(c) {
	       // case 't':
	      //  	return Token.Type.True;
	      //  case 'f':
	      //  	return Token.Type.False; 
	        case '$':
	        	return Token.Type.identifier;
	        case'%':
	        	return Token.Type.identifier;
	        case '+':
	        	return Token.Type.Plus;
	        case'-':
	        	return Token.Type.Minus;
	        case'*':
	        	return Token.Type.Multiply; 
	        case'/':
	        	return Token.Type.Divide;
	        case'=':
	        	return Token.Type.equal;
	        case'<':
	        	return Token.Type.LESSTHAN;
	        case'>':
	        	return Token.Type.GREATERTHAN;
	        case'(':
	        	return Token.Type.Lparen;
	        case')':
	        	return Token.Type.Rparen;
	        case'"':
	        	return Token.Type.String;
	        case'c':
	            return Token.Type.Char;
	        case':':
	        	return Token.Type.label;
	        case' ':
	        	return Token.Type.SPACE;
	        case'\t':
	        	return Token.Type.SPACE;
	        case'V':
	        	return Token.Type.Var;
	        case',':
	        	return Token.Type.Comma;
	        	default:
	        		throw new Exception("invaild input"); 
	        	
	        }
	        
	    }
	    /**
	     * This method will check token type and value and will store values in  List<Token>
	     * @param s
	     * @return List<Token>
	     * @throws Exception
	     */
	    public static List<Token> lex(String s) throws Exception{
	    	//create hashmap
	        HashMap<String, Token.Type> map = new HashMap<String, Token.Type>();
	        
	        //match string and token.type and put it into the HashMap 
	        map.put("Print", Token.Type.Print);
	        map.put("Input", Token.Type.Input);
	        map.put("Read", Token.Type.Read);
	        map.put("For", Token.Type.FOR);
	        map.put("To", Token.Type.TO);
	        map.put("Next", Token.Type.NEXT);
	        map.put("Step", Token.Type.STEP);
	        map.put("Return", Token.Type.RETURN);
	        map.put("RANDOM", Token.Type.RANDOM);
	        map.put("MAX", Token.Type.MAX);
	        map.put("MINIMUN", Token.Type.MINIMUN);
	        map.put("RIGHT", Token.Type.RIGHT);
	        map.put("LEFT", Token.Type.LEFT);
	        map.put("VAL", Token.Type.VAL);
	        map.put("VAL2", Token.Type.VAL2);
	        map.put("If", Token.Type.IF);
	        map.put("then", Token.Type.THEN);
	        map.put("Var", Token.Type.Var);
	        map.put("Reverse", Token.Type.Reverse);
	       //add boolean expression 
	        map.put("True", Token.Type.True); 
	        map.put("False", Token.Type.False); 
          //add char string type 
	        map.put("String", Token.Type.String);
	        map.put("Char", Token.Type.Char); 
	        //add double quote and singel quote 
	        map.put("\"Doublequote\"", Token.Type.Doublequote);
	       // map.put("/"", Token.Type.Doublequate);
	        map.put("/'", Token.Type.Singlequote);
	       
	        
	       //set basic state as space  
	        states state = states.SPACE;
	        List<Token> list = new ArrayList<>(); //list to hold tokens
	        
	        //recursively 
	        for (int i = 0; i <= s.length(); i++)
	        {
	            char c;
	            //if i is within s.length 
	            if (i < s.length()) { 
	            	   c = s.charAt(i);
	            }else {
	            	c = ' '; //extra space
	            }
	            
	            //check specific char value c with state 
	            if (checkChar(state, c))
	            {
	            	//space after the input String s. 
	                if ((i > s.length()) && (state != states.STRING) && (getState(c) == states.SPACE))
	                {
	                    state = states.SPACE; //set state to space
	                    continue; 
	                }
	                
	                Token.Type cType = getType(c); 
	                
	                
	                switch(state)
	                { 
	                    case SPACE: 
	                    case PAREN:
	                    case LABEL:
	                    case PRINT:
	                    case Quote:
	                   case BOOLEANEXPRESSION:
	                    case Var:
	                    	
	                        state = getState(c); //get state type. 
	
	                        if (checkValue(cType) && c != '"') 
	                        	list.add(new Token(cType , c));
	                        else 
	                        	list.add(new Token(cType));
	                        break;
	                        
	                    case OPERATE:
	                        state = getState(c);
	                        char c2 = s.charAt(i+1); 
	                        
	                        //case - , number
	                        if (c == '-' && i<s.length() && 
	                        		(getState(c2)) == states.WHOLENUMBER || getState(c2) == states.DECIMAL)
	                        {
	                        	list.add(new Token(Token.Type.Number, '-')); 
	                            state = getState(c2);
	                        }
	                        else 
	                        {
	                            if (checkValue(cType ) && c != '"')
	                            	list.add(new Token(cType , c));
	                            else 
	                            	list.add(new Token(getType(c)));
	                        }
	                        break;
	                        
	                    case DECIMAL: 
	                        state = getState(c);
	                        //Whole Number case
	                        if (state == states.WHOLENUMBER) 
	                        {
	                        	String s1 = Character.toString(c); 
	                        	list.get(list.size()-1).changeValue(s1);
	                            state = states.DECIMAL;
	                        }
	                        else
	                        {
	                            if (list.get(list.size()-1).getTokenValue().equals(".")) 
	                            	throw new Exception("Invaild input");
	                            if (checkValue(getType(c)) && c != '"')  //String type 
	                            	list.add(new Token(getType(c), c));
	                            else 
	                            	list.add(new Token(getType(c)));
	                        }
	                        break; 
	                        
	                        //For numbers
	                    case WHOLENUMBER: 
	                        state = getState(c);
	                        String s1 = Character.toString(c);
	                        if (state == states.WHOLENUMBER || state == states.DECIMAL) 
	                        	list.get(list.size()-1).changeValue(s1); 
	                        else 
	                        {
	                            if (checkValue(cType ) && c != '"') 
	                            	list.add(new Token(cType , c));
	                            else 
	                            	list.add(new Token(getType(c)));
	                        }
	                        break;
	                       
	                        //For declartion, such as < > <= >= 
	                    case DECLARE: 
	                        state = getState(c);
	                       char c0 = s.charAt(i-1);   // c0 , c , c2 
	                        
	                        if (state == states.DECLARE)
	                        {    
	                            if (c0 == '<' && c == '>') // <>
	                            	list.get(list.size()-1).NewTokenType(Token.Type.NOTEQUALS);
	                            else if (c0 == '<' && c == '=') //<=
                                    list.get(list.size()-1).NewTokenType(Token.Type.LESSTHANEQUAL);
	                            else if (c0 == '>' && c == '=')  // >=
	                            	list.get(list.size()-1).NewTokenType(Token.Type.GREATERTHANEQUAL);
	                        }
	                        else
	                        {
	                            if (checkValue(cType ) && c != '"') 
	                            	list.add(new Token(cType , c));
	                            else 
	                            	list.add(new Token(getType(c)));
	                        }
	                        break;
	                        
	                    case STRING:
	                    	String s2 = Character.toString(c); 
	                    	 
	                        if (i == s.length()-1 && c != '"') 
	                        	throw new Exception("This string is not closed.");
	                        if (c == '"') 
	                        	state = states.SPACE; 
	                        else
	                        {
	                            state = states.STRING;
	                            list.get(list.size()-1).changeValue(s2);
	                        }
	                        break;
	                    case CHAR:
	                    	String s23 = Character.toString(c); 
	                    	 
	                        if (i == s.length()-1 && c != '"') 
	                        	throw new Exception("This character is not closed.");
	                        if (c == '"') 
	                        	state = states.SPACE; 
	                        else
	                        {
	                            state = states.CHAR;
	                            list.get(list.size()-1).changeValue(s23);
	                        }
	                        break;
	                     /** case BOOLEANEXPRESSION:
	                    //	state = getState(c); 
	                    	String s21 = Character.toString(c); 
	                    	
	                    	if(i == s.length()-1 && c != '"') {
	                    		throw new Exception("This is not the boolean type expression true / false"); 
	                    	}
	                    	if(c == '"')
	                    		state = state.SPACE;
	                    	else {
	                    		state = states.BOOLEANEXPRESSION;
	                    		list.get(list.size()-1).changeValue(s21); 
	                    	}
	                    **/	
	                    case WORD: 
	                        state = getState(c);
	                        String s3 = Character.toString(c); 
	                        
	                        if (state != states.WORD) 
	                        {
	                        	//for : case
	                            if (state == states.LABEL) 
	                            	list.get(list.size()-1).NewTokenType(Token.Type.label); 
	                            else
	                            {
	                                if (checkValue(cType ) && c != '"')
	                                	list.add(new Token(cType , c));
	                                else
	                                	list.add(new Token(getType(c)));
	                            }
	                        }
	                        else 
	                        {
	                        	list.get(list.size()-1).changeValue(s3);
	                            if (c == '$' || c == '%') // if c is $ or % then change state as space and end it.
	                            	state = states.SPACE; 
	                        }
	                        break;
	                }
	            }
	            else 
	            	throw new Exception("Invaild Character type : " + c);
	        }
	        //put EndOfLine for the last
	        list.get(list.size()-1).NewTokenType(Token.Type.EndOfLine);
	        
	        //for token t inside the list
	        for (int i = 0; i < list.size(); i++) 
	        {   
	        	Token t = list.get(i); 
	        	Token.Type tType = t.getTokenType();
	        	String tValue = t.getTokenValue();
	        	
	            if (tType == Token.Type.String)
	            {
	                if (tValue == null) 
	                	t.changeValue(""); // null -> string value
	            }
	            
	            if(tType == Token.Type.Char) 
	            {
	            	//Token.Type c = Token.Type.Char ; 
					if(tValue == null)
	            		t.changeCharValue(c); // null -> char value )
	            }
    
	            if (tType == Token.Type.identifier && map.containsKey(tValue))
	                t.NewTokenType(map.get(tValue));
	        }
	        return list;
	    }
 	}