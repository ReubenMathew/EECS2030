
public class TimesAll extends ExpressionCollector {
	TimesAll(){
		super();
	}
	
	@Override
	public Object getValue() {
		return this.value;
	}
	
	@Override
	void evaluate() {
		Integer prod = 1;
		for (Expression e : this.expressions) {
			e.evaluate();
			prod *= (Integer) e.getValue();
		}
		
		this.value = prod;
	}
	
}
