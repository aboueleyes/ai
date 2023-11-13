package code.search_queues;

import code.Node;

public interface SearchQueue {
    Node removeFront();

    void insert(Node node);

    boolean isEmpty();
}
