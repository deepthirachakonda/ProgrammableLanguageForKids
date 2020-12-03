package interpreter;

public class InterpreterFactory {
	/**
	 * Two types of interpreters defined for turtle program
	 * 
	 * 1. To interpret commands involving scalar commands -> (move, turn, repeat, end, assign a variable)
	 * 2. To interpret commands involving "vector" commands (Point) -> (assign a point, distanceTo, bearingTo)
	 * 
	 * @param expression
	 * @return Command
	 */
	public static IInterpreter getInterpreter(String expression) {
		if(expression.contains(",") || expression.contains("distanceTo") || expression.contains("bearingTo")) {
			return new PointInterpreter(expression);
		}else {
			return new ScalarInterpreter(expression);
		}
	}

}
