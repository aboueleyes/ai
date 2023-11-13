package code.search_queues;

import code.Node;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class UCSQueue implements SearchQueue {

    private final Queue<Node> queue;

    public UCSQueue() {
        this.queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.getState().getMoneySpent()));
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
        return queue.isEmpty();
    }
}
