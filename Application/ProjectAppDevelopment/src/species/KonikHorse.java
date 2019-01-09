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
		super.setFile(new File("src/data/KonikHorse.txt"));
		super.setName("Konik Horse");
		super.setInitialPop(20);
		super.setCarryingCap(1200);
		super.setGrowthRate(0.224);
	}
}
