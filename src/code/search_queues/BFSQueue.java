package code.search_queues;

import code.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BFSQueue implements SearchQueue{

    private final Queue<Node> queue;

    public BFSQueue(){
        this.queue = new LinkedList<>();
    }
    @Override
    public Node removeFront() {
        return queue.poll();
    }

    @Override
    public void insert(Node node) {
        queue.add(node);
    }

    @Override
    public boolean isEmpty() {
        return  queue.isEmpty();
    }
}
