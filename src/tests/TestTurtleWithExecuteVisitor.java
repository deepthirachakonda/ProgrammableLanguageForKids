package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import visitor.*;

import turtle.common.*;

public class TestTurtleWithExecuteVisitor {
	
	@Test
	public void testTurtleBasicExecution() {
		// Theme: test basic total distance and coordinates with execute visitor
		Turtle firstTurtle = new Turtle("turtleProgram.txt");
		firstTurtle.accept(new VisitorForExecute(), firstTurtle);
		assertEquals(firstTurtle.getLocation().getX(), 0.0, 0.0001);
		assertEquals(firstTurtle.getLocation().getY(), 0.0, 0.0001);
	}
	
	@Test
	public void testTurtleExecution() {
		// Theme: prove turtle execution with the example mentioned in assignment doc
		
		Turtle secondTurtle = new Turtle("turtleProgram1.txt");
		secondTurtle.accept(new VisitorForExecute(), secondTurtle);
		assertEquals(secondTurtle.getLocation().getX(), 23, 0.0001);
		assertEquals(secondTurtle.getLocation().getY(), 28, 0.0001);
	}
	
	@Test
	public void testRepeatCommand() {
		// Theme: Testing square draw with repeat command as given in the assignment doc with execute visitor
		
		Turtle turtle = new Turtle("turtleProgram2.txt");
		turtle.accept(new VisitorForExecute(), turtle);

		// Total commands should be compiled to 9
		assertEquals(turtle.getCommands().size(), 9, 0.0001);
		
		// Turtle should return to (0,0)
		assertEquals(turtle.getLocation().getX(), 0.0, 0.0001);
		assertEquals(turtle.getLocation().getY(), 0.0, 0.0001);
	}
	
	@Test
	public void testTurtleExecutionWithPointInterpreter() {
		// Theme: Execute turtle using distanceTo and bearingTo constucts
		Turtle turtle = new Turtle("turtleProgram3.txt");
		turtle.accept(new VisitorForExecute(), turtle);
		// Turtle should return to (0,0)
		assertEquals(turtle.getLocation().getX(), 5.0, 0.0001);
		assertEquals(turtle.getLocation().getY(), 5.0, 0.0001);
	}
	
}
