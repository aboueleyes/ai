package code;

import code.actions.Action;
import code.actions.BuildAction;
import code.heuristics.FirstHeuristic;
import code.heuristics.Heuristic;
import code.logger.Logger;
import code.search_queues.*;

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
        List<BuildAction> buildActions = actions.stream()
                .filter(action -> action instanceof BuildAction)
                .map(action -> (BuildAction) action)
                .toList();
        SearchQueue searchQueue = getSearchQueue(strategy, buildActions);
        return generalSearch(state,actions, searchQueue, strategy.equals("ID"), visualize);
    }

    public static SearchQueue getSearchQueue(String strategy, List<BuildAction> buildActions) {
        Heuristic firstHeuristic = new FirstHeuristic(buildActions);
        Heuristic secondHeuristic = null; // TODO: handle second heuristic
        return switch (strategy) {
            case "BF" -> new BFSQueue();
            case "DF", "ID" -> new DFSQueue();
            case "UC" -> new UCSQueue();
            case "GR1" -> new GRQueue(firstHeuristic);
            case "GR2" -> new GRQueue(firstHeuristic);
            case "AS1" -> new AStarQueue(firstHeuristic);
            case "AS2" -> new AStarQueue(firstHeuristic);
            default -> null;
        };
    }
}