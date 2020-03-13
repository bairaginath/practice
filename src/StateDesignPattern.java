class Package {
	
	State state;
	Package(){
		this.state=new OrderState();
	}
	
	Package(State state){
		this.state=state;
	}
	
   public void setState(State state) {
	this.state = state;
}
   
   void packageStatus(){
	   this.state.printState();
   }
   
   void next(){
	   this.state.next(this);
   }
   
   void prev(){
	   this.state.prev(this);
   }
	
	
}


interface State{
	void next(Package pack);
	void prev(Package pack);
	void printState();
}

class OrderState implements State {

	@Override
	public void next(Package pack) {
		pack.setState(new DeliveryState());
		
	}

	@Override
	public void prev(Package pack) {
		System.out.println("It is inital state,no previous state");
		
	}

	@Override
	public void printState() {
		System.out.println("Order status");
		
	}

}

class DeliveryState implements State {

	@Override
	public void next(Package pack) {
		pack.setState(new RecievedState());
		
	}

	@Override
	public void prev(Package pack) {
		pack.setState(new OrderState());
		
	}

	@Override
	public void printState() {
		System.out.println("Delivery status");
		
	}

}

class RecievedState implements State {

	@Override
	public void next(Package pack) {
        System.out.println("No more next state,it is final state");		
	}

	@Override
	public void prev(Package pack) {
		pack.setState(new DeliveryState());
		
	}

	@Override
	public void printState() {
		System.out.println("Recieved status");
		
	}

}







public class StateDesignPattern {
	
	public static void main(String[] args) {
		
		Package p=new Package();
		p.packageStatus();
		p.next();
		p.packageStatus();
		p.next();
		p.packageStatus();
		p.next();
		p.packageStatus();
		p.prev();
		p.packageStatus();
		p.prev();
		p.packageStatus();
		p.prev();
		p.packageStatus();
		
	}
	

}
