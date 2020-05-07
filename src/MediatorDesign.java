
class Mediator {
	Fan fan;
	Button button;
	PowerSupply powerSupply;

	public void setFan(Fan fan) {
		this.fan = fan;
		this.fan.setMediator(this);
	}

	public void setButton(Button button) {
		this.button = button;
		this.button.setMediator(this);
	}

	public void setPowerSupply(PowerSupply powerSupply) {
		this.powerSupply = powerSupply;
	}

	void on() {
		this.powerSupply.on();

	}

	void off() {
		this.powerSupply.off();
	}
	
	void press() {
		if(this.fan.isFanOn()) {
			this.fan.off();
		}
		else this.fan.on();
	}
		

}

class Fan {

	Mediator mediator;
	boolean isOn=false;
	
	boolean isFanOn() {
		return isOn;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	void on() {
		this.mediator.on();
		this.isOn=true;
		System.out.println("fan on");

	}

	void off() {
		this.mediator.off();
		this.isOn=false;
		System.out.println("fan off");

	}
}

class Button {

	Mediator mediator;

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	void press() {
		this.mediator.press();
	}

	}



class PowerSupply {

	
	void on() {
		System.out.println("power on");
	}

	void off() {
		System.out.println("power off");
	}

}

public class MediatorDesign {
	
	public static void main(String[] args) {
		Fan fan=new Fan();
	    Button button=new Button();
        PowerSupply powerSupply=new PowerSupply();
        Mediator mediator=new Mediator();
        mediator.setButton(button);
        mediator.setFan(fan);
        mediator.setPowerSupply(powerSupply);
        button.press();
        button.press();
        button.press();
        button.press();
		
	}
	
	
}
