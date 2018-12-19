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
		super.setFile(new File("src/data/RedDeer.txt"));
		super.setName("Red Deer");
		super.setInitialPop(45);
//		super.setYearIntroduced("1992");
		super.setCarryingCap(3150);
//		super.setBirthRate(1.27);
//		super.setDeathRate(1);
		super.setGrowthRate(0.19);
	}
}
