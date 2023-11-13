package code.actions;

import code.Node;
import code.State;

public class RequestEnergyAction extends Action {


    private final int delay;

    private final int amount;

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
        return new Node(nextState, this.delay, 0,0,
                this.amount, this.getName(), node);
    }
}