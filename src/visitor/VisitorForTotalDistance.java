package visitor;

import turtle.common.*;
import commands.*;

/**
 * A visitor to calculate total distance traveled by turtle
 *
 */
public class VisitorForTotalDistance implements IVisitor {
	@Override
	public void visit(Assignment assignment, Turtle turtle) {
		assignment.execute(turtle);
	}

	@Override
	public void visit(End end, Turtle turtle) {
		end.execute(turtle);
	}

	@Override
	public void visit(Move move, Turtle turtle) {
		move.totalDistanceExecute(turtle);
	}

	@Override
	public void visit(Repeat repeat, Turtle turtle) {
		repeat.execute(turtle);
	}

	@Override
	public void visit(Turn turn, Turtle turtle) {
		turn.execute(turtle);
	}

	@Override
	public void visit(Turtle aTurtle, Turtle bTurtle) {
		aTurtle.execute(bTurtle);
	}

	@Override
	public void visit(DistanceTo distanceTo, Turtle turtle) {
		distanceTo.execute(turtle);
		
	}
	
	@Override
	public void visit(BearingTo bearingTo, Turtle turtle) {
		bearingTo.execute(turtle);
		
	}
	
	@Override
	public void visit(NullCommand nullCommand, Turtle turtle) {
		nullCommand.execute(turtle);
		
	}
}
