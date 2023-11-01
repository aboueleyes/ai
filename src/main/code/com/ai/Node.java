package com.ai;

import com.ai.actions.Action;

import java.util.ArrayList;

public class Node {

    private final State state;
    private final int delay;
    private final int foodToGetAfterDelay;
    private final int materialsToGetAfterDelay;
    private final int energyToGetAfterDelay;

    private String leadingActionType;

    public Node(State state, int delay, int foodToGetAfterDelay, int materialsToGetAfterDelay, int energyToGetAfterDelay, String leadingActionType) {
        this.state = state;
        if(delay==0){
            this.state.setFood(this.state.getFood() + foodToGetAfterDelay);
            this.state.setMaterials(this.state.getMaterials() + materialsToGetAfterDelay);
            this.state.setEnergy(this.state.getEnergy() + energyToGetAfterDelay);
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

    public ArrayList<Node> expand(Action[] actions){
        ArrayList<Node> children = new ArrayList<>();



        return children;
    }

}
