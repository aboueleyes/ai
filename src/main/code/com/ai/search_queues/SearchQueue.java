package com.ai.search_queues;

import com.ai.Node;

public interface SearchQueue {
    public Node removeFront();

    public void insert(Node node);

    public boolean isEmpty();
}
