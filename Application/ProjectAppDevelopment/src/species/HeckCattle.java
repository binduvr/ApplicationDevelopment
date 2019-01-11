package species;

import java.io.File;

public class HeckCattle extends LargeHerbivore {
	public HeckCattle() {
		super();
	}
	public HeckCattle(int initialPopulation, int carryingCapacity, double growthRate, LargeHerbivore competitor) {
		super(initialPopulation, carryingCapacity, growthRate, competitor);
	}
	
	@Override
	public void reset() {
		ClassLoader classLoader = getClass().getClassLoader();
		super.setFile(new File(classLoader.getResource("data/HeckCattle.txt").getFile()));
		super.setName("Heck Cattle");
		super.setInitialPop(30);
		super.setCarryingCap(400);
		super.setGrowthRate(0.144);
	}
}
