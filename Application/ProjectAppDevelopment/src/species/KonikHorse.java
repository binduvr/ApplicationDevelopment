package species;

import java.io.File;

public class KonikHorse extends LargeHerbivore {
	
	public KonikHorse() {
		super();
	}
	public KonikHorse(int initialPopulation, int carryingCapacity, double growthRate, LargeHerbivore competitor) {
		super(initialPopulation, carryingCapacity, growthRate, competitor);
	}
	
	@Override
	public void reset() {
		ClassLoader classLoader = getClass().getClassLoader();
		super.setFile(new File(classLoader.getResource("data/KonikHorse.txt").getFile()));
		super.setName("Konik Horse");
		super.setInitialPop(20);
		super.setCarryingCap(1200);
		super.setGrowthRate(0.224);
	}
}
