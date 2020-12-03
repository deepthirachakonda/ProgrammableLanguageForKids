package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import turtle.common.Turtle;
import visitor.VisitorForTotalDistance;

public class TestTurtleWithDistanceVisitor {

	@Test
	public void testTurtleTotalDistanceExecution() {
		// Theme: test basic total distance and coordinates with total distance visitor
		
		Turtle turtle = new Turtle("turtleProgram.txt");
		turtle.accept(new VisitorForTotalDistance(), turtle);
		assertEquals(turtle.getLocation().getX(), 0.0, 0.0001);
		assertEquals(turtle.getLocation().getY(), 0.0, 0.0001);
		assertEquals(turtle.getTotalDistance(), 20.0, 0.00001);
	}
	
	@Test
	public void testRepeatCommandWithTotalDistanceVisitor() {
		// Theme: Testing square draw with repeat command as given in the assignment doc with total distance visitor
		
		Turtle firstTurtle = new Turtle("turtleProgram2.txt");
		firstTurtle.accept(new VisitorForTotalDistance(), firstTurtle);

		assertEquals(firstTurtle.getTotalDistance(), 40, 0.0001);
	}
	
	@Test
	public void testCommandWithTotalDistanceVisitor() {
		// Theme: Testing with total distance visitor without repeat command
		
		Turtle firstTurtle = new Turtle("turtleProgram1.txt");
		firstTurtle.accept(new VisitorForTotalDistance(), firstTurtle);

		assertEquals(firstTurtle.getTotalDistance(), 45, 0.0001);
	}

}
