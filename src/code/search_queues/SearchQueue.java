package code.search_queues;

import code.Node;

public interface SearchQueue {
    public Node removeFront();

    public void insert(Node node);

    public boolean isEmpty();
}
