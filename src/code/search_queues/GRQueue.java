package code.search_queues;

import code.Node;
import code.heuristics.Heuristic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GRQueue implements SearchQueue {

    private final Queue<Node> queue;

    public GRQueue(Heuristic heuristic) {
        this.queue = new PriorityQueue<>(Comparator.comparing(heuristic::apply));
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
