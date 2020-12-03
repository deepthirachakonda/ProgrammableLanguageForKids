package commands;

import turtle.common.Turtle;
import visitor.*;

public class Turn extends Command {
	private double direction;
	private double prevDirection;

	public Turn(double direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "turn";
	}

	@Override
	public void execute(Turtle aTurtle) {
		prevDirection = aTurtle.getDirection();
		aTurtle.setDirection(prevDirection + direction);
	}

	@Override
	public void accept(IVisitor anICommandVisitor, Turtle aTurtle) {
		anICommandVisitor.visit(this, aTurtle);
	}

	@Override
	public void undo(Turtle turtle) {
		turtle.setDirection(prevDirection);
	}
}
