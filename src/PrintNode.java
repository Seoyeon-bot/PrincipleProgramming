
import java.util.*;
/**
 * This class will hold printNode
 * @author choeseoyeon
 *
 */
public class PrintNode extends StatementNode {
	//create list
    private List<Node> printList;
/**
 * constructor 
 * @param l
 */
    public PrintNode(List<Node> p) {
        this.printList = p;
    }
/**
 * getter for the printlist
 * @return List<Node>
 */
    public List<Node> getPrintList() {
        return this.printList;
    }
/**
 * Convert type to string value
 */
    public String toString() {
    	
        String s = "Print(";
        
        for(int i = 0; i < printList.size(); i++) {
        	String s1 = printList.get(i).toString(); 
        	s += s1 + ", ";
        }
        return s.substring(0, s.length()-2) + ")"; // don't print , 
    }

}