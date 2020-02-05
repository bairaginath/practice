import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

class User {

	String name;

	User(String name) {
		this.name = name;
	}

	static int staticMethodNoParameter() {
		return 55;
	}

	static int staticMethodWithParameter(String str) {
		return str == null ? 0 : str.length();

	}

	int instanceMethodNoParam() {
		System.out.println(this.name);
		return this.name == null ? 0 : this.name.length();

	}

	int instanceMethodWithParameter(String str) {
		return str == null ? 0 : str.length();
	}

	int lengthSort(User user) {
		System.out.println(user.name);
		return user.name.length();
	}

	public Double calculateValue(Double initialValue) {
		System.out.println("parent method");
		return initialValue / 1.50;
	}

}

class ChildUser extends User {

	ChildUser(String name) {
		super(name);
	}

	@Override
	public Double calculateValue(Double initialValue) {
		Function<Double, Double> function = super::calculateValue;
		Double pcValue = function.apply(initialValue);
		System.out.println("child method");
		return pcValue + (initialValue / 10);
	}

}

@FunctionalInterface
interface InterfaceUser {
    User create(String name);
}

public class DoubleColonOrMethodReferance {

	public static void main(String[] args) {
		User user = new User("bairaginath");
		User user1 = new User("behera");
		Supplier<Integer> s = User::staticMethodNoParameter;
		System.out.println(s.get());
		Function<String, Integer> fn = User::staticMethodWithParameter;
		System.out.println(fn.apply("bairagi"));

		Supplier<Integer> sp = user::instanceMethodNoParam;
		System.out.println(sp.get());

		Function<String, Integer> fn1 = user::instanceMethodWithParameter;
		System.out.println(fn1.apply("james"));

		// Supplier<Integer> sp2=User::instanceMethodNoParam;
		Arrays.asList(user, user1).stream().forEach(User::instanceMethodNoParam);

		// it will work simillary to comparable mehtod
		Arrays.asList(user, user1).stream().sorted(User::lengthSort);

		// A Super Method of a Particular Object
		User uu=new ChildUser("child");
		uu.calculateValue(300.33);
		
		
		//Constructor References
		InterfaceUser c = User::new;
		User user2 = c.create("india");
		System.out.println(user2.name);
		
		Function<String,User> con=User::new;
		System.out.println(con.apply("function").name);
		
		// create user array with length 5
		Function <Integer, User[]> userCreator = User[]::new;
		User[] userArray = userCreator.apply(5);
		System.out.println(userArray.length);
		

	}

}
