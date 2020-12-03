package interpreter;

import java.util.ArrayList;
import java.util.Map;
import turtle.common.*;
import commands.Assignment;
import commands.BearingTo;
import commands.Command;
import commands.DistanceTo;
import commands.NullCommand;


/**
 * To interpret vector values
 *
 */
public class PointInterpreter implements IInterpreter{

	private String expression;
	
	public PointInterpreter(String line){
		this.expression = line.trim();
	}
	
	public String[] splitter(String delimiter) {
		return expression.split(delimiter);
	}
	
	@Override
	public Command interpret(Map<String, ArrayList<Double>> variables) {
		Command cmd = new NullCommand(expression);
		if(expression.startsWith("#") && expression.contains("=")) {
			
			if(expression.contains(",")) {
				//Parse for point coordinates
				
				String[] exprSplits = splitter("=");
				ArrayList<Double> point = new ArrayList<Double>();
				String[] coordinate = exprSplits[1].split(",");
				point.add(Double.parseDouble(coordinate[0].trim()));
				point.add(Double.parseDouble(coordinate[1].trim()));
				
				//substring starts at index 2, because var name is after #P
				String pointName = exprSplits[0].substring(2).trim();				
				variables.put(pointName, point);
				cmd = new Assignment(pointName, point);
			}else if(expression.contains("distanceTo")) {
				String[] exprSplits = splitter("distanceTo");
				String toPoint = exprSplits[1].trim().substring(1);
				
				ArrayList<Double> cachedPoint = variables.get(toPoint);
				Point destination = new Point(cachedPoint.get(0), cachedPoint.get(1));
				
				cmd = new DistanceTo(expression.split("=")[0].trim().substring(1), destination);
				
			}else if(expression.contains("bearingTo")) {
				String[] exprSplits = splitter("bearingTo");
				String toPoint = exprSplits[1].trim().substring(1);
				
				ArrayList<Double> cachedPoint = variables.get(toPoint);
				Point destination = new Point(cachedPoint.get(0), cachedPoint.get(1));
				
				cmd = new BearingTo(expression.split("=")[0].trim().substring(1), destination);
			}
		}
		return cmd;
	}

}
