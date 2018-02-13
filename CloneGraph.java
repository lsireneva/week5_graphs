import java.util.HashMap;
import java.util.LinkedList;

public class CloneGraph {


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newneighbor);
                }

                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        return head;


    }

}
