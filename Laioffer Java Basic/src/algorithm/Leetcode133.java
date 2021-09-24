import java.util.*;

//// DFS
//public class Leetcode133 {
//    class Node {
//        public int val;
//        public List<Node> neighbors;
//
//        public Node (int val) {
//           this.val = val;
//           this.neighbors = new ArrayList<Node>();
//        }
//
//
//        public Node (int val, List<Node> neighbors) {
//            this.val = val;
//            this.neighbors = neighbors;
//        }
//    }
//    public Node deepCopy(Node node) {
//        if (node == null || node.neighbors == null) {
//            return node;
//        }
//
//        Map<Node, Node> map = new HashMap<>();
//        return dfs(node, map);
//    }
//
//    private Node dfs(Node node, Map<Node, Node> map) {
//        if (node == null) {
//            return null;
//        }
//
//        if (map.containsKey(node)) {
//            return map.get(node);
//        }
//
//        Node newNode = new Node(node.val);
//        map.put(node, newNode);
//        for (Node nei : node.neighbors) {
//            newNode.neighbors.add(dfs(nei, map));
//        }
//        return newNode;
//    }
//}


// BFS
public class Leetcode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node (int val) {
            this.val = val;
            this.neighbors = new ArrayList<Node>();
        }


        public Node (int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
    public Node deepCopy(Node node) {
        if (node == null || node.neighbors == null) {
            return node;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node newNode = new Node(node.val);
        queue.offer(node);
        map.put(node, newNode);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node nei : curNode.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }
                // this step is used to get the deep copied node's neighbor and add the new neighbors to its neighbors list.
                map.get(curNode).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
}
