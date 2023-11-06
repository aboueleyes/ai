package com.ai;

import com.ai.actions.Action;
import com.ai.search_queues.BFSQueue;
import com.ai.search_queues.DFSQueue;
import com.ai.search_queues.SearchQueue;

import java.util.List;

public class LLAPSearch extends GenericSearch{
    private static Parser parser = new Parser();
    public LLAPSearch() throws Exception {
        super();
        throw new Exception("Static Class!");
    }

    public static String solve(String initialState, String strategy, boolean visualize) {
        State state = parser.parseState(initialState);
        List<Action> actions = parser.parseActionsList(initialState);
        SearchQueue searchQueue = getSearchQueue(strategy);
        return generalSearch(state,actions, searchQueue);
    }

    public static SearchQueue getSearchQueue(String strategy) {
        switch (strategy) {
            case "BF":
                return new BFSQueue();
                case "DF":
                return new DFSQueue();
        }
        return null;
    }
}