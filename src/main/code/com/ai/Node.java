package com.ai;

import java.util.ArrayList;

public class Node {

    private State state;
    private int delay;
    private int foodToGetAfterDelay;
    private int materialsToGetAfterDelay;
    private int energyToGetAfterDelay;

    public Node(State state, int delay, int foodToGetAfterDelay, int materialsToGetAfterDelay, int energyToGetAfterDelay) {
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
    }

    public Node(State state, Node previous){
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

    public ArrayList<Node> getChildren(ResourcesMetrics resourcesMetrics){
        ArrayList<Node> children = new ArrayList<>();

        State nextStateFromWait = Actions.WAIT(this.state, resourcesMetrics);
        if(!nextStateFromWait.equals(this.state)){
            children.add(new Node(nextStateFromWait, this));
        }

        State nextStateFromBuild1 = Actions.BUILD1(this.state, resourcesMetrics);
        if(!nextStateFromBuild1.equals(this.state)){
            children.add(new Node(nextStateFromBuild1, this));
        }

        State nextStateFromBuild2 = Actions.BUILD2(this.state, resourcesMetrics);
        if(!nextStateFromBuild2.equals(this.state)){
            children.add(new Node(nextStateFromBuild2, this));
        }

        if(this.delay == 0){
            State nextStateFromRequestFood = Actions.RequestFood(this.state, resourcesMetrics);
            if(!nextStateFromRequestFood.equals(this.state)){
                children.add(new Node(nextStateFromRequestFood, resourcesMetrics.getDelayRequestFood(), resourcesMetrics.getAmountRequestFood(),0,0));
            }

            State nextStateFromRequestMaterials = Actions.RequestMaterials(this.state, resourcesMetrics);
            if(!nextStateFromRequestMaterials.equals(this.state)){
                children.add(new Node(nextStateFromRequestMaterials, resourcesMetrics.getDelayRequestMaterials(), 0, resourcesMetrics.getAmountRequestMaterials(), 0));
            }

            State nextStateFromRequestEnergy = Actions.RequestEnergy(this.state, resourcesMetrics);
            if(!nextStateFromRequestEnergy.equals(this.state)){
                children.add(new Node(nextStateFromRequestEnergy, resourcesMetrics.getDelayRequestEnergy(), 0,0, resourcesMetrics.getAmountRequestEnergy()));
            }
        }


        return children;
    }

}
