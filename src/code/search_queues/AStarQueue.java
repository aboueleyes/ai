package code.search_queues;

import code.Node;
import code.heuristics.Heuristic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarQueue implements SearchQueue {

    private final Queue<Node> queue;

    public AStarQueue(Heuristic heuristic) {
        this.queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.getState().getMoneySpent() + heuristic.apply(a)));
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
