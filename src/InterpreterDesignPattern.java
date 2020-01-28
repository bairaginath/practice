import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;

interface Expression {
	public int interpret();
}

class Add implements Expression {

	private final Expression leftExpression;
	private final Expression rightExpression;

	public Add(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() + rightExpression.interpret();
	}

}

class Product implements Expression {

	private final Expression leftExpression;
	private final Expression rightExpression;

	public Product(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() * rightExpression.interpret();
	}
}

class Substract implements Expression {

	private final Expression leftExpression;
	private final Expression rightExpression;

	public Substract(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() - rightExpression.interpret();
	}

}

class Division implements Expression {

	private final Expression leftExpression;
	private final Expression rightExpression;

	public Division(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() / rightExpression.interpret();
	}

}

class Number implements Expression {

	private final String n;

	public Number(String n) {
		this.n = n;
	}

	@Override
	public int interpret() {
		return Integer.parseInt(n);
	}

}

public class InterpreterDesignPattern {

	static Expression getOperator(String s, Expression left, Expression right) {
		switch (s) {
		case "+":
			return new Add(left, right);
		case "-":
			return new Substract(left, right);
		case "*":
			return new Product(left, right);
		case "/":
			return new Division(left, right);
		}
		return null;
	}

	public static boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		else
			return false;
	}

	static int simpleEvaluate(String str) {

		for (int i = 0; i < str.length(); i++) {
			String s = Character.toString(str.charAt(i));
			if (isOperator(s)) {
				String left = str.substring(0, i);
				String right = str.substring(i + 1, str.length());
				Expression operator = getOperator(s, new Number(left), new Number(right));
				return operator.interpret();

			}
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(simpleEvaluate("9+3"));
		System.out.println(simpleEvaluate("9-3"));
		System.out.println(simpleEvaluate("9*3"));
		System.out.println(simpleEvaluate("9/3"));
	}

}
