
class Input1 {

}

class Service1 {
	Input1 input;

	Service1(Input1 input) {
		this.input = input;

	}

}

class WdmService1 extends Service1 {

	WdmService1(Input1 input) {
		super(input);
	}

}

class OtnService1 extends Service1 {

	OtnService1(Input1 input) {
		super(input);
	}

}

abstract class ServiceBuider {

	Service1 build() {
		Input1 input = new Input1();
		validate(input);
		checkPathExist(input);
		return new Service1(input);
	}

	abstract void validate(Input1 input);

	abstract void checkPathExist(Input1 input);

}

class WdmServiceBuilder extends ServiceBuider {

	@Override
	void validate(Input1 input) {
		System.out.println("Validate wdm input data");
	}

	@Override
	void checkPathExist(Input1 input) {
		System.out.println("Path exist for wdm service");
	}

}

class OtnServiceBuilder extends ServiceBuider {

	@Override
	void validate(Input1 input) {
		System.out.println("Validate otn input data");
	}

	@Override
	void checkPathExist(Input1 input) {
		System.out.println("Path exist for otn service");
	}

}

public class TemplateMethodDesign {
	
	public static void main(String[] args) {
		ServiceBuider serviceBuider=new WdmServiceBuilder();
		Service1 service=serviceBuider.build();
		serviceBuider=new OtnServiceBuilder();
		Service1 service2=serviceBuider.build();
		
	}

}
