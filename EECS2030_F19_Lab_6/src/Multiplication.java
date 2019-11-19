
public class Multiplication extends Expression {

	private int prod;
	
	Multiplication(int a, int b){
		super(a,b);
		this.left = a;
		this.right = b;
		
		this.prod = this.left*this.right;
		this.value = this.prod;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	@Override
	void evaluate() {
		this.prod = this.left*this.right;
		this.value = this.prod;
	}
}
