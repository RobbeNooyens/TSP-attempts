package me.robnoo02.travellingsalesman.points;

import java.util.LinkedList;
import java.util.Random;

import me.robnoo02.travellingsalesman.utils.DebugUtil.DebugState;
import me.robnoo02.travellingsalesman.utils.TimerUtil;

public class SimulationGenerator {
	
	private static final int SQR_SIZE = 400; // How far from the middle of the center points can spawn.

	public static LinkedList<CityPoint> randomCityPoints(int amount){
		TimerUtil timer = new TimerUtil();
		Random random = new Random();
		LinkedList<CityPoint> output = new LinkedList<>();
		for (int i = 0; i < amount; i++)
			output.add(new CityPoint(random.nextInt(SQR_SIZE) - SQR_SIZE / 2, random.nextInt(SQR_SIZE) - SQR_SIZE / 2));
		double currentMax = 0;
		for (Point point : output) {
			if (!(point instanceof CityPoint))
				continue;
			double currentPointMax = ((CityPoint) point).calculateDistances(output);
			if(currentPointMax > currentMax)
				currentMax = currentPointMax;
		}
		DebugState.TIME.debug("Random points generated: " + timer.read() + "ms");
		return output;
	}
	
}
