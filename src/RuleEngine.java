

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

enum Operator {
	ADD, MULTI, DIVID, SUB,REMINDER;
}

class Expression {

	int left;
	int right;
	Operator operator;
	
	

	public int getLeft() {
		return left;
	}



	public void setLeft(int left) {
		this.left = left;
	}



	public int getRight() {
		return right;
	}



	public void setRight(int right) {
		this.right = right;
	}



	public Operator getOperator() {
		return operator;
	}



	public void setOperator(Operator operator) {
		this.operator = operator;
	}



	public Expression(int left, int right, Operator operator) {
		super();
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

}

interface Rules{
	Integer evaluate(Expression e);
}

class AddRules implements Rules {

	@Override
	public Integer evaluate(Expression e) {
		if(e.getOperator()==Operator.ADD)
		return e.getLeft()+e.getRight();
		return null;
	}
	
}

class SubRules implements Rules {

	@Override
	public Integer evaluate(Expression e) {
		if(e.getOperator()==Operator.SUB)
		return e.getLeft()-e.getRight();
		return null;
	}
	
}

class MultiRules implements Rules {

	@Override
	public Integer evaluate(Expression e) {
		if(e.getOperator()==Operator.MULTI)
		return e.getLeft()*e.getRight();
		return null;
	}
	
}

class DivRules implements Rules {

	@Override
	public Integer evaluate(Expression e) {
		if(e.getOperator()==Operator.DIVID)
		return e.getLeft()/e.getRight();
		return null;
	}
	
}


public class RuleEngine {
	
	static List<Rules> rules=new ArrayList<>();
	static {
		rules.add(new AddRules());
		rules.add(new SubRules());
		rules.add(new DivRules());
		rules.add(new MultiRules());
	}
	
	static Integer process(Expression e) {
		Integer result=rules.parallelStream().filter(r->r.evaluate(e)!=null)
				.map(r->r.evaluate(e))
				.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Expression does not matches any Rule"));
	return result;
	}
	
	public static void main(String[] args) {
		
		Expression e1=new Expression(6,3,Operator.ADD);
		System.out.println(RuleEngine.process(e1));
		e1=new Expression(6,3,Operator.SUB);
		System.out.println(RuleEngine.process(e1));
		e1=new Expression(6,3,Operator.DIVID);
		System.out.println(RuleEngine.process(e1));
		e1=new Expression(6,3,Operator.MULTI);
		System.out.println(RuleEngine.process(e1));
		e1=new Expression(6,3,Operator.REMINDER);
		System.out.println(RuleEngine.process(e1));


		
	}

}
