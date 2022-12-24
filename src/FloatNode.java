
public class FloatNode extends Node{
    private float num;

    public FloatNode(float n) {
        this.num = n;
    }
    public FloatNode() {
		// TODO Auto-generated constructor stub
	}
	public float getFloat() {
        return this.num;
    }
    public String toString() {
        return "Float("+this.num+")";
    }
}