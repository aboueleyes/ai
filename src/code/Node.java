package code;

import java.util.Objects;

public class Node {

    private final State state;
    private final int delay;
    private final int foodToGetAfterDelay;
    private final int materialsToGetAfterDelay;
    private final int energyToGetAfterDelay;
    private final int depth;
    private final String leadingActionType;
    private final Node parent;

    public Node(State state, int delay, int foodToGetAfterDelay, int materialsToGetAfterDelay, int energyToGetAfterDelay, String leadingActionType, Node parent) {
        this.state = state;
        if(delay==0){
            this.state.setFood(Math.min(this.state.getFood() + foodToGetAfterDelay, 50));
            this.state.setMaterials(Math.min(this.state.getMaterials() + materialsToGetAfterDelay,50));
            this.state.setEnergy(Math.min(this.state.getEnergy() + energyToGetAfterDelay,50));
            this.delay = 0;
            this.foodToGetAfterDelay = 0;
            this.materialsToGetAfterDelay = 0;
            this.energyToGetAfterDelay = 0;
        }
        else{
            this.delay = delay;
            this.foodToGetAfterDelay = foodToGetAfterDelay;
            this.materialsToGetAfterDelay = materialsToGetAfterDelay;
            this.energyToGetAfterDelay = energyToGetAfterDelay;
        }
        this.leadingActionType = leadingActionType;
        this.parent = parent;
        if (this.parent == null) {
            this.depth = 0;
        } else {
            this.depth = this.parent.depth + 1;
        }
    }

    public State getState() {
        return state;
    }

    public int getDelay() {
        return delay;
    }

    public int getFoodToGetAfterDelay() {
        return foodToGetAfterDelay;
    }

    public int getMaterialsToGetAfterDelay() {
        return materialsToGetAfterDelay;
    }

    public int getEnergyToGetAfterDelay() {
        return energyToGetAfterDelay;
    }

    public String getLeadingActionType() {
        return leadingActionType;
    }

    public int getDepth() {
        return depth;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return delay == node.delay
                && foodToGetAfterDelay == node.foodToGetAfterDelay
                && materialsToGetAfterDelay == node.materialsToGetAfterDelay
                && energyToGetAfterDelay == node.energyToGetAfterDelay
                && state.equals(node.state)
                && Objects.equals(leadingActionType, node.leadingActionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, delay, foodToGetAfterDelay, materialsToGetAfterDelay, energyToGetAfterDelay, leadingActionType);
    }
}
