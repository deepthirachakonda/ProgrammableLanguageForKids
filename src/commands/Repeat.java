package commands;

import turtle.common.Turtle;
import visitor.*;

public class Repeat extends Command {
	private int count;

	public Repeat(int count) {
		this.setCount(count);
	}

	@Override
	public String toString() {
		return "repeat";
	}

	@Override
	public void execute(Turtle aTurtle) {
		//Stub
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void accept(IVisitor anICommandVisitor, Turtle aTurtle) {
		anICommandVisitor.visit(this, aTurtle);
	}

	@Override
	public void undo(Turtle turtle) {
		//  method stub
	}
}
