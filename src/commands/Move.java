package commands;

import turtle.common.*;
import utils.ConversionUtils;
import visitor.*;

public class Move extends Command {
	private double distance;
	private Point prevLocation;

	public Move(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "move";
	}

	@Override
	public void execute(Turtle turtle) {
		prevLocation = turtle.getLocation();
		turtle.setLocation(
				ConversionUtils.calculateMoveDestination(turtle.getLocation(), turtle.getDirection(), distance));
	}
	
	public void totalDistanceExecute(Turtle turtle) {
		turtle.setTotalDistance(turtle.getTotalDistance() + distance);
	}

	@Override
	public void accept(IVisitor anICommandVisitor, Turtle aTurtle) {
		anICommandVisitor.visit(this, aTurtle);
	}

	@Override
	public void undo(Turtle turtle) {
		turtle.setLocation(prevLocation);
	}


}
