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
    public double apply(Node node) {
        double min = Double.MAX_VALUE;
        int sum = 0;
        for (BuildAction buildAction : buildActions) {
            int price = buildAction.getPrice();
            int prosperityAdded = buildAction.getProsperity();
            sum += price;
            double value = (double) (100 - node.getState().getProsperity()) / prosperityAdded * price;
            min = Math.min(min, value);
        }
        return min;
    }
}
