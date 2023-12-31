package code.actions;

import code.Node;
import code.State;

public class BuildAction extends Action {

    private final int price;
    private final int foodUsed;
    private final int materialsUsed;
    private final int energyUsed;
    private final int prosperity;

    public BuildAction(String name, int foodPrice, int materialsPrice, int energyPrice, int price, int foodUsed,
                       int materialsUsed, int energyUsed, int prosperity) {
        super(name, foodPrice, materialsPrice, energyPrice);
        this.price = price;
        this.foodUsed = foodUsed;
        this.materialsUsed = materialsUsed;
        this.energyUsed = energyUsed;
        this.prosperity = prosperity;
    }

    @Override
    public Node apply(Node node) {
        State nextState = this.getNextState(node.getState(), this.foodUsed, this.materialsUsed,
                this.energyUsed, this.price, this.prosperity);
        if(nextState.equals(node.getState())){
            return null;
        }

        if(node.getDelay() == 0){
            return new Node(nextState, 0, 0, 0,
                    0, this.getName(), node);
        }

        if(node.getDelay() == 1){
            nextState.setFood(Math.min(50,nextState.getFood() + node.getFoodToGetAfterDelay()));
            nextState.setMaterials(Math.min(50,nextState.getMaterials() + node.getMaterialsToGetAfterDelay()));
            nextState.setEnergy(Math.min(50,nextState.getEnergy() + node.getEnergyToGetAfterDelay()));
            return new Node(nextState, 0, 0, 0,
                    0, this.getName(), node);
        }

        return new Node(nextState, node.getDelay()-1, node.getFoodToGetAfterDelay(),
                node.getMaterialsToGetAfterDelay(), node.getEnergyToGetAfterDelay(), this.getName(), node);
    }

    public int getPrice() {
        return price;
    }

    public int getProsperity() {
        return prosperity;
    }

    public int getFoodUsed() {
        return foodUsed;
    }

    public int getMaterialsUsed() {
        return materialsUsed;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }
}