package com.ai.actions;

import com.ai.Node;
import com.ai.State;

public class BuildAction extends Action {

    private final int price;
    private final int foodUsed;
    private final int materialsUsed;
    private final int energyUsed;
    private final int prosperity;

    public BuildAction(String name, int foodPrice, int materialsPrice, int energyPrice, int price, int foodUsed, int materialsUsed, int energyUsed, int prosperity) {
        super(name, foodPrice, materialsPrice, energyPrice);
        this.price = price;
        this.foodUsed = foodUsed;
        this.materialsUsed = materialsUsed;
        this.energyUsed = energyUsed;
        this.prosperity = prosperity;
    }


    @Override
    public Node apply(Node node) {
        State nextState = this.getNextState(node.getState(), this.foodUsed, this.materialsUsed, this.energyUsed, this.price, this.prosperity);
        if(nextState.equals(node.getState())){
            return null;
        }

        if(node.getDelay() == 0){
            return new Node(nextState, 0, 0, 0,0, this.getName());
        }

        if(node.getDelay() == 1){
            nextState.setFood(nextState.getFood() + node.getFoodToGetAfterDelay());
            nextState.setMaterials(nextState.getMaterials() + node.getMaterialsToGetAfterDelay());
            nextState.setEnergy(nextState.getEnergy() + node.getEnergyToGetAfterDelay());
            return new Node(nextState, 0, 0, 0,0, this.getName());
        }

        return new Node(nextState, node.getDelay()-1, node.getFoodToGetAfterDelay(), node.getMaterialsToGetAfterDelay(), node.getEnergyToGetAfterDelay(), this.getName());
    }
}