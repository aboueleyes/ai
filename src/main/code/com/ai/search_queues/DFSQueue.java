package com.ai.search_queues;

import com.ai.Node;

import java.util.Stack;

public class DFSQueue implements SearchQueue{

    Stack<Node> stack = new Stack<>();

    @Override
    public Node removeFront() {
        return stack.pop();
    }

    @Override
    public void insert(Node node) {
        stack.push(node);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
