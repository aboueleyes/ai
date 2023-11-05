package com.ai.actions;

import com.ai.Node;
import com.ai.State;

public abstract class Action {

    private final String name;
    private final int foodPrice;
    private final int materialsPrice;
    private final int energyPrice;
    protected Action(String name, int foodPrice, int materialsPrice, int energyPrice) {
        this.name = name;
        this.foodPrice = foodPrice;
        this.materialsPrice = materialsPrice;
        this.energyPrice = energyPrice;
    }

    public String getName() {
        return name;
    }

    private int calculateMoneySpent(int foodUsed, int materialsUsed, int energyUsed, int extraCost){
        int foodCost = foodUsed * this.foodPrice;
        int materialsCost = materialsUsed * this.materialsPrice;
        int energyCost = energyUsed * this.energyPrice;

        return foodCost + materialsCost + energyCost + extraCost;
    }

    public State getNextState(State state, int foodUsed, int materialsUsed, int energyUsed, int extraCost, int prosperity){
        int nextProsperity = state.getProsperity() + prosperity;
        int nextMoneySpent = state.getMoneySpent() + calculateMoneySpent(foodUsed, materialsUsed, energyUsed, extraCost);
        int nextFood = state.getFood() - foodUsed;
        int nextMaterials = state.getMaterials() - materialsUsed;
        int nextEnergy = state.getEnergy() - energyUsed;

        if(nextFood<0 || nextMaterials<0 || nextEnergy<0 || nextMoneySpent>100000){
            return state;
        }

        return new State(nextProsperity, nextFood, nextMaterials, nextEnergy, nextMoneySpent);
    }

    public State getNextState(State state){
        return  getNextState(state, 1, 1, 1, 0,0);
    }

    public abstract Node apply(Node node);

}