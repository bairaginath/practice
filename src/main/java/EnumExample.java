
enum Operator {

    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },

    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },

    SUBTRACT {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },

    DIVIDE {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    },

    MODULO {
        @Override
        public int apply(int a, int b) {
            return a % b;
        }
    };

    public abstract int apply(int a, int b);
}






enum Cons {
    
	PI("3.14"),
	GV("9.8");
	
	
	String value;
	Cons(String value){
		this.value=value;
	}
	
	String getValue(){
		return this.value;
	}
}

enum Singleton {
	Instance;
	
	String value="james";
	private Singleton(){}
	
	public static Singleton getInstance(){
		return Instance;
	}

@Override
	public String toString() {
		return "Singleton@43434";
	}
	
    
	
}

public class EnumExample {
	
	public static void main(String[] args) {
		System.out.println(Cons.GV.getValue());
		
		System.out.println(Singleton.getInstance().value);
		System.out.println(Operator.ADD.apply(5, 7));
	}

}
