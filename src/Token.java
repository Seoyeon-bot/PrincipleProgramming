

public class Token {

	/**
	 * instance of enum
	 * String type value
	 * @author choeseoyeon
	 *
	 */
	   
	        public enum Type{
	        	Plus, Minus, Multiply, Divide, Number, Lparen, Rparen, Float, Comma, String,
		    	equal, EndOfLine, identifier ,Data, Read, Input, label,Print,RETURN, 
		    	Colon, Semicolon, Begin, End, Integer, 
	            Define, Variable, Period, LESSTHAN, GREATERTHAN, SPACE, 
	            FOR, TO, NEXT, STEP, VAL, VAL2, IF, THEN, LESSTHANEQUAL, GREATERTHANEQUAL, NOTEQUALS, 
	            RANDOM, RIGHT, LEFT, MINIMUN, MAX, 
	            While, Reverse,
	            
	            If, then, Else, Elsif, From,  Repeat, Until, Mod, Var, 
	            BooleanExpression, True, False,
	        	Doublequote, Singlequote,Char; // " ", ' '
	            
	        }
	        //initialize
	        private Type t;
	        private String value = null;
	        private char cvalue = 0; 

	        /**
	         * constructor
	         * @param tokenType
	         */
	        public Token(Type type) {    
	            this.t = type;
	        }
/**
 * constructor 
 * @param tokenType
 * @param c
 */
	        public Token(Type tokenType, char c) {    
	            this.t = tokenType;
	            this.value = Character.toString(c); //convert type 
	        }
	        
	        /**
	         * This method will change string value
	         * @param s
	         */
	        public void changeValue(String s) {
	            if (s != null)
	            {
	                if (this.value == null) { 
	                	this.value= s;  //just use same string value
	                }else {
	                	this.value += s;    // change it 
	                }
	            }
	            else { 
	            	this.value = null;
	            	
	            	}
	        }
	        /**
	         * This method will change char value 
	         */
	        public void changeCharValue(char c) {
	        	if(c != 0) {
	        		if(this.cvalue == 0) {
	        			this.cvalue = c;
	        		}else {
	        			this.cvalue +=c;
	        		}
	        	}
	        	else {
	        		this.cvalue = 0;
	        	}
	        }
	        /**
	         * this method will get new token type
	         * @param newType
	         */
	        public void NewTokenType(Type newT) { 
	            this.t = newT;
	        }
	        /**
	         * getters
	         * @return
	         */
	        public String getTokenValue() {
	            return this.value;
	        }
	        //getter
	        public Type getTokenType() {
	            return t;
	        }
            //setter 
	        public void setTokenValue(String value) {
	        	this.value = value; 
	        }
	        StringBuffer sb = new StringBuffer();
			public Token.Type type; 
	        
	        /**
	         * convert to string type
	         */
	        @Override
	        public String toString()
	    	{
	        	/**
	        	if(t == Token.Type.label) {
	        		return this.getTokenValue() + "(" + this.getTokenValue() + ")";
	        		
	        	}
	        	else if( t== Token.Type.Number) {
	        		return this.getTokenValue() + "(" + this.getTokenValue() + ")";
	        	}
	        	else if(t == Token.Type.identifier) {
	        		return this.getTokenValue() + "(" + this.getTokenValue() + ")";
	        	}
	        	else if(t == Token.Type.String) {
	        		return this.getTokenValue() + "(" + this.getTokenValue() + ")";
	        	}
	        	else {
	        		return   this.getTokenValue() + "";
	        	}
	        	**/
	        	
	        	switch(this.t)
	            {         
	                case Number:
	                case String:
	                case identifier:
	                case Doublequote:	//add double and single quote 
	                case Singlequote:
	                case True:   //add boolean expression types 
	                case False: 
	                	
	                case label:
	                    return this.getTokenType()+ "(" + this.getTokenValue() + ")" ;
	                default:
	                    return this.getTokenType() +""; 
	            }
	           
	    	}

			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
	    
	    
	   
	
}
