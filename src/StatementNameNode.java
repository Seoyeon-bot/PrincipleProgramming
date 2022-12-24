
/**
 * This class wil handle the statementNodes
 * @author choeseoyeon
 *
 */
public class StatementNameNode extends StatementNode {
	
	//initialze
    private String value;
    private StatementNode statement;
/**
 * constructor
 * @param v
 * @param s
 */
    public StatementNameNode(String v, StatementNode s) {
        this.value = v;
        this.statement = s;
    }
/**
 * getter for value 
 * @return
 */
    public String getValue() {
        return this.value;
    }
/**
 * getter for statement 
 * @return
 */
    public StatementNode getStatement() {
        return this.statement;
    }
// use this method in interpreter class. 
    public  void accept() {
        Interpreter.StatementNameNodeVisit(this);
    }
/**
 * convert to string type 
 */
    public String toString() {
        return "StatementNameNode("+ value +": "+statement.toString()+")";
    }
    
}