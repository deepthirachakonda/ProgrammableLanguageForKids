package interpreter;

import java.util.*;
import commands.*;

/**
 * To interpret Scalar values
 *
 */
public class ScalarInterpreter implements IInterpreter{
	private String expression;

	public ScalarInterpreter(String expression) {
		this.expression = expression.trim();
	}

	private ArrayList<Double> lookUpForCache(Map<String, ArrayList<Double>> variables) {
		ArrayList<Double> rValue = new ArrayList<Double>();
		ArrayList<Double> defaultVals = new ArrayList<Double>();
		defaultVals.add(0.0);
		String rightSubString = expression.split(" ")[1];
		if (rightSubString.contains("#")) {
			rValue = variables.getOrDefault(rightSubString.substring(1), defaultVals);
		} else {
			rValue.add(Double.parseDouble(expression.split(" ")[1]));
		}
		return rValue;
	}
	
	@Override
	public Command interpret(Map<String, ArrayList<Double>> variables) {
		Command cmd  = new NullCommand(expression);;
		ArrayList<Double> rValue = new ArrayList<Double>();
		
		if (expression.contains("=") && !expression.contains(",")) {
			rValue.add(Double.parseDouble(expression.split("=")[1].trim()));
			variables.put(expression.split("=")[0].substring(1).trim(), rValue);
			cmd = new Assignment(expression.split(" ")[0], rValue);
		} else if (expression.contains("repeat")) {
			cmd = new Repeat(lookUpForCache(variables).get(0).intValue());
		} else if (expression.contains("end")) {
			cmd = new End();
		} else if (expression.contains("move")) {
			cmd = new Move(lookUpForCache(variables).get(0));
		} else if (expression.contains("turn")) {
			cmd = new Turn(lookUpForCache(variables).get(0));
		} 
		return cmd;
	}

}
