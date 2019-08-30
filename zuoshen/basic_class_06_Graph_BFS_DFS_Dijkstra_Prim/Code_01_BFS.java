package class_06;

import java.util.*;

public class Code_01_BFS {
    public static class Node <T> {
        public  T value;
        public int in;          //入度
        public int out;         //出度
        public ArrayList<Node> nexts;       //该节点的领接节点
        public ArrayList<Edge> edges;       //从该节点出发的边

        public Node(T value) {
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

	public static void bfs(Node<Integer> node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node<Integer> cur = queue.poll();
			System.out.println(cur.value);
			for (Node<Integer> next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}

}
