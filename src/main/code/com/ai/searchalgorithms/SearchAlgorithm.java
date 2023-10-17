package com.ai.searchalgorithms;

import com.ai.ResourcesMetrics;
import com.ai.State;

public interface SearchAlgorithm {
    String search(State initialState, ResourcesMetrics resourcesMetrics, boolean visualize);
}