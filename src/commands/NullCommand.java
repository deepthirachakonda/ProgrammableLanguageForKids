package commands;

import turtle.common.Turtle;
import visitor.*;

public class NullCommand extends Command {
	String expression;
	@Override
	public String toString() {
		return "null";
	}
	
	public NullCommand(String expression) {
		this.expression = expression;
	}

	@Override
	public void execute(Turtle aTurtle) {
		System.out.println("Invalid expression formed: " + expression);
	}

	@Override
	public void accept(IVisitor anICommandVisitor, Turtle aTurtle) {
		anICommandVisitor.visit(this, aTurtle);
	}
	
	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public void undo(Turtle turtle) {
		// method stub
	}
}
