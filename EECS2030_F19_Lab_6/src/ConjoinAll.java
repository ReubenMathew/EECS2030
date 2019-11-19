
public class ConjoinAll extends ExpressionCollector {

	ConjoinAll() {
		super();
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	void evaluate() {
		Boolean prod = true;
		for (Expression e : this.expressions) {
			e.evaluate();
			prod &= (Boolean) e.getValue();
		}

		this.value = prod;
	}

}
