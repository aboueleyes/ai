package com.ai.actions;

import com.ai.Node;
import com.ai.State;

public class WaitAction extends Action {

    public WaitAction(int foodPrice, int materialsPrice, int energyPrice){
        super("WAIT", foodPrice, materialsPrice, energyPrice);
    }

    @Override
    public Node apply(Node node) {
        State nextState = this.getNextState(node.getState());
        if(nextState.equals(node.getState()) || node.getDelay() == 0){
            return null;
        }

        if(node.getDelay() == 1){
            nextState.setFood(Math.min(50,nextState.getFood() + node.getFoodToGetAfterDelay()));
            nextState.setMaterials(Math.min(50,nextState.getMaterials() + node.getMaterialsToGetAfterDelay()));
            nextState.setEnergy(Math.min(50,nextState.getEnergy() + node.getEnergyToGetAfterDelay()));
            return new Node(nextState, 0, 0, 0,0, this.getName());
        }

        return new Node(nextState, node.getDelay()-1, node.getFoodToGetAfterDelay(), node.getMaterialsToGetAfterDelay(), node.getEnergyToGetAfterDelay(), this.getName());
    }
}