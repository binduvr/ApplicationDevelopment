package species;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import org.apache.commons.io.FileUtils;

public abstract class LargeHerbivore implements Comparable<LargeHerbivore> {
	
	private String name;
	private int initialPop;
	private Year yearIntroduced;
	private int carryingCap;
	private double birthRate;
	private double deathRate;
	private double growthRate;
	private File file;
	
	private int currentPopulation;
	
	public LargeHerbivore() {
		reset();
//		saveSettings();
		loadSettings();
	}
	
	public LargeHerbivore(int initialPopulation, int carryingCapacity, double birthRate, double deathRate) {
		super();
		this.initialPop = initialPopulation;
		this.carryingCap = carryingCapacity;
		this.birthRate = birthRate;
		this.deathRate = deathRate;
		calcGrowth();
		saveSettings();
	}
	
	public void calcGrowth() {
		this.growthRate = birthRate-deathRate;
	}
	
	public abstract void reset();
	
	public void loadSettings() {
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		}
		String text = lines.get(0).substring(lines.get(0).indexOf(":")+2).trim();
		name = text;
		text = lines.get(1).substring(lines.get(1).indexOf(":")+2).trim();
		initialPop = Integer.parseInt(text);
		text = lines.get(2).substring(lines.get(2).indexOf(":")+2).trim();
		yearIntroduced = Year.parse(text);
		text = lines.get(3).substring(lines.get(3).indexOf(":")+2).trim();
		carryingCap = Integer.parseInt(text);
		text = lines.get(4).substring(lines.get(4).indexOf(":")+2).trim();
		birthRate = Double.parseDouble(text);
		text = lines.get(5).substring(lines.get(5).indexOf(":")+2).trim();
		deathRate = Double.parseDouble(text);
		growthRate = birthRate-deathRate;
	}
	
	//Only to be used to initially create files
	public void saveSettings() {
		calcGrowth();
		try {
			String text = "Species: " + name;
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", false);
			text = "Intitial Population: " + String.valueOf(initialPop);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
			text = "Year introduced: " + String.valueOf(yearIntroduced);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
			text = "Carrying Capacity: " + String.valueOf(carryingCap);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
			text = "Instantanious Birthrate: " + String.valueOf(birthRate);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
			text = "Instantanious Deathrate: " + String.valueOf(deathRate);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
			text = "Growth Rate: " + String.valueOf(growthRate);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
			
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(17);
		}
	}
	public int getCurrentPopulation() {
		return currentPopulation;
	}
	public void setCurrentPopulation(int currentPopulation) {
		this.currentPopulation = currentPopulation;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInitialPop() {
		return initialPop;
	}
	public void setInitialPop(int initialPop) {
		this.initialPop = initialPop;
//		saveSettings();
	}
	public Year getYearIntroduced() {
		return yearIntroduced;
	}
//	public void setYearIntroduced(Year yearIntroduced) {
//		this.yearIntroduced = yearIntroduced;
////		saveSettings();
//	}
	public void setYearIntroduced(String yearIntroduced) {
		this.yearIntroduced = Year.parse(yearIntroduced);
//		saveSettings();
	}
	
	public int getCarryingCap() {
		return carryingCap;
	}

	public void setCarryingCap(int carryingCap) {
		this.carryingCap = carryingCap;
//		saveSettings();
	}

	public double getBirthRate() {
		return birthRate;
	}

	public void setBirthRate(double birthRate) {
		this.birthRate = birthRate;
		calcGrowth();
//		saveSettings();
	}

	public double getDeathRate() {
		return deathRate;
	}

	public void setDeathRate(double deathRate) {
		this.deathRate = deathRate;
		calcGrowth();
//		saveSettings();
	}
	public double getGrowthRate() {
		return growthRate;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LargeHerbivore other = (LargeHerbivore) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(LargeHerbivore other) {
		return this.name.compareTo(other.name);
	}

}