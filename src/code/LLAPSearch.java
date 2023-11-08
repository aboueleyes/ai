package code;

import code.actions.Action;
import code.search_queues.BFSQueue;
import code.search_queues.DFSQueue;
import code.search_queues.SearchQueue;

import java.util.List;

public class LLAPSearch extends GenericSearch {
    private static Parser parser = new Parser();
    public LLAPSearch() throws Exception {
        super();
        throw new Exception("Static Class!");
    }

    public static String solve(String initialState, String strategy, boolean visualize) {
        State state = parser.parseState(initialState);
        List<Action> actions = parser.parseActionsList(initialState);
        SearchQueue searchQueue = getSearchQueue(strategy);
        return generalSearch(state,actions, searchQueue, strategy.equals("ID"));
    }

    public static SearchQueue getSearchQueue(String strategy) {
        switch (strategy) {
            case "BF":
                return new BFSQueue();
            case "DF":
            case "ID":
                return new DFSQueue();

        }
        return null;
    }
}