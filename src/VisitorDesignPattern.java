import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.sun.javafx.scene.control.skin.CustomColorDialog;

interface Element {
	void validate(Rule rule);
}

class StringElement implements Element {
	String value;

	public StringElement() {
	}

	public StringElement(String value) {
		this.value = value;
	}

	@Override
	public void validate(Rule rule) {
		rule.accept(this);

	}

}

class EmailElement implements Element {
	String email;

	public EmailElement(String email) {
		this.email = email;
	}

	@Override
	public void validate(Rule rule) {
		rule.accept(this);
	}

}

class PasswordElement implements Element {
	String password;

	public PasswordElement(String password) {
		this.password = password;
	}

	@Override
	public void validate(Rule rule) {
		rule.accept(this);
	}

}

class NotNullElement implements Element {
	String value;

	public NotNullElement(String value) {
		this.value = value;
	}

	@Override
	public void validate(Rule rule) {
		rule.accept(this);
	}

}

interface Rule {
	void accept(EmailElement emailElement);

	void accept(PasswordElement passwordElement);

	void accept(NotNullElement notNullElement);

	void accept(Element element);
}

class RuleImp implements Rule {

	@Override
	public void accept(EmailElement emailElement) {
		if (emailElement.email == null || emailElement.email.contains("@") == false)
			System.out.println("email is not valid");
		else
			System.out.println("email is valid");
	}

	@Override
	public void accept(PasswordElement passwordElement) {
		if (passwordElement.password == null || passwordElement.password.length() < 5)
			System.out.println("password is not valid");
		else
			System.out.println("password is valid");

	}

	@Override
	public void accept(NotNullElement notNullElement) {
		if (notNullElement.value == null)
			System.out.println("value is null");
		else
			System.out.println("value is valid");
	}

	@Override
	public void accept(Element element) {
		System.out.println("element is valid");

	}

}

class MyCustomRule extends RuleImp {
	@Override
	public void accept(Element element) {
		if(element instanceof StringElement && (((StringElement) element).value==null || ((StringElement) element).value.contentEquals("")))
			System.out.println("element is not valid according customRule");
		else
		System.out.println("element is valid");
		
	}

}

class Document implements Element {

	List<Element> elements = new ArrayList<>();

	void addElement(Element element) {
		elements.add(element);
	}

	@Override
	public void validate(Rule rule) {
		elements.stream().forEach(e -> e.validate(rule));

	}

}

public class VisitorDesignPattern {

	public static void main(String[] args) {

		Document d = new Document();
		d.addElement(new EmailElement("bairagi@gmail.com"));
		d.addElement(new PasswordElement("jam"));
		d.addElement(new NotNullElement("world"));
		d.addElement(new StringElement());
		d.addElement(new StringElement("james"));
		d.addElement(new StringElement(""));
		Rule rule = new RuleImp();
		d.validate(rule);
		rule=new MyCustomRule();
		d.validate(rule);

	}

}
