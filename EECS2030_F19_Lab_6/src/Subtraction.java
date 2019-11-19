
public class Subtraction extends Expression {

	private int diff;

	Subtraction(int a, int b) {
		super(a, b);
		this.left = a;
		this.right = b;

		this.diff = this.left - this.right;
		this.value = this.diff;
	}

	public Object getValue() {
		return this.value;
	}

	@Override
	void evaluate() {
		this.diff = this.left - this.right;
		this.value = this.diff;
	}

}
