package code;

import code.actions.Action;
import code.search_queues.SearchQueue;

import java.util.*;

public abstract class GenericSearch {

    public static String generalSearch(State initialState,List<Action> actions, SearchQueue searchQueue, boolean cutOff){
        int iterations = cutOff ? Integer.MAX_VALUE : 1;
        for (int i = 0; i < iterations; i++) {
            HashMap<Node, Node> parentMap = new HashMap<>();
            HashSet<Node> visited = new HashSet<>();
            Node initialNode = new Node(initialState, 0, 0, 0, 0, "");
            searchQueue.insert(initialNode);

            int expandedNodes = 0;
            while (!searchQueue.isEmpty()) {
                Node currentNode = searchQueue.removeFront();
                if (visited.contains(currentNode)) {
                    continue;
                }

                visited.add(currentNode);

                expandedNodes++;

                if (goalTest(currentNode)) {
                    return getPath(initialNode, currentNode, parentMap) + ";" + currentNode.getState().getMoneySpent() + ";" + expandedNodes;
                }
                List<Node> nodes = expandNode(currentNode, actions);
                for (Node node : nodes) {
                    if (cutOff) {
                        if (node.getDepth() <= i) {
                            searchQueue.insert(node);
                            parentMap.put(node, currentNode);
                        }
                    } else {
                        searchQueue.insert(node);
                        parentMap.put(node, currentNode);
                    }
                }
            }
        }
        return "NOSOLUTION";
    }

    private static boolean goalTest(Node node) {
        return node.getState().getProsperity() >= 100;
    }

    private static List<Node> expandNode(Node node, List<Action> actions) {
        return actions.stream()
                .map(operator -> operator.apply(node))
                .filter(Objects::nonNull)
                .peek(newNode -> newNode.setDepth(node.getDepth() + 1))
                .toList();
    }

    private static String getPath(Node start, Node end, HashMap<Node,Node> parentMap) {
        StringBuilder path = new StringBuilder();
        Node current = end;
        while (current != start) {
            path.insert(0, current.getLeadingActionType() + ",");
            current = parentMap.get(current);
        }
        return path.toString();
    }
}