package turtle.common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import commands.*;
import interpreter.*;
import visitor.*;


public class Turtle implements IComponent{

	private double directionInDegrees;
	private double totalDistance;
	private Point currLocation;
	private ArrayList<IComponent> commands = new ArrayList<IComponent>();
	// This variable is used to keep track of executed commands and undo respective command
	private ArrayList<IComponent> executedCommands = new ArrayList<IComponent>();
	private Map<String, ArrayList<Double>> variables;
	private IVisitor commandVisitor;

	public Turtle(String fileName) {
		setLocation(new Point());
		setDirection(0);
		variables = new HashMap<String, ArrayList<Double>>();
		try {
			File file = new File(new File(".").getCanonicalPath() + File.separator
					+ fileName);
			FileInputStream inStream = new FileInputStream(file);
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(inStream));
			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				IInterpreter interpreter = InterpreterFactory.getInterpreter(line);
				commands.add((IComponent) interpreter.interpret(variables));
			}
			commands = expandRepeatCommands();
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initial Repeat commands are extrapolated to individual calls to commands to execute sequentially
	 * @return List of expanded commands for Repeat commands
	 */
	private ArrayList<IComponent> expandRepeatCommands() {
		ArrayList<IComponent> expandedCommands = new ArrayList<IComponent>();
		
		Iterator<IComponent> anIterator = commands.iterator();
		while (anIterator.hasNext()) {
			IComponent currCommand = anIterator.next();
			if (currCommand.toString() == "repeat") {
				int loopCount = ((Repeat) currCommand).getCount();
				ArrayList<IComponent> repeatList = new ArrayList<IComponent>();
				while (anIterator.hasNext()) {
					currCommand = anIterator.next();
					if (currCommand.toString() != "end") {
						repeatList.add(currCommand);
					}
				}
				for (;loopCount > 0;loopCount--) {
					for (Iterator<IComponent> repeatIterator = repeatList
							.iterator(); repeatIterator.hasNext();) {
						expandedCommands.add(repeatIterator.next());
					}
				}
			} else {
				expandedCommands.add(currCommand);
			}
		}
		return expandedCommands;
	}
	

	/**
	 * A visitor must be set after turtle object construction, which will then visit all the commands
	 * @param anICommandVisitor
	 */
	@Override
	public void accept(IVisitor anICommandVisitor, Turtle turtle) {
		this.commandVisitor = anICommandVisitor;
		this.commandVisitor.visit(this, turtle);
	}

	/**
	 * Execute function will be visited by the respective visitor using double dispatch
	 */
	@Override
	public void execute(Turtle turtle) {
		executedCommands.clear();
		Iterator<IComponent> anIterator = commands.iterator();
		while (anIterator.hasNext()) {
			IComponent aCommand = anIterator.next();
			if(!aCommand.isNull()) {
				aCommand.accept(commandVisitor, turtle);
				executedCommands.add(aCommand);
			}
			
		}
	}
	
	/**
	 * An API call to undo will undo last move by the turtle just before the call
	 * Undo can be called multiple times, to undo last n moves
	 */
	@Override
	public void undo(Turtle turtle) {
		IComponent cmd = executedCommands.get(executedCommands.size()-1);
		cmd.undo(turtle);
		executedCommands.remove(executedCommands.size()-1);
	}
	
	@Override
	public boolean isNull() {
		return false;
	}
	
	//---------------------------- Getters and setters ----------------//
	
	/**
	 * Get total distance traveled by the turtle using VisitorForDistance
	 * @return distance
	 */
	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}
	
	/**
	 * Get list of commands to execute
	 * @return commands
	 */
	public ArrayList<IComponent> getCommands(){
		return commands;
	}

	/**
	 * Add a variable to be shared across commands
	 * @param aString: key
	 * @param aValue: value
	 */
	public void addVariable(String aString, ArrayList<Double> aValue) {
		variables.put(aString, aValue);
	}
	
	/**
	 * Remove variable from map
	 * @param key
	 */
	public void removeVariable(String key) {
		variables.remove(key);
	}

	/**
	 * Get turtle's current location
	 * @return
	 */
	public Point getLocation() {
		return currLocation;
	}

	/**
	 * Set location to a different point when a move command is executed
	 * @param location
	 */
	public void setLocation(Point location) {
		this.currLocation = location;
	}

	/**
	 * Get current direction in degrees
	 * @return
	 */
	public double getDirection() {
		return directionInDegrees;
	}

	/**
	 * Set current direction in degrees
	 * @param direction
	 */
	public void setDirection(double direction) {
		this.directionInDegrees = direction;
	}
	
	public String toString() {
		return "turtle";
	}

}
