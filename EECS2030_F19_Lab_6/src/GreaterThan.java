
public class GreaterThan extends Expression {

	private boolean gt;

	GreaterThan(int a, int b) {
		super(a, b);
		this.left = a;
		this.right = b;

		this.gt = this.left > this.right ? true : false;
		this.value = this.gt;

	}

	public Object getValue() {
		return this.value;
	}

	@Override
	void evaluate() {
		this.gt = this.left > this.right ? true : false;
		this.value = this.gt;
	}

}
