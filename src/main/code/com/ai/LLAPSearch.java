package com.ai;

import com.ai.searchalgorithms.DepthFirstSearchAlgorithm;
import com.ai.searchalgorithms.SearchAlgorithm;

public class LLAPSearch {
    private static Parser parser;
    public LLAPSearch() {
        parser = new Parser();
    }

    public static String solve(String initialState, String strategy, boolean visualize) {
        State state = parser.parseState(initialState);
        ResourcesMetrics resourcesMetrics = parser.parseResourcesMetrics(initialState);
        SearchAlgorithm searchAlgorithm = getSearchAlgorithm(strategy);
        return searchAlgorithm.search(state, resourcesMetrics, visualize);
    }

    public static SearchAlgorithm getSearchAlgorithm(String strategy) {
        switch (strategy) {
            case "BF":
                return new DepthFirstSearchAlgorithm();
        }
        return null;
    }
}