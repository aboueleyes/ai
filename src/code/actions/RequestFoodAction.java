package code.actions;

import code.Node;
import code.State;

public class RequestFoodAction extends Action{


    private int delay;

    private int amount;

    public RequestFoodAction(int foodPrice, int materialsPrice, int energyPrice, int delay, int amount){
        super("RequestFood", foodPrice, materialsPrice, energyPrice);
        this.delay = delay;
        this.amount = amount;
    }

    @Override
    public Node apply(Node node) {
        State nextState = this.getNextState(node.getState());
        if(node.getDelay()>0 || nextState.equals(node.getState())){
            return null;
        }
        return new Node(nextState, this.delay, this.amount, 0,0, this.getName());
    }
}
