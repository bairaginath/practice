import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Human implements Serializable {
	
	private static final long SerialVersionUID = 1005l;
	private String name;
	private int age;

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}

public class SerialVersionUIDExample {
	
	static ObjectOutputStream oos;
	static FileOutputStream fos = null;

	static <T> void writeObject(T t) {
		
		try {
			if(fos==null)
			   fos = new FileOutputStream("xyz.txt",true);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			if(oos==null)
			 oos = new ObjectOutputStream(fos);
			//System.out.println(oos);
			oos.writeObject(t);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	static <T> T readObject() {
		FileInputStream fis = null;
		T t=null;
		try {
			fis = new FileInputStream("xyz.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			for(int i=0;i<4;i++)
			{ t=(T)ois.readObject();
			  System.out.println(t);
			
			}
			fis.close();
			ois.close();
		} catch (IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return t;

	}
	
	public static void main(String[] args) {
		Human h1=new Human("james1", 27);
		Human h2=new Human("james2", 27);
		Human h3=new Human("james3", 27);
		Human h4=new Human("james4", 27);
		SerialVersionUIDExample.<Human>writeObject(h1);
		SerialVersionUIDExample.<Human>writeObject(h2);
		SerialVersionUIDExample.<Human>writeObject(h3);
		SerialVersionUIDExample.<Human>writeObject(h4);
		boolean flag=true;
		while(flag){
			try {
		Human h=SerialVersionUIDExample.<Human>readObject();
		flag=false;
		System.out.println(h.getName()+"  "+h.getAge() );
			}catch (Exception e) {flag=false;}
		}
		
	}


}
