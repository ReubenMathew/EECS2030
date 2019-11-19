
public class LessThan extends Expression {

	private boolean lt;

	LessThan(int a, int b) {
		super(a, b);
		this.left = a;
		this.right = b;

		this.lt = this.left < this.right ? true : false;
		this.value = this.lt;

	}

	public Object getValue() {
		return this.value;
	}

	@Override
	void evaluate() {
		this.lt = this.left < this.right ? true : false;
		this.value = this.lt;
	}

}
