package com.ai;

public class Parser {
    public State parseState(String input) {
        String[] parts = input.split("[;,]");
        int initialProsperity = Integer.parseInt(parts[0]);
        int[] initialResources = { Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]) };
        return new State(initialProsperity, initialResources[0], initialResources[1],
                initialResources[2], 0);
    }

    public ResourcesMetrics parseResourcesMetrics(String input) {
        String[] parts = input.split("[;,]");
        int unitPriceFood = Integer.parseInt(parts[4]);
        int unitPriceMaterials = Integer.parseInt(parts[5]);
        int unitPriceEnergy = Integer.parseInt(parts[6]);
        int amountRequestFood = Integer.parseInt(parts[7]);
        int delayRequestFood = Integer.parseInt(parts[8]);
        int amountRequestMaterials = Integer.parseInt(parts[9]);
        int delayRequestMaterials = Integer.parseInt(parts[10]);
        int amountRequestEnergy = Integer.parseInt(parts[11]);
        int delayRequestEnergy = Integer.parseInt(parts[12]);
        int priceBUILD1 = Integer.parseInt(parts[13]);
        int foodUseBUILD1 = Integer.parseInt(parts[14]);
        int materialsUseBUILD1 = Integer.parseInt(parts[15]);
        int energyUseBUILD1 = Integer.parseInt(parts[16]);
        int prosperityBUILD1 = Integer.parseInt(parts[17]);
        int priceBUILD2 = Integer.parseInt(parts[18]);
        int foodUseBUILD2 = Integer.parseInt(parts[19]);
        int materialsUseBUILD2 = Integer.parseInt(parts[20]);
        int energyUseBUILD2 = Integer.parseInt(parts[21]);
        int prosperityBUILD2 = Integer.parseInt(parts[22]);
        return new ResourcesMetrics(unitPriceFood, unitPriceMaterials, unitPriceEnergy, amountRequestFood,
                delayRequestFood, amountRequestMaterials, delayRequestMaterials, amountRequestEnergy,
                delayRequestEnergy, priceBUILD1, foodUseBUILD1, materialsUseBUILD1, energyUseBUILD1,
                prosperityBUILD1, priceBUILD2, foodUseBUILD2, materialsUseBUILD2, energyUseBUILD2,
                prosperityBUILD2);
    }

}