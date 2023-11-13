package code;

import java.util.Objects;

public class State {

    private final int prosperity;
    private int food;
    private int materials;
    private int energy;
    private final int moneySpent;

    public State(int prosperity, int food, int materials, int energy, int moneySpent) {
        this.prosperity = prosperity;
        this.food = food;
        this.materials = materials;
        this.energy = energy;
        this.moneySpent = moneySpent;
    }

    public int getProsperity() {
        return prosperity;
    }

    public int getFood() {
        return food;
    }

    public int getMaterials() {
        return materials;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMoneySpent() {
        return moneySpent;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setMaterials(int materials) {
        this.materials = materials;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "State{" +
                "prosperity=" + prosperity +
                ", food=" + food +
                ", materials=" + materials +
                ", energy=" + energy +
                ", moneySpent=" + moneySpent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return prosperity == state.prosperity && food == state.food && materials == state.materials && energy == state.energy && moneySpent == state.moneySpent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prosperity, food, materials, energy, moneySpent);
    }
}