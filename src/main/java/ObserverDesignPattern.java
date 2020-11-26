
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

interface SConsumer {

	void update(Object object);

}

class SimpleProducer {

	private String news;
	List<SConsumer> consumers=new ArrayList<>();
 
	public void setNews(String news) {
		this.news = news;
		consumers.stream().forEach(o->o.update(news));
	}
	
public void addConsumer(SConsumer consumer){
		consumers.add(consumer);
	}

}

class SimpleConsumer1 implements SConsumer {

	private String news;

	@Override
	public void update(Object object) {
		this.news = (String) object;
	}

	public String getNews() {
		return news;
	}
	
	

}



class SimpleConsumer2 implements SConsumer {

	private String news;

	@Override
	public void update(Object object) {
		this.news = (String) object;
	}

	public String getNews() {
		return news;
	}

}

class Producer1 extends Observable {
	private String news;

	public void setNews(String news) {
		this.news = news;
		setChanged();
		notifyObservers(news);
	}

}

class Consumer1 implements Observer {
	private String news;

	@Override
	public void update(Observable o, Object arg) {
		this.news = (String) arg;
	}

	public String getNews() {
		return this.news;
	}

}

class Consumer2 implements Observer {
	private String news;

	@Override
	public void update(Observable o, Object arg) {
		this.news = (String) arg;
	}

	public String getNews() {
		return this.news;
	}

}

public class ObserverDesignPattern {

	public static void main(String[] args) {
		
		
		SimpleProducer sp=new SimpleProducer();
		SimpleConsumer1 sc1=new SimpleConsumer1();
		SimpleConsumer2 sc2=new SimpleConsumer2();
		sp.addConsumer(sc1);
		sp.addConsumer(sc2);
		sp.setNews("Simple news broadcast");
		System.out.println("Simple Consumer1 "+sc1.getNews());
		System.out.println("Simple Consumer2 "+sc2.getNews());
		Producer1 p = new Producer1();
		Consumer1 c1 = new Consumer1();
		Consumer2 c2 = new Consumer2();
		p.addObserver(c1);
		p.addObserver(c2);
		p.setNews("world is not enough");
		System.out.println("consumer1 news " + c1.getNews());
		System.out.println("consumer2 news " + c2.getNews());

	}

}
