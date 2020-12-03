package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import turtle.common.Turtle;
import visitor.VisitorForExecute;

public class TestTurtleUndo {

	@Test
	public void testTurtleUndo() {
		// Theme: Test basic undo functionality
		
		Turtle turtle = new Turtle("turtleProgram.txt");
		turtle.accept(new VisitorForExecute(), turtle);
		turtle.undo(turtle);
		assertEquals(turtle.getLocation().getX(), 10.0, 0.0001);
		assertEquals(turtle.getLocation().getY(), 0.0, 0.0001);
	}
	
	
	@Test
	public void testTurtleUndoWithRepeatCommands() {
		// Theme: Undo once with Repeat command in program
		
		Turtle turtle = new Turtle("turtleProgram2.txt");
		turtle.accept(new VisitorForExecute(), turtle);
		
		//Undo once
		turtle.undo(turtle);
		// should undo last 90 out of 4 (so 360-90)
		assertEquals(turtle.getDirection(), 270.0, 0.0001);
		
	}
	
	@Test
	public void testTurtleUndoMultipleTimes() {
		// Theme: Undo twice with Repeat command in program
		
		Turtle turtle = new Turtle("turtleProgram2.txt");
		turtle.accept(new VisitorForExecute(), turtle);
		
		//Undo once
		turtle.undo(turtle);
		// should undo last 90 out of 4 (so 360-90)
		assertEquals(turtle.getDirection(), 270.0, 0.0001);
		
		//Undo again
		turtle.undo(turtle);
		assertEquals(turtle.getDirection(), 270.0, 0.0001);
		
	}

}
