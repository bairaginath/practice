import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class DirectGraph<T> {

	Map<T, GraphNode<T>> graph;

	void addNode(T t) {
		if (graph == null)
			graph = new HashMap<>();
		GraphNode<T> gn = new GraphNode<>(t);
		graph.put(gn.name, gn);
	}

	void addEdge(T from, T to) {
		graph.get(from).addAdjecent(to);
	}

	void printAdjecent(T t) {
		graph.get(t).printAdjecent();
	}

	class GraphNode<T> {
		T name;
		List<T> adjecent;

		GraphNode(T name) {
			this.name = name;
		}

		void addAdjecent(T t) {
			if (adjecent == null)
				adjecent = new LinkedList<>();
			this.adjecent.add(t);

		}

		void printAdjecent() {
			adjecent.stream().forEach((e) -> System.out.print(e + "->"));
			System.out.println();
		}
	}

	private void dfsRecursive(Stack<T> stack, Map<T, Boolean> visit) {
		T node;
		while (true) {
			if (stack.isEmpty() == true)
				return;
			node = stack.pop();
			if (visit.get(node) == false)
				break;
		}
		System.out.println(node);
		visit.put(node, true);
		if (graph.get(node).adjecent != null)
			graph.get(node).adjecent.stream().forEach(n -> stack.push(n));
		dfsRecursive(stack, visit);
	}

	void doDfs(T t) {
		Map<T, Boolean> visit = graph.<T, GraphNode<T>>entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> false));
		Stack<T> stack = new Stack<>();
		stack.push(t);
		dfsRecursive(stack, visit);
	}

	private void bfsRecursive(Queue<T> queue, Map<T, Boolean> visit) {
		T node;
		while (true) {
			if (queue.isEmpty() == true)
				return;
			node = queue.poll();
			if (visit.get(node) == false)
				break;
		}
		System.out.println(node);
		visit.put(node, true);
		if (graph.get(node).adjecent != null)
			graph.get(node).adjecent.stream().filter(n -> visit.get(n) == false).filter(n -> queue.contains(n) == false)
					.forEach(queue::add);
		bfsRecursive(queue, visit);
	}

	void doBfs(T t) {
		Map<T, Boolean> visit = graph.<T, GraphNode<T>>entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> false));
		Queue<T> queue = new LinkedList<>();
		queue.add(t);
		bfsRecursive(queue, visit);
	}

	public static void main(String[] args) {
		DirectGraph<String> dg = new DirectGraph<>();
		dg.addNode("1");
		dg.addNode("2");
		dg.addNode("3");
		dg.addNode("4");
		dg.addNode("5");
		dg.addEdge("1", "2");
		dg.addEdge("1", "3");
		dg.addEdge("2", "3");
		dg.addEdge("2", "4");
		dg.addEdge("2", "5");
		dg.addEdge("3", "5");
		dg.addEdge("4", "5");
		dg.printAdjecent("1");
		dg.printAdjecent("2");
		dg.printAdjecent("3");
		dg.printAdjecent("4");
		System.out.println("====DFS=====");
		dg.doDfs("1");
		System.out.println("====BFS=====");
		dg.doBfs("1");

	}

}
