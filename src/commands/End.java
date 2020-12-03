package commands;

import turtle.common.Turtle;
import visitor.*;

public class End extends Command {
	@Override
	public String toString() {
		return "end";
	}

	@Override
	public void execute(Turtle aTurtle) {
		//stub
	}

	@Override
	public void accept(IVisitor anICommandVisitor, Turtle aTurtle) {
		anICommandVisitor.visit(this, aTurtle);
	}

	@Override
	public void undo(Turtle turtle) {
		//stub
	}

}
