
public class DisjoinAll extends ExpressionCollector {
	DisjoinAll() {
		super();
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	void evaluate() {
		Boolean prod = false;
		for (Expression e : this.expressions) {
			e.evaluate();
			prod |= (Boolean) e.getValue();
		}

		this.value = prod;
	}

}
