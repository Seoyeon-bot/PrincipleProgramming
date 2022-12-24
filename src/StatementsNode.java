
import java.util.*;

import java.lang.String;

/**
 * This class will handle the statements 
 * @author choeseoyeon
 *
 */
public class StatementsNode extends Node {
	//initialize 
    private List<StatementNode> statements; // null
/**
 * constructor 
 * @param s
 */
    public StatementsNode(List<StatementNode> s) {
        this.statements = s;
    }
    
/**
 * getter for the statements
 * @return
 */
    public List<StatementNode> getStatements() {
        return this.statements;
    }
   /**
    * setter for the statementes.  
    * @param s
    */
    public void setStatements(List<StatementNode> s) {
    	this.statements = s; 
    }
/**
 * This method will add list of statementNode 
 * @param s
 */
    public void addToList(List<StatementNode> s) {
        statements.addAll(s);
    }
/**
 * Conver to the string type 
 */
    public String toString() {
        String s = "Statements(";
        for (Node statement : statements) s += statement.toString()+", ";
        return s.substring(0, s.length()-2)+")";
    }

}
