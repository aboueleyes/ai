package com.ai;

import java.util.ArrayList;

public class Node {

    private State state;
    private int delay;
    private int foodToGetAfterDelay;
    private int materialsToGetAfterDelay;
    private int energyToGetAfterDelay;

    private ActionTypes leadingActionType;

    public Node(State state, int delay, int foodToGetAfterDelay, int materialsToGetAfterDelay, int energyToGetAfterDelay, ActionTypes leadingActionType) {
        this.state = state;
        if(delay==0){
            collectGains();
            resetNode();
        }
        else{
            this.delay = delay;
            this.foodToGetAfterDelay = foodToGetAfterDelay;
            this.materialsToGetAfterDelay = materialsToGetAfterDelay;
            this.energyToGetAfterDelay = energyToGetAfterDelay;
        }
        this.leadingActionType = leadingActionType;
    }

    public Node(State state, Node previous, ActionTypes leadingActionType){
        this.state = state;
        if(previous.delay>1){
            this.delay = previous.delay - 1;
            this.foodToGetAfterDelay = previous.foodToGetAfterDelay;
            this.materialsToGetAfterDelay = previous.materialsToGetAfterDelay;
            this.energyToGetAfterDelay = previous.energyToGetAfterDelay;
        }
        else{
            if(previous.delay==1){
                collectGains();
            }
            resetNode();
        }
        this.leadingActionType = leadingActionType;
    }

    public Node(State state){
        this.state = state;
        resetNode();
    }

    private void resetNode(){
        this.delay = 0;
        this.foodToGetAfterDelay = 0;
        this.materialsToGetAfterDelay = 0;
        this.energyToGetAfterDelay = 0;
    }

    private void collectGains(){
        this.state.setFood(this.state.getFood() + foodToGetAfterDelay);
        this.state.setMaterials(this.state.getMaterials() + materialsToGetAfterDelay);
        this.state.setEnergy(this.state.getEnergy() + energyToGetAfterDelay);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getFoodToGetAfterDelay() {
        return foodToGetAfterDelay;
    }

    public void setFoodToGetAfterDelay(int foodToGetAfterDelay) {
        this.foodToGetAfterDelay = foodToGetAfterDelay;
    }

    public int getMaterialsToGetAfterDelay() {
        return materialsToGetAfterDelay;
    }

    public void setMaterialsToGetAfterDelay(int materialsToGetAfterDelay) {
        this.materialsToGetAfterDelay = materialsToGetAfterDelay;
    }

    public int getEnergyToGetAfterDelay() {
        return energyToGetAfterDelay;
    }

    public void setEnergyToGetAfterDelay(int energyToGetAfterDelay) {
        this.energyToGetAfterDelay = energyToGetAfterDelay;
    }

    public ActionTypes getLeadingActionType() {
        return leadingActionType;
    }

    public void setLeadingActionType(ActionTypes leadingActionType) {
        this.leadingActionType = leadingActionType;
    }

    public ArrayList<Node> getChildren(ResourcesMetrics resourcesMetrics){
        ArrayList<Node> children = new ArrayList<>();

        State nextStateFromWait = Actions.WAIT(this.state, resourcesMetrics);
        if(!nextStateFromWait.equals(this.state)){
            children.add(new Node(nextStateFromWait, this, ActionTypes.WAIT));
        }

        State nextStateFromBuild1 = Actions.BUILD1(this.state, resourcesMetrics);
        if(!nextStateFromBuild1.equals(this.state)){
            children.add(new Node(nextStateFromBuild1, this, ActionTypes.BUILD1));
        }

        State nextStateFromBuild2 = Actions.BUILD2(this.state, resourcesMetrics);
        if(!nextStateFromBuild2.equals(this.state)){
            children.add(new Node(nextStateFromBuild2, this, ActionTypes.BUILD2));
        }

        if(this.delay == 0){
            State nextStateFromRequestFood = Actions.RequestFood(this.state, resourcesMetrics);
            if(!nextStateFromRequestFood.equals(this.state)){
                children.add(new Node(nextStateFromRequestFood, resourcesMetrics.getDelayRequestFood(), resourcesMetrics.getAmountRequestFood(),0,0, ActionTypes.RequestFood));
            }

            State nextStateFromRequestMaterials = Actions.RequestMaterials(this.state, resourcesMetrics);
            if(!nextStateFromRequestMaterials.equals(this.state)){
                children.add(new Node(nextStateFromRequestMaterials, resourcesMetrics.getDelayRequestMaterials(), 0, resourcesMetrics.getAmountRequestMaterials(), 0, ActionTypes.RequestMaterials));
            }

            State nextStateFromRequestEnergy = Actions.RequestEnergy(this.state, resourcesMetrics);
            if(!nextStateFromRequestEnergy.equals(this.state)){
                children.add(new Node(nextStateFromRequestEnergy, resourcesMetrics.getDelayRequestEnergy(), 0,0, resourcesMetrics.getAmountRequestEnergy(), ActionTypes.RequestEnergy));
            }
        }


        return children;
    }

}
