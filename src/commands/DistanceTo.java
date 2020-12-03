package commands;

import java.util.ArrayList;

import turtle.common.*;
import visitor.IVisitor;
import utils.*;

public class DistanceTo extends Command{
	private String lValue;
	private Point endPoint;

	public DistanceTo(String aString, Point destination) {
		this.lValue = aString;
		this.endPoint = destination;
	}

	@Override
	public String toString() {
		return "distanceTo";
	}

	@Override
	public void execute(Turtle aTurtle) {
		ArrayList<Double> distance = new ArrayList<Double>();
		distance.add(ConversionUtils.calculateEuclideanDistance(aTurtle.getLocation(), endPoint));
		aTurtle.addVariable(lValue, distance);
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
