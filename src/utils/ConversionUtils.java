package utils;

import turtle.common.*;


public class ConversionUtils {

	/**
	 * Util function to convert degrees to radians
	 * @param degrees
	 * @return radians
	 */
	public static double degreesToRadians(double degrees) {
		return (degrees * Math.PI) / 180;
	}
	
	
	/**
	 * Util function to calculate bearing angle given a two Points
	 * @param varPosition
	 * @param turtlePosition
	 * @return
	 */
	public static double calculateBearing(Point varPosition, Point turtlePosition) {

		return Math.toDegrees(
				Math.atan((varPosition.getY() - turtlePosition.getY()) / (varPosition.getX() - turtlePosition.getX())));
	}

	/**
	 * Util function to calculate Euclidean distance between two points
	 * @param start
	 * @param end
	 * @return
	 */
	public static double calculateEuclideanDistance(Point start, Point end) {
		return Math.sqrt(Math.pow(start.getX() - start.getY(), 2) + Math.pow(end.getX() - end.getY(), 2));
	}
	
	/**
	 * Util function to calculate destination point given a point, angle and distance to travel
	 * @param currPosition
	 * @param degrees
	 * @param distance
	 * @return
	 */
	public static Point calculateMoveDestination(Point currPosition, double degrees, double distance) {
		double radians = ConversionUtils.degreesToRadians(degrees);
		double delX = Math.cos(radians) * distance;
		double delY = Math.sin(radians) * distance;
		Point destination = new Point();
		destination.setX(Math.round(currPosition.getX() + delX));
		destination.setY(Math.round(currPosition.getY() + delY));
		return destination;
	}
}
