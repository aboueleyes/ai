package com.ai.actions;

import com.ai.Node;
import com.ai.State;

public class RequestEnergyAction extends Action {


    private int delay;

    private int amount;

    public RequestEnergyAction(int foodPrice, int materialsPrice, int energyPrice, int delay, int amount){
        super("RequestEnergy", foodPrice, materialsPrice, energyPrice);
        this.delay = delay;
        this.amount = amount;
    }

    @Override
    public Node apply(Node node) {
        State nextState = this.getNextState(node.getState());
        if(node.getDelay()>0 || nextState.equals(node.getState())){
            return null;
        }
        return new Node(nextState, this.delay, 0,0, this.amount, this.getName());
    }
}