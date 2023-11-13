package code.heuristics;

import code.Node;
import code.actions.BuildAction;

import java.util.List;

public class SecondHeuristic implements Heuristic {

    private final List<BuildAction> buildActions;

    public SecondHeuristic(List<BuildAction> buildActions) {
        this.buildActions = buildActions;
    }

    @Override
    public double apply(Node node) {
        double min = Double.MAX_VALUE;
        int sumBuildPrice = 0;
        int sumResourcesPrice = 0;
        for (BuildAction buildAction : buildActions) {
            int foodPrice = buildAction.getFoodUsed() * buildAction.getFoodPrice();
            int materialsPrice = buildAction.getMaterialsUsed() * buildAction.getMaterialsPrice();
            int energyPrice = buildAction.getEnergyUsed() * buildAction.getEnergyPrice();
            int buildPrice = buildAction.getPrice();
            sumResourcesPrice += foodPrice + materialsPrice + energyPrice;
            sumBuildPrice += buildAction.getPrice();
            int prosperityAdded = buildAction.getProsperity();
            double value = ((double) (100 - node.getState().getProsperity())) / prosperityAdded * (foodPrice + materialsPrice + energyPrice + buildPrice);
            min = Math.min(min, value);
        }
        return min / (sumBuildPrice + sumResourcesPrice);
//        return min;
    }
}
