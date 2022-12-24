
import java.util.ArrayList;
import java.util.List;
//import MathOpNode.Mathoptype;
import java.util.Stack;
/**
 * this class will parse the inputs 
 * @author choeseoyeon
 *
 */
public class Parser {
 
 // initialize 
 private List<Token> tokens; 
 
 //constuctor
 public Parser(List<Token> t) {
       this.tokens = t; 
    }
 /**
 * This is match and remove method 
 * if the specific token is matching then remove it. 
 * @param type
 * @return
 */
 public Token matchAndRemove(Token.Type type) { 
 /** if (!tokens.isEmpty())
 {
 if (type.toString() == ( tokens.get(0).toString())) {
 return (Token) tokens.remove(0);
 }else {
 return null;
 }
 //tokens is empty case
 }else 
 return null;
 **/
 if (tokens.get(0).type == type) {
        return tokens.remove(0);
 }
 throw new RuntimeException("Expected " + type + " but got " + tokens.get(0).type);
 
 }
 /**
 * This is factor method. This will check tokens and make factor form. 
 * @return Node
 * @throws Exception
 */
 public Node factor() throws Exception {
    Token token;
     Node f;
 
     if ((token = matchAndRemove(Token.Type.Number)) != null) {
 
     if (token.getTokenValue().indexOf('.') == -1) {
           return new IntegerNode(Integer.parseInt(token.getTokenValue()));
        }
    else {
           return new FloatNode(Float.parseFloat(token.getTokenValue())); 
         }
        }
 //check whether token is (
      if (matchAndRemove(Token.Type.Lparen) != null) {
        f = expression();
      if (matchAndRemove(Token.Type.Rparen) == null) { // )
         throw new Exception("error invaild");
       }else {
         return f;
       }
 }
 //check whether token is identifier ex) then, ,,,
       if ((token = matchAndRemove(Token.Type.identifier)) != null)
            return new VariableReferenceNode(token.getTokenValue());
      else{
            return null;
          } 
          }
 /**
 * This method will make expression by using operator and terms.
 * @return
 * @throws Exception
 */
 public Node expression() throws Exception {
 Node e1; //current expression 
 // Node end = new Node(Token.type);
 
 e1 = term(); //Node f
//  String s; 
 
       if (e1.isEmpty()) 
      e1 = callFunction(); //FuctionNode(String s, List<Node> l)
 
       Node e2; // next to e1 node
      //See whether there is more tokens. such as operators + , - 
      if (matchAndRemove(Token.Type.Plus) != null){
      e2 = expression();
      
      // expression add expression case 
      if (!e2.isEmpty()) {
              return new MathOpNode(MathOpNode.Operations.add, e1, e2);
       }else {
       //expression add null
       return new MathOpNode(MathOpNode.Operations.add, e1, callFunction());
       }
        //check whether token is -
       }else if (matchAndRemove(Token.Type.Minus) != null){
        e2 = expression();
         //expression minus expression case
             if (!e2.isEmpty()) {
                   return new MathOpNode(MathOpNode.Operations.subtract, e1, e2);
              }else {
           //expression mins null case
                    return new MathOpNode(MathOpNode.Operations.subtract, e1, callFunction());
                     }
       } else 
             return e1;
      }
 /**
 * This method will make term with multiply and divide operator. 
 * @return Node
 * @throws Exception
 */
 public Node term() throws Exception {
 Node term;
 term = factor(); 
 
 //check whether token is *
         if (matchAndRemove(Token.Type.Multiply) != null) { 
 //case term * term
               return new MathOpNode(MathOpNode.Operations.multiply, term, term());
 //check whether token is /
         } else if (matchAndRemove(Token.Type.Divide) != null) {
 //case term / term
              return new MathOpNode(MathOpNode.Operations.divide, term, term());
         }else 
               return term;
 }
 /**
 * This method will return value from the statements() method. 
 * @return StatementNode
 * @throws Exception
 */
 public StatementsNode parseElement() throws Exception{
              return statements();   }
 
 /**
 * This method will add statement to the list.
 * @return StatementesNode
 * @throws Exception
 */
 public StatementsNode statements() throws Exception {
 //Create arraylist to hold statementNode values.
 ArrayList<StatementNode> statementsList = new ArrayList<StatementNode>();
 StatementNode s;
 
 //if thisStatement is not empty then add it to the list. 
 while((s = statement()) != null)
 statementsList.add(s); 
 
 //return the nodes from the statementsList. 
        if (!statementsList.isEmpty()) {
               return new StatementsNode(statementsList);
         } else 
                return null;
         }
 /**
 * This method will 
 * @return
 * @throws Exception
 */
 public StatementNode statement() throws Exception {
 Token token = null;
 // you can change this to switch form !!
 // Token token = new Token(null); 
 //Token.Type t1 = token.getTokenType();
 
 switch(check()) {
   case 1 : 
	  // String t = "Lable";
          return nameStatement(token);
   case 2: 
          return printStatement(); 
   case 3:
          return assignment(token);
   case 4:
          return whileStatement();
   case 5:
          return repeatStatement();
   case 6:
          return forStatement();
   case 7:
          return new ReturnNode(); 
   case 8:
          return ifStatement();
    default:
          return null; 
 
 }
 }
 
 /**
 * This method will check the token type and then return specific integer numbe 
 * This method will help statement method. 
 * @return
 * @throws Exception
 */
 private int check() throws Exception {
// Token t = null; 
 Token t=null; 
     
 // if(!(t = matchAndRemove(Token.Type.label)).isEmpty()) {

   if(NullCheck( t, Token.Type.label)) {
             return 1; 
    }
   else if( NullCheck(t, Token.Type.Print) ) {
            return 2; 
    }
   else if(NullCheck(t, Token.Type.identifier) ){
           return 3; 
    }else if(NullCheck(t, Token.Type.While)) {
           return 4; 
     }
    else if( NullCheck(t, Token.Type.Repeat)) {
           return 5; 
     }else if( NullCheck(t, Token.Type.FOR)) {
            return 6;
     }else if(NullCheck(t, Token.Type.RETURN)) {
          if(NullCheck(t, Token.Type.EndOfLine) == true) {
              return 7; //returnNode()
           }else {
               throw new Exception("error"); 
           }        
    }else if(NullCheck(t,Token.Type.IF) == true) {
            return 8; 
    }else {
            return 0;
 }
 }

 //NullCheck 
 /**
 * This will check whether specific token t is match with token type 
 * And this will check whether token t is empty or not. 
 * @param t
 * @param type
 * @return boolean 
 */
 private boolean NullCheck(Token t, Token.Type type) {
	 // NullCheck(t, Token.Type.FOR) == true
 if(t == matchAndRemove(type) && t!= null) {
      return true;
 }else {
	 return false;
 }
 }
/**
 * 
 * @return
 * @throws Exception
 */
 public PrintNode printStatement() throws Exception {
	 
 ArrayList<Node> expressionList = new ArrayList<Node>();
 Node p;
 
 while (!(p= printList()).isEmpty()) {
           expressionList.add(p); //result of print is each expression
           matchAndRemove(Token.Type.Comma); //remove separating commas
 } 
 return new PrintNode(expressionList); //now printnode has a list of expressions
 }
/**
 * This method will print the list. 
 * @return
 * @throws Exception
 */
 public Node printList() throws Exception{
 Token t;
 
      if (!(t=matchAndRemove(Token.Type.String)).isEmpty())
             return new StringNode(t.getTokenValue());
      else 
             return expression();
 }
 /**
 * This method will hendle assignmentes 
 * @param t
 * @return AssignmentNode
 * @throws Exception
 */
 public AssignmentNode assignment(Token t) throws Exception{
 
 String s = t.getTokenValue();
 Node e = expression(); 
 VariableReferenceNode vrNode = new VariableReferenceNode(s);
 
 if (!matchAndRemove(Token.Type.equal).isEmpty())
           return new AssignmentNode(vrNode, e);
 else 
           return null;
 }
 /**
 * This method will read if the list is not empty. 
 * @return WhileNode
 * @throws Exception
 */
 public WhileNode whileStatement() throws Exception {
 //ArrayList to store VariableReferenceeNodes.
 ArrayList<VariableReferenceNode> rList= new ArrayList<VariableReferenceNode>(); 
 VariableReferenceNode read;
 
 while (!(read = readList()).isEmpty()) {
	 
       rList.add(read); //add to list
        matchAndRemove(Token.Type.Comma);
 }
        return new WhileNode(rList); 
 }
 /**
 * This method will read the list and return Node 
 * This method will help WhileStatement() method
 * @return
 * @throws Exception
 */
 private VariableReferenceNode readList() throws Exception {
 Token t = null;
 VariableReferenceNode v;
 
 String s = t.getTokenValue();
 
 if ( !(t=matchAndRemove(Token.Type.identifier)).isEmpty()) 
           v = new VariableReferenceNode(s);
 else if ( ! matchAndRemove(Token.Type.EndOfLine).isEmpty()) 
           return null;
 else 
           throw new Exception("unable to read and process");
 return v;
 }
 
 /**
 * This method will return statementNameNode based on token type.
 * @param t
 * @return StatementNameNode
 * @throws Exception
 */
 public StatementNameNode nameStatement(Token t) throws Exception{
 String s = t.getTokenValue();
 StatementNode st = statement();
 
 return new StatementNameNode(s, st);
 }
 /**
 * 
 * @return
 * @throws Exception
 */
 public ForNode forStatement() throws Exception{ 
 
 Token.Type i = Token.Type.identifier; 
 VariableReferenceNode vrNode = new VariableReferenceNode(matchAndRemove(i).getTokenValue());
 
 
 if (matchAndRemove(Token.Type.equal).isEmpty()) 
         throw new Exception("error must be fixed");
 
 Token t;
 IntegerNode n1, n2, step;
 
 
 if (!(t = matchAndRemove(Token.Type.Number)).isEmpty()){
           String s = t.getTokenValue();
 
 if (s.indexOf('.') == -1)
         n1 = new IntegerNode(Integer.parseInt(s));
 else 
         throw new Exception("error must be fixed");
 }
 
 else {
         throw new Exception("error must be fixed");
 }
 //token type TO
 if (matchAndRemove(Token.Type.TO).isEmpty()) 
         throw new Exception("error must be fixed");
 
 if (!(t = matchAndRemove(Token.Type.Number)).isEmpty()){
	 
 String s = t.getTokenValue();
 
 if (s.indexOf('.') == -1) { 
           n2 = new IntegerNode(Integer.parseInt(s));
 } else {
           throw new Exception("error must be fixed");
 }
 }else
          throw new Exception("error must be fixed - bounded integer needed");
 //token type step case 
 if (matchAndRemove(Token.Type.STEP).isEmpty()) 
          return new ForNode(vrNode, n1, n2, new IntegerNode(1));
 else{
	 
      if (!(t = matchAndRemove(Token.Type.Number)).isEmpty()){ 
    	        String s = t.getTokenValue();
      if (s.indexOf('.') == -1)
                step = new IntegerNode(Integer.parseInt(s));   
      else 
             throw new Exception("error must be fixed");
 }else
          throw new Exception("need integer value");
 
        return new ForNode(vrNode, n1, n2, step);
 }
 }
 /**
 * This method will return Node
 * @return Node
 * @throws Exception
 */
 public RepeatNode repeatStatement() throws Exception{
 Token t;
 
       if (!(t=matchAndRemove(Token.Type.identifier)).isEmpty()) {
                 String s = t.getTokenValue();
                return new RepeatNode(new VariableReferenceNode(s));
        } else {
               throw new Exception("This statement need variable");
 }
 }
 /**
 * This method will handle if-then statements
 * @return IfNode
 * @throws Exception
 */
 public IfNode ifStatement() throws Exception {
 //set b
           BlooeanExpressionNode b = booleanE();
       if (b.isEmpty()) {
            throw new Exception("This statement need boolean ");
       }
 //token type then 
       if (matchAndRemove(Token.Type.THEN).isEmpty()) 
             throw new Exception("After if statement Then is needed");
         Token t;
 
 //identifier case
        if ((t = matchAndRemove(Token.Type.identifier)).isEmpty()) 
              throw new Exception("IF statement requires label token");
        else 
              return new IfNode(b, t.getTokenValue());
         }
/**
 * This statment will check whether the operator and expression are vaild input. 
 * if expression is empty or operator is invaild, then this will return false
 * @return booleanExpressionNode
 * @throws Exception
 */
 public BlooeanExpressionNode booleanE() throws Exception{
 
        Node e1 = expression(); //set first expression
        Token op = (Token) tokens.remove(0);
        Node e2 = expression(); // set next expression 
 
       if (e1.isEmpty() || e2.isEmpty() || (op.getTokenType() != Token.Type.GREATERTHAN && 
           op.getTokenType() != Token.Type.LESSTHAN && op.getTokenType() != Token.Type.GREATERTHANEQUAL &&
           op.getTokenType() != Token.Type.LESSTHANEQUAL && op.getTokenType() != Token.Type.NOTEQUALS &&
           op.getTokenType() != Token.Type.equal)) 
                return null; 
      else 
                return new BlooeanExpressionNode(op.getTokenType(), e1, e2);
  }
 /**
 * This method will check whether function can be called
 * @return FunctionNode 
 * @throws Exception
 */
 public FunctionNode callFunction() throws Exception {
 
         Token removedToken = null ;
         String s;
         List<VariableReferenceNode> Nodelist = new ArrayList<VariableReferenceNode>();
 
        if (checkType()) 
            s= removedToken.getTokenValue(); 
        else 
            return null;
 
 //toten type (
         if (matchAndRemove(Token.Type.Lparen).isEmpty()) 
                throw new Exception("This function needs ( ");
         
 //initalize node 
           Node node;
 
          while (!(node = printList()).isEmpty()) { // printList() will accept strings.
                           Nodelist.add((VariableReferenceNode) node); 
                           matchAndRemove(Token.Type.Comma); 
          }
 //token type ) 
            if (matchAndRemove(Token.Type.Rparen).isEmpty()) 
                 throw new Exception("This function needs )");
 //return new Node(s, Nodelist);
                return new FunctionNode(s, Nodelist);     
		 
 }
 /**
 private Node FNodeToNode(FunctionNode fn) {
	//FuctionNode(String s, List<Node> l); 
	 
	 
 }
 **/
 
/**
 * This method will check whether t is match with specific Token.Type
 * @return
 */
 
 private boolean checkType() {
 boolean t; 
         if(!(t = matchAndRemove(Token.Type.RANDOM).isEmpty()) || 
            !(t = matchAndRemove(Token.Type.LEFT).isEmpty())
         || !(t = matchAndRemove(Token.Type.RIGHT).isEmpty() )
         || !(t = matchAndRemove(Token.Type.MINIMUN).isEmpty()) 
         || !(t = matchAndRemove(Token.Type.MAX).isEmpty())
         || !(t = matchAndRemove(Token.Type.VAL).isEmpty())
         || !(t = matchAndRemove(Token.Type.VAL2).isEmpty())){
 
           return true;
         }else {
 //invaild token type 
          return false; 
 }
 }
 
 public StatementsNode parse() throws Exception{
     return statements();
 }
}