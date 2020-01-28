


interface Operation {
 int execute();
	
}




class AddOperation implements Operation {
    int left;
    int right;
	AddOperation(int left, int right) {
		this.left=left;
		this.right=right;
		
	}

	@Override
	public 	int execute() {
		return left+right;
	}
	
}

class SubOperation implements Operation {
	int left;
    int right;
	SubOperation(int left, int right) {
		this.left=left;
		this.right=right;
	}

	@Override
	public int execute() {
		return left-right;
	}
	
}

class MultiOperation implements Operation {
	int left;
    int right;
	MultiOperation(int left, int right) {
		this.left=left;
		this.right=right;
		}

	@Override 
	public 	int execute() {
		return left*right;
	}
	
}

class DivisionOperation implements Operation {
	int left;
    int right;
	DivisionOperation(int left, int right) {
		this.left=left;
		this.right=right;
		}

	@Override
	public int execute() {
		return left/right;
	}
	
}

class Executor {
	static int run(Operation operation){
		return operation.execute();
	}
}



public class CommandDesignPattern {
	
	public static void main(String[] args) {
		System.out.println(Executor.run(new AddOperation(6,3)));
		System.out.println(Executor.run(new SubOperation(6,3)));
		System.out.println(Executor.run(new MultiOperation(6,3)));
		System.out.println(Executor.run(new DivisionOperation(6,3)));
		System.out.println(Executor.run(()->71%7));
		Operation add=new AddOperation(5,3);
		System.out.println(Executor.run(add::execute));
		
		

	}

}
