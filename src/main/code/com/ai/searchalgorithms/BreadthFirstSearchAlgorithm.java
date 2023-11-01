package com.ai.searchalgorithms;

import com.ai.Node;
import com.ai.ResourcesMetrics;
import com.ai.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchAlgorithm implements SearchAlgorithm {
    @Override
    public String search(State initialState, ResourcesMetrics resourcesMetrics, boolean visualize) {
        Node initialNode = new Node(initialState);
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node,Node> parentMap = new HashMap<>();
        queue.add(initialNode);

        int expandedNodes =0;
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();

            expandedNodes++;

            if(currentNode.getState().getProsperity() == 100){
                return getPath(initialNode, currentNode, parentMap) + ";" + currentNode.getState().getMoneySpent() + ";" + expandedNodes;
            }

            ArrayList<Node> children = currentNode.getChildren(resourcesMetrics);
            for(Node child: children){
                parentMap.put(child,currentNode);
                queue.add(child);
            }
        }

        return "NOSOLUTION";
    }

    private String getPath(Node start, Node end, HashMap<Node,Node> parentMap) {
        StringBuilder path = new StringBuilder();
        Node current = end;
        while (current != start) {
            path.insert(0, current.getLeadingActionType() + ",");
            current = parentMap.get(current);
        }
        return path.toString();
    }
}
