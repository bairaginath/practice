import java.util.ArrayList;
import java.util.List;

class Animal {
	
}

class Dog extends Animal {
}

class Cat extends Animal {
}



public class GenericCasting {
	
	static	<T> List<T> getResult(List<Animal> animals,Class<T> type){
		List<T> list=new ArrayList<>();
		
		animals.forEach(a-> {
			if(type.isInstance(a))
			{
				   T ob=(T) type.cast(a);
				   list.add(ob);
			}
		});
		
		
		return list;
	}
	
	public static void main(String[] args) {
		List <Animal> list=new ArrayList<Animal>() {
			{
			  add(new Animal());
			  add(new Dog());
			  add(new Animal());
			  add(new Cat());
			}	
			};
			
	System.out.println(list);
//	List<Cat> output=getResult(list,Dog.class);
    //List<Animal> output=getResult(list,Dog.class);
	List<Dog> output=getResult(list,Dog.class);
	List<Dog> output1=GenericCasting.<Dog>getResult(list,Dog.class);
	System.out.println(output);
	System.out.println(output1);
	
	}


}
