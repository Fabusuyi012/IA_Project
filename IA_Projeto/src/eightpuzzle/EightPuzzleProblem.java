package eightpuzzle;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EightPuzzleProblem extends Problem<EightPuzzleState> {


    public EightPuzzleProblem(EightPuzzleState initialState) {
        super(initialState, new ArrayList<Action>());
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());
    }

    @Override
    public List<EightPuzzleState> executeActions(EightPuzzleState state) {
        List<EightPuzzleState> successors = new LinkedList<EightPuzzleState>();
        
        for(Action a: actions){ //ver a todas as pecas
            if(a.isValid(state)){
                EightPuzzleState successor = (EightPuzzleState) state.clone();
                successor.executeAction(a);
                successors.add(successor);
            }
        }
        return successors;
    }

    @Override
    public boolean isGoal(EightPuzzleState state) {
        return state.getColunaCarro() == state.getNumColumns()-1;
    }
    
    @Override
    public double computePathCost(List<Action> path) {
        return path.size();
    }
    

}
