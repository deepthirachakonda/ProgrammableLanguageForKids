package visitor;

import turtle.common.*;
import commands.*;


public interface IVisitor {
	public void visit(Assignment anAssignment, Turtle aTurtle);

	public void visit(End anEnd, Turtle aTurtle);

	public void visit(Move aMove, Turtle aTurtle);

	public void visit(Repeat aRepeat, Turtle aTurtle);

	public void visit(Turn aTurn, Turtle aTurtle);

	public void visit(DistanceTo distanceTo, Turtle aTurtle);

	public void visit(BearingTo bearingTo, Turtle aTurtle);

	public void visit(NullCommand nullCommand, Turtle aTurtle);

	public void visit(Turtle turtle, Turtle turtle2);
}
