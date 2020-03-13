

class Input {
	
}

interface Service {
	String create(Input input);
}

class WdmService implements Service
{

	@Override
	public String create(Input input) {
        return "Wdm Service";		
	}
	
}

class ServiceTemplate implements Service
{
	Service service;
	ServiceTemplate(Service service){
		this.service=service;
	}
	@Override
	public String create(Input input) {
		return service.create(input);
	}
}

class OchTemplate extends ServiceTemplate
{

	OchTemplate(Service service) {
		super(service);
	}

	@Override
	public String create(Input input) {
		return super.create(input)+" with OchTemplate";
	}
	
}

class OduTemplate extends ServiceTemplate
{

	OduTemplate(Service service) {
		super(service);
	}

	@Override
	public String create(Input input) {
		return super.create(input)+" with OduTemplate";
	}
	
}

public class DecorateExample {
	
	public static void main(String[] args) {
		Input input=new Input();
		Service service=new WdmService();
		System.out.println(service.create(input));
		//wrapper on object or add extra information to object
		ServiceTemplate template=new OchTemplate(service);
		System.out.println(template.create(input));
		//multiple wrapper on object
		template=new OduTemplate(new OchTemplate(service));
		System.out.println(template.create(input));
}

}
