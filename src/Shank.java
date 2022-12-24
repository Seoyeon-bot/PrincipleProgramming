import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Shank {

	
	/**
	 * //read all lines from the file
		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get("./src/lab4.txt"));
	 * @param args
	 * @throws Exception
	 */
	
	
	
	public static void main (String[] args)  throws Exception{
		
		//read inputs from the file and put it in the lines.
			List<String> lines = Files.readAllLines(Paths.get("./src/lab4.txt"));
		//list for tokens	- use this for print output from the lexer class  
            List<Token> LexerList = new ArrayList<Token>(); 
        // List of Tokens - use this for print output from the parser class 
            List<List<Token>> ListOfTokens = new ArrayList<List<Token>>(lines.size()); 
         
         //print input and tokenized line   
            for (int i = 0; i < lines.size(); i++)
            {
            	
            	System.out.println("Input is : " + lines.get(i));
            	
            	LexerList = Lexer.lex(lines.get(i));
                System.out.println("Line : " + LexerList);
                    
                ListOfTokens.add(LexerList);
                System.out.println("Tokenlist : " +  ListOfTokens);
                System.out.println();
            }
            
            StatementsNode parsedStatements = new StatementsNode(new ArrayList<StatementNode>());

            for (int i = 0; i < lines.size(); i++)
            {
               
            	//checks if lexer will encounter any illegal symbols
                    List<Token> lineTokenList = Lexer.lex(lines.get(i));
                    ListOfTokens.add(lineTokenList);
                    StatementsNode statements = getParsedLine(ListOfTokens.get(i));
                    parsedStatements.addToList(statements.getStatements());
               

            }
            
            
            
            
            Interpreter interpreter = new Interpreter(parsedStatements);
            interpreter.callMethods();
            List<StatementNode> statements = new ArrayList<>(); 
            
          //semanticAnalysis class 
            SemanticAnalysis semantic = new SemanticAnalysis(); //call clasee
            semantic.CheckAssignments(statements);
            
            
            for(String s : lines ) {
            //	statements.addAll(s);
            }
            
        //    interpreter.BooleanExpression(null)
            System.out.println(interpreter.getStatements());
            
           
            
         
       /**
            //parser test 
            //everything is inside the tokenList
            StatementsNode parsedStatements = new StatementsNode(new ArrayList<StatementNode>());

        	Parser p = new Parser(LexerList);
        	StatementsNode statements = p.parseElement(); // null -> error 
            System.out.println("Parse output: " + statements);
            List<StatementNode> s = statements.getStatements();
        	parsedStatements.addToList(s);
      
        	
            
            
            //test interpreter class 
          
            Interpreter interpreter = new Interpreter(parsedStatements);
           // interpreter.callMethods(); // call methods in interpreter class. 
          //  System.out.println(interpreter.getStatements());
            interpreter.InterpreterFunctiion(null, null);
          **/
            
    }
	public static StatementsNode getParsedLine(List<Token> tokens) {
        try {
            Parser p = new Parser(tokens);
            StatementsNode statements = p.parse();
            return statements;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
		