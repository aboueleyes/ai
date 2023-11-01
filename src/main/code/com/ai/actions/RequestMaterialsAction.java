package com.ai.actions;

import com.ai.Node;
import com.ai.State;

public class RequestMaterialsAction extends Action {


    private int delay;

    private int amount;

    public RequestMaterialsAction(int foodPrice, int materialsPrice, int energyPrice, int delay, int amount){
        super("RequestMaterials", foodPrice, materialsPrice, energyPrice);
        this.delay = delay;
        this.amount = amount;
    }

    @Override
    public Node apply(Node node) {
        State nextState = this.getNextState(node.getState());
        if(node.getDelay()>0 || nextState.equals(node.getState())){
            return null;
        }
        return new Node(nextState, this.delay, 0, this.amount, 0, this.getName());
    }
}
