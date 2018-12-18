package species;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class HeckCattleV2 implements ISpecies {
	private String name;
	private int initialPop;
	private int carryingCap;
	private double birthRate;
	private double deathRate;
	private double growthRate;
	
	public HeckCattleV2() {
		reset();
//		saveSettings();
		loadSettings();
	}
	
	public HeckCattleV2(int initialPopulation, int carryingCapacity, double birthRate, double deathRate) {
		super();
		this.initialPop = initialPopulation;
		this.carryingCap = carryingCapacity;
		this.birthRate = birthRate;
		this.deathRate = deathRate;
		calcGrowth();
		saveSettings();
	}
	
	private void calcGrowth() {
		this.growthRate = birthRate-deathRate;
	}
	
	public void reset() {
		name = "Heck Cattle";
		initialPop = 30;
		carryingCap = 400;
		birthRate = 1.33;
		deathRate = 1;
		calcGrowth();
	}
	
	public void loadSettings() {
		File file = new File("src/data/HeckCattle.txt");
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
		carryingCap = Integer.parseInt(text);
		text = lines.get(3).substring(lines.get(3).indexOf(":")+2).trim();
		birthRate = Double.parseDouble(text);
		text = lines.get(4).substring(lines.get(4).indexOf(":")+2).trim();
		deathRate = Double.parseDouble(text);
		growthRate = birthRate-deathRate;
	}
	
	public void saveSettings() {
		calcGrowth();
		try {
//			ClassLoader classLoader = getClass().getClassLoader();
//			File file = new File(classLoader.getResource("data/HeckCattle.txt").getFile());
			File file = new File("src/data/HeckCattle.txt");
			String text = "Species: " + name;
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", false);
			text = "Intitial Population: " + String.valueOf(initialPop);
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

	public int getInitialPop() {
		return initialPop;
	}

	public void setInitialPop(int initialPop) {
		this.initialPop = initialPop;
		saveSettings();
	}

	public int getCarryingCap() {
		return carryingCap;
	}

	public void setCarryingCap(int carryingCap) {
		this.carryingCap = carryingCap;
		saveSettings();
	}

	public double getBirthRate() {
		return birthRate;
	}

	public void setBirthRate(double birthRate) {
		this.birthRate = birthRate;
		saveSettings();
	}

	public double getDeathRate() {
		return deathRate;
	}

	public void setDeathRate(double deathRate) {
		this.deathRate = deathRate;
		saveSettings();
	}
	public double getGrowthRate() {
		return growthRate;
	}
	
//	public static void main(String[] args) {
//		HeckCattle cattle = new HeckCattle();
//		System.out.println(cattle.name);
//		System.out.println(cattle.initialPop);
//		System.out.println(cattle.carryingCap);
//		System.out.println(cattle.birthRate);
//		System.out.println(cattle.deathRate);
//		System.out.println(cattle.growthRate);
//	}
}
