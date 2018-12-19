package species;

import java.io.File;

public class KonikHorse extends LargeHerbivore {
	
	public KonikHorse() {
		super();
	}
	public KonikHorse(int initialPopulation, int carryingCapacity, double birthRate, double deathRate) {
		super(initialPopulation, carryingCapacity, birthRate, deathRate);
	}
	
	@Override
	public void reset() {
		super.setFile(new File("src/data/KonikHorse.txt"));
		super.setName("Konik Horse");
		super.setInitialPop(20);
		super.setYearIntroduced("1984");
		super.setCarryingCap(1200);
		super.setBirthRate(1.25);
		super.setDeathRate(1);
		calcGrowth();
	}
}
