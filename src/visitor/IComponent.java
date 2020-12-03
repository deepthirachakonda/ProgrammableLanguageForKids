package visitor;

import turtle.common.*;

public interface IComponent {
	public void accept(IVisitor anICommandVisitor, Turtle aTurtle);
	
	public abstract void undo(Turtle turtle);

	public abstract String toString();

	public void execute(Turtle aTurtle);
	
	public boolean isNull();
}
