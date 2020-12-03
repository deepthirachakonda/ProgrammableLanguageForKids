package interpreter;

import java.util.ArrayList;
import java.util.Map;

import commands.Command;

public interface IInterpreter {
	public Command interpret(Map<String, ArrayList<Double>> variables);
}
