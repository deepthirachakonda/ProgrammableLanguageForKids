package commands;

import turtle.common.Turtle;
import visitor.*;

public abstract class Command implements IComponent {
	public abstract void execute(Turtle aTurtle);
	
	public abstract void undo(Turtle turtle);
	
	public boolean isNull() {
		return false;
	}

}
