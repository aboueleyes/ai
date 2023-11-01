package com.ai;

public class Actions {

    public static State RequestFood(State initialState, ResourcesMetrics resourcesMetrics){
        return GetIntermediateState(initialState, resourcesMetrics);
    }

    public static State RequestMaterials(State initialState, ResourcesMetrics resourcesMetrics){
        return GetIntermediateState(initialState, resourcesMetrics);
    }

    public static State RequestEnergy(State initialState, ResourcesMetrics resourcesMetrics){
        return GetIntermediateState(initialState, resourcesMetrics);
    }

    public static State WAIT(State initialState, ResourcesMetrics resourcesMetrics){
        return GetIntermediateState(initialState, resourcesMetrics);
    }

    public static State BUILD1(State initialState, ResourcesMetrics resourcesMetrics){
        int nextProsperity = initialState.getProsperity() + resourcesMetrics.getProsperityBUILD1();
        int nextMoneySpent = initialState.getMoneySpent() +
                CalculateMoneySpent(resourcesMetrics, resourcesMetrics.getFoodUseBUILD1(), resourcesMetrics.getMaterialsUseBUILD1(), resourcesMetrics.getEnergyUseBUILD1(), resourcesMetrics.getPriceBUILD1());
        int nextFood = initialState.getFood() - resourcesMetrics.getFoodUseBUILD1();
        int nextMaterials = initialState.getMaterials() - resourcesMetrics.getMaterialsUseBUILD1();
        int nextEnergy = initialState.getEnergy() - resourcesMetrics.getEnergyUseBUILD1();

        if(nextFood<0 || nextMaterials<0 || nextEnergy<0){
            return initialState;
        }

        return new State(nextProsperity, nextFood, nextMaterials, nextEnergy, nextMoneySpent);
    }

    public static State BUILD2(State initialState, ResourcesMetrics resourcesMetrics){
        int nextProsperity = initialState.getProsperity() + resourcesMetrics.getProsperityBUILD2();
        int nextMoneySpent = initialState.getMoneySpent() +
                CalculateMoneySpent(resourcesMetrics, resourcesMetrics.getFoodUseBUILD2(), resourcesMetrics.getMaterialsUseBUILD2(), resourcesMetrics.getEnergyUseBUILD2(), resourcesMetrics.getPriceBUILD2());
        int nextFood = initialState.getFood() - resourcesMetrics.getFoodUseBUILD2();
        int nextMaterials = initialState.getMaterials() - resourcesMetrics.getMaterialsUseBUILD2();
        int nextEnergy = initialState.getEnergy() - resourcesMetrics.getEnergyUseBUILD2();

        if(nextFood<0 || nextMaterials<0 || nextEnergy<0){
            return initialState;
        }

        return new State(nextProsperity, nextFood, nextMaterials, nextEnergy, nextMoneySpent);
    }

    private static int CalculateMoneySpent(ResourcesMetrics resourcesMetrics, int foodUsed, int materialsUsed, int energyUsed, int extraCost){
        int foodCost = foodUsed * resourcesMetrics.getUnitPriceFood();
        int materialsCost = materialsUsed * resourcesMetrics.getUnitPriceMaterials();
        int energyCost = energyUsed * resourcesMetrics.getUnitPriceEnergy();

        return foodCost + materialsCost + energyCost + extraCost;
    }

    private static int CalculateMoneySpent(ResourcesMetrics resourcesMetrics){
        int foodCost = resourcesMetrics.getUnitPriceFood();
        int materialsCost = resourcesMetrics.getUnitPriceMaterials();
        int energyCost = resourcesMetrics.getUnitPriceEnergy();

        return foodCost + materialsCost + energyCost;
    }

    private static State GetIntermediateState(State initialState, ResourcesMetrics resourcesMetrics){
        int nextProsperity = initialState.getProsperity();
        int nextMoneySpent = initialState.getMoneySpent() + CalculateMoneySpent(resourcesMetrics);
        int nextFood = initialState.getFood() - 1;
        int nextMaterials = initialState.getMaterials() - 1;
        int nextEnergy = initialState.getEnergy() - 1;

        if(nextFood<0 || nextMaterials<0 || nextEnergy<0){
            return initialState;
        }

        return new State(nextProsperity, nextFood, nextMaterials, nextEnergy, nextMoneySpent);
    }

}