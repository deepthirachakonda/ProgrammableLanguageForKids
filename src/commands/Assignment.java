package commands;

import java.util.ArrayList;

import turtle.common.Turtle;
import visitor.*;

public class Assignment extends Command {
	private String lValue;
	private ArrayList<Double> rValue;

	public Assignment(String varName, ArrayList<Double> rValue) {
		this.lValue = varName;
		this.rValue = rValue;
	}

	@Override
	public String toString() {
		return "assignment";
	}

	@Override
	public void execute(Turtle aTurtle) {
		aTurtle.addVariable(lValue, rValue);
	}

	@Override
	public void accept(IVisitor anICommandVisitor, Turtle aTurtle) {
		anICommandVisitor.visit(this, aTurtle);
	}

	@Override
	public void undo(Turtle turtle) {
		turtle.removeVariable(lValue);
	}
}
