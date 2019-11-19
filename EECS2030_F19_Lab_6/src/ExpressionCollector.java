import java.util.ArrayList;

/*
 * Your Tasks:
 * 1. Read the problem description and inheritance hierarchy diagram in the instructions.
 * 2. Add the necessary subclasses and implement the required methods.
 * 3. Study tests in TestExpressions.java to understand what's required to help your implementation. 
 */

public class ExpressionCollector {

	/*
	 * Your Task: Declare attribute(s) to store the list of Expression objects of
	 * this collector.
	 */
	ArrayList<Expression> expressions;
	Object value;

	/**
	 * Initialize an expression collector which stores an empty collection of
	 * expressions.
	 */
	ExpressionCollector() {
		this.expressions = new ArrayList<Expression>();
	}

	/**
	 * Add a new expression.
	 * 
	 * @param e an expression
	 */

	void addExpression(Expression e) {
		this.expressions.add(e);
	}

	/**
	 * Add a new expression.
	 * 
	 * @param left  integer value of the left operand
	 * @param op    operator (i.e., "+", "-", "*", ">", "<", "==")
	 * @param right integer value of the right operand
	 */
	void addExpression(int left, String op, int right) {
		Expression e;

		if (op.equals("+"))
			e = new Addition(left, right);
		else if (op.equals("-"))
			e = new Subtraction(left, right);
		else if (op.equals("=="))
			e = new Equal(left, right);
		else if (op.equals(">"))
			e = new GreaterThan(left, right);
		else if (op.equals("<"))
			e = new LessThan(left, right);
		else if (op.equals("*"))
			e = new Multiplication(left, right);
		else
			e = null;

		this.expressions.add(e);
	}

	/**
	 * If this collector is AddAll or TimesAll, then all stored expressions must be
	 * integer expressions (i.e., Addition, Subtraction, Multiplication). If this
	 * collection is ConjoinAll or DisjoinAll, then all stored expressions must be
	 * boolean expressions (i.e., GreaterThan, LessThan, Equal)
	 * 
	 * @return whether it is possible to evaluate the stored collection of
	 *         expressions.
	 */
	boolean isTypeCorrect() {

		if (this.expressions.size() == 0)
			return true;

		Expression comp = this.expressions.get(0);
		for (Expression exp : this.expressions) {
			if (exp.value.getClass() != comp.value.getClass())
				return false;
		}
		return true;
	}

	/**
	 * Given that this expression collector is type correct (see `isTypeCorrect()`),
	 * evaluate it. Store the evaluation result so that it can be returned by
	 * `getValue()`.
	 */
	void evaluate() {
		/* Your Task */
		// Hint: Leave this empty and override it in all subclasses such as AddAll and
		// ConjoinAll.
	}

	/**
	 * Get the result of the latest evaluation (i.e., after the latest call to
	 * `evaluate()`).
	 * 
	 * @return the last evaluation result.
	 */
	Object getValue() {
		return this.value;
	}

	/**
	 * Obtain the list of stored expressions.
	 * 
	 * @return all stored expressions as an array
	 */
	Expression[] getExpressions() {
		if (this.expressions.size() == 0)
			return new Expression[0];

		Expression[] out = new Expression[this.expressions.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = this.expressions.get(i);
		}
		return out;

	}

	/**
	 * Override the equals method. Two expression collectors are equals if: 1) They
	 * are both type correct 2) Their evaluation results are identical
	 * 
	 * @return whether or not the two expression collectors are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		ExpressionCollector other = (ExpressionCollector) obj;

		if (this.isTypeCorrect() && other.isTypeCorrect() && this.getValue() == other.getValue())
			return true;

		return false;
	}
}
