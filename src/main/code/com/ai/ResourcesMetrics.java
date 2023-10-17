package com.ai;

public class ResourcesMetrics {
    private final int unitPriceFood;
    private final int unitPriceMaterials;
    private final int unitPriceEnergy;
    private final int amountRequestFood;
    private final int delayRequestFood;
    private final int amountRequestMaterials;
    private final int delayRequestMaterials;
    private final int amountRequestEnergy;
    private final int delayRequestEnergy;
    private final int priceBUILD1;
    private final int foodUseBUILD1;
    private final int materialsUseBUILD1;
    private final int energyUseBUILD1;
    private final int prosperityBUILD1;
    private final int priceBUILD2;
    private final int foodUseBUILD2;
    private final int materialsUseBUILD2;
    private final int energyUseBUILD2;
    private final int prosperityBUILD2;

    public ResourcesMetrics(int unitPriceFood, int unitPriceMaterials, int unitPriceEnergy, int amountRequestFood,
                     int delayRequestFood, int amountRequestMaterials, int delayRequestMaterials, int amountRequestEnergy,
                     int delayRequestEnergy, int priceBUILD1, int foodUseBUILD1, int materialsUseBUILD1, int energyUseBUILD1,
                     int prosperityBUILD1, int priceBUILD2, int foodUseBUILD2, int materialsUseBUILD2, int energyUseBUILD2,
                     int prosperityBUILD2) {
        this.unitPriceFood = unitPriceFood;
        this.unitPriceMaterials = unitPriceMaterials;
        this.unitPriceEnergy = unitPriceEnergy;
        this.amountRequestFood = amountRequestFood;
        this.delayRequestFood = delayRequestFood;
        this.amountRequestMaterials = amountRequestMaterials;
        this.delayRequestMaterials = delayRequestMaterials;
        this.amountRequestEnergy = amountRequestEnergy;
        this.delayRequestEnergy = delayRequestEnergy;
        this.priceBUILD1 = priceBUILD1;
        this.foodUseBUILD1 = foodUseBUILD1;
        this.materialsUseBUILD1 = materialsUseBUILD1;
        this.energyUseBUILD1 = energyUseBUILD1;
        this.prosperityBUILD1 = prosperityBUILD1;
        this.priceBUILD2 = priceBUILD2;
        this.foodUseBUILD2 = foodUseBUILD2;
        this.materialsUseBUILD2 = materialsUseBUILD2;
        this.energyUseBUILD2 = energyUseBUILD2;
        this.prosperityBUILD2 = prosperityBUILD2;
    }

    public int getUnitPriceFood() {
        return unitPriceFood;
    }

    public int getUnitPriceMaterials() {
        return unitPriceMaterials;
    }

    public int getUnitPriceEnergy() {
        return unitPriceEnergy;
    }

    public int getAmountRequestFood() {
        return amountRequestFood;
    }

    public int getDelayRequestFood() {
        return delayRequestFood;
    }

    public int getAmountRequestMaterials() {
        return amountRequestMaterials;
    }

    public int getDelayRequestMaterials() {
        return delayRequestMaterials;
    }

    public int getAmountRequestEnergy() {
        return amountRequestEnergy;
    }

    public int getDelayRequestEnergy() {
        return delayRequestEnergy;
    }

    public int getPriceBUILD1() {
        return priceBUILD1;
    }

    public int getFoodUseBUILD1() {
        return foodUseBUILD1;
    }

    public int getMaterialsUseBUILD1() {
        return materialsUseBUILD1;
    }

    public int getEnergyUseBUILD1() {
        return energyUseBUILD1;
    }

    public int getProsperityBUILD1() {
        return prosperityBUILD1;
    }

    public int getPriceBUILD2() {
        return priceBUILD2;
    }

    public int getFoodUseBUILD2() {
        return foodUseBUILD2;
    }

    public int getMaterialsUseBUILD2() {
        return materialsUseBUILD2;
    }

    public int getEnergyUseBUILD2() {
        return energyUseBUILD2;
    }

    public int getProsperityBUILD2() {
        return prosperityBUILD2;
    }
}
