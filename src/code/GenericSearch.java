package code;

import code.actions.Action;
import code.logger.Logger;
import code.search_queues.SearchQueue;

import java.util.*;

public abstract class GenericSearch {

    public static String generalSearch(State initialState,List<Action> actions,
                                       SearchQueue searchQueue, boolean cutOff, boolean visualize) {
        int iterations = cutOff ? Integer.MAX_VALUE : 1;
        for (int i = 0; i < iterations; i++) {
            HashSet<Node> visited = new HashSet<>();
            Node initialNode = new Node(initialState, 0, 0, 0, 0,
                    "", null);
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
                    System.out.println("Expanded Nodes: " + expandedNodes);
                    if (visualize) {
                        Logger.logTree(currentNode);
                    }
                    return getPlan(currentNode, expandedNodes);
                }
                List<Node> nodes = expandNode(currentNode, actions);
                for (Node node : nodes) {
                    if (cutOff) {
                        if (node.getDepth() <= i) {
                            searchQueue.insert(node);
                        }
                    } else {
                        searchQueue.insert(node);
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
                .toList();
    }

    private static String getPlan(Node end, int expandedNodes) {
        StringBuilder path = new StringBuilder();
        Node current = end;
        while (current.getParent() != null) {
            path.insert(0, current.getLeadingActionType() + ",");
            current = current.getParent();
        }
        if (path.length() > 0) {
            path.deleteCharAt(path.length() - 1);
        }
        path.append(";").append(end.getState().getMoneySpent()).append(";").append(expandedNodes);
        return path.toString();
//        return "";
    }
}