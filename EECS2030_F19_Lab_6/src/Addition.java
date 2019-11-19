
public class Addition extends Expression {

	private int sum;

	Addition(int a, int b) {
		super(a, b);
		this.left = a;
		this.right = b;

		this.sum = this.left + this.right;
		this.value = this.sum;

	}

	public Object getValue() {
		return this.value;
	}

	@Override
	void evaluate() {
		this.sum = this.left + this.right;
		this.value = this.sum;
	}

}
