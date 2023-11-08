package code.search_queues;

import code.Node;

import java.util.Stack;

public class DFSQueue implements SearchQueue{

    private final Stack<Node> stack;

    public DFSQueue() {
        this.stack = new Stack<>();
    }

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
