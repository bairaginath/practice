import java.util.*;

interface Discounter {
	
	int apply(int amount);
	
	static Discounter christmas(){
		return (amount)->amount-(amount*20)/100;
	}
	
	static Discounter diwali(){
		return (amount)-> amount-(amount*25)/100;
	}
	
	static Discounter newyear(){
		return (amount)-> amount-(amount*30)/100;
	}
	
	default Discounter combineAfter(Discounter after) {
        return value -> after.apply(this.apply(value));
    }
	
	default Discounter combineBefore(Discounter before) {
        return value -> this.apply(before.apply(value));
    }
}



public class StrategyDesign {
	
	public static void main(String[] args) {
		
		System.out.println(Discounter.christmas().apply(100));
		System.out.println(Discounter.diwali().apply(100));
		System.out.println(Discounter.newyear().apply(100));
		System.out.println(Discounter.diwali().combineAfter(Discounter.christmas()).apply(190));
		System.out.println(Discounter.diwali().combineBefore(Discounter.christmas()).apply(190));
		
		List<Discounter> list=new ArrayList<>();
		list.add(Discounter.diwali());
		list.add(Discounter.christmas());
		list.add(Discounter.newyear());
		Discounter discount=list.stream().reduce((x,y)->x.combineAfter(y)).get();
		System.out.println(discount.apply(100));
		
	}

}
