package species;

import java.io.File;

public class RedDeer extends LargeHerbivore {
	
	public RedDeer() {
		super();
	}
	public RedDeer(int initialPopulation, int carryingCapacity, double growthRate) {
		super(initialPopulation, carryingCapacity, growthRate);
	}
	
	@Override
	public void reset() {
		ClassLoader classLoader = getClass().getClassLoader();
		super.setFile(new File(classLoader.getResource("data/RedDeer.txt").getFile()));
		super.setName("Red Deer");
		super.setInitialPop(45);
		super.setCarryingCap(3100);
		super.setGrowthRate(0.19);
	}
}
