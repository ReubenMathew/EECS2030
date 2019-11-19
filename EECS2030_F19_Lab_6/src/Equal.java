
public class Equal extends Expression {
	
	private boolean eq;
	
	Equal(int a, int b){
		super(a,b);
		this.left = a;
		this.right = b;
		
		this.eq = this.left == this.right ? true : false;
		this.value = this.eq;
	}
	
	@Override
	void evaluate() {
		this.eq = this.left == this.right ? true : false;
		this.value = this.eq;
	}
	
	public Object getValue() {
		return this.value;
	}
}
