package code.heuristics;

import code.Node;
import code.actions.BuildAction;

import java.util.List;

public class FirstHeuristic implements Heuristic {

    private final List<BuildAction> buildActions;

    public FirstHeuristic(List<BuildAction> buildActions) {
        this.buildActions = buildActions;
    }

    @Override
    public int apply(Node node) {
        int remainingProsperity = Math.max((100 - node.getState().getProsperity()), 0);
        return buildActions.stream().map((buildAction) -> {
            int price = buildAction.getPrice();
            int prosperityAdded = buildAction.getProsperity();
            return (int) Math.ceil((double) remainingProsperity / prosperityAdded) * price;
        }).min(Integer::compare).orElse(0);
    }
}
