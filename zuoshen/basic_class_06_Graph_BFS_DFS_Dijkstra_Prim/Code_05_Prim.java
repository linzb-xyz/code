import java.util.*;

// undirected graph only
public class Code_05_Prim {

    public static class Node {
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    public static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

    }
    public static class Graph {
        public HashMap<Integer,Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }

    }

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
				new EdgeComparator());
		HashSet<Node> set = new HashSet<>();
		Set<Edge> result = new HashSet<>();
		for (Node node : graph.nodes.values()) {
			if (!set.contains(node)) {
				set.add(node);
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();
					Node toNode = edge.to;
					if (!set.contains(toNode)) {
						set.add(toNode);
						result.add(edge);
						for (Edge nextEdge : toNode.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}

}
