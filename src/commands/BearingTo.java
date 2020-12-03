package commands;

import java.util.ArrayList;

import turtle.common.*;
import visitor.IVisitor;
import utils.*;

public class BearingTo extends Command{
	private String lValue;
	private Point varPoint;

	public BearingTo(String aString, Point destination) {
		this.lValue = aString;
		this.varPoint = destination;
	}

	@Override
	public String toString() {
		return "bearingTo";
	}

	@Override
	public void execute(Turtle aTurtle) {
		ArrayList<Double> bearing = new ArrayList<Double>();
		bearing.add(ConversionUtils.calculateBearing(varPoint, aTurtle.getLocation()));
		aTurtle.addVariable(lValue, bearing);
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
