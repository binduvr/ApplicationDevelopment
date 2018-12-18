package species;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class HeckCattle extends LargeHerbivore {
	public HeckCattle() {
		super();
	}
	public HeckCattle(int initialPopulation, int carryingCapacity, double birthRate, double deathRate) {
		super(initialPopulation, carryingCapacity, birthRate, deathRate);
	}
	
	@Override
	public void reset() {
		super.setFile(new File("src/data/HeckCattle.txt"));
		super.setName("Heck Cattle");
		super.setInitialPop(30);
		super.setYearIntroduced("1983");
		super.setCarryingCap(400);
		super.setBirthRate(1.33);
		super.setDeathRate(1);
		calcGrowth();
	}
}
