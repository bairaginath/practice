import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DirectGraph<T> {
	
	Map<T,GraphNode<T>> graph;
	
	void addNode(T t){
		if(graph==null)
			graph=new HashMap<>();
		GraphNode<T> gn=new GraphNode<>(t);
		graph.put(gn.name,gn);
	}
	
	void addEdge(T from,T to){
	   graph.get(from).addAdjecent(to);
	}
	
	void printAdjecent(T t)
	{
		graph.get(t).printAdjecent();
	}
	
	
	class GraphNode<T> {
		  T name;
		  List<T> adjecent;
		  GraphNode(T name){
			  this.name=name;
		  }
		  void addAdjecent(T t){
            if(adjecent==null)
            	adjecent=new LinkedList<>();
            this.adjecent.add(t);      	
            

		  }
		  void printAdjecent(){
			  adjecent.stream().forEach((e)->System.out.print(e+"->"));
			  System.out.println();
			}
	}
	
	
	
	public static void main(String[] args) {
		DirectGraph<String> dg=new DirectGraph<>();
		dg.addNode("1");
		dg.addNode("2");
		dg.addNode("3");
		dg.addNode("4");
		dg.addNode("5");
		dg.addEdge("1","2");
		dg.addEdge("1","3");
		dg.addEdge("2","3");
		dg.addEdge("2","4");
		dg.addEdge("2","5");
		dg.addEdge("3","5");
		dg.addEdge("4","5");
		dg.printAdjecent("1");
		dg.printAdjecent("2");
		dg.printAdjecent("3");
		dg.printAdjecent("4");
		
		
	}

}
