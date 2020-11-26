

import java.util.ArrayList;
import java.util.List;

enum LightOperator {
	ADD, MULTI, DIVID, SUB,REMINDER;
}

class LightExpression {

	int left;
	int right;
	LightOperator operator;
	
	

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



	public LightOperator getOperator() {
		return operator;
	}



	public void setOperator(LightOperator operator) {
		this.operator = operator;
	}



	public LightExpression(int left, int right, LightOperator operator) {
		super();
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

}

interface Rules{
	Integer evaluate(LightExpression e);
}

class AddRules implements Rules {

	@Override
	public Integer evaluate(LightExpression e) {
		if(e.getOperator()==LightOperator.ADD)
		return e.getLeft()+e.getRight();
		return null;
	}
	
}

class SubRules implements Rules {

	@Override
	public Integer evaluate(LightExpression e) {
		if(e.getOperator()==LightOperator.SUB)
		return e.getLeft()-e.getRight();
		return null;
	}
	
}

class MultiRules implements Rules {

	@Override
	public Integer evaluate(LightExpression e) {
		if(e.getOperator()==LightOperator.MULTI)
		return e.getLeft()*e.getRight();
		return null;
	}
	
}

class DivRules implements Rules {

	@Override
	public Integer evaluate(LightExpression e) {
		if(e.getOperator()==LightOperator.DIVID)
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
	
	static Integer process(LightExpression e) {
		Integer result=rules.parallelStream().filter(r->r.evaluate(e)!=null)
				.map(r->r.evaluate(e))
				.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Expression does not matches any Rule"));
	return result;
	}
	
	public static void main(String[] args) {
		
		LightExpression e1=new LightExpression(6,3,LightOperator.ADD);
		System.out.println(RuleEngine.process(e1));
		e1=new LightExpression(6,3,LightOperator.SUB);
		System.out.println(RuleEngine.process(e1));
		e1=new LightExpression(6,3,LightOperator.DIVID);
		System.out.println(RuleEngine.process(e1));
		e1=new LightExpression(6,3,LightOperator.MULTI);
		System.out.println(RuleEngine.process(e1));
		e1=new LightExpression(6,3,LightOperator.REMINDER);
		System.out.println(RuleEngine.process(e1));


		
	}

}
