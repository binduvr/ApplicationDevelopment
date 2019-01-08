package species;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class LargeHerbivore implements Comparable<LargeHerbivore> {
	
	private String name;
	private int initialPop;
	private int carryingCap;
	private double growthRate;
	private File file;
	
	
	//set the competition values for the animals in setting
	private int currentPopulation;
	
	public LargeHerbivore() {
		reset();
//		saveSettings();
		loadSettings();
	}
	
	public LargeHerbivore(int initialPopulation, int carryingCapacity, double growthRate) {
		super();
		this.initialPop = initialPopulation;
		this.carryingCap = carryingCapacity;
		this.growthRate = growthRate;
		saveSettings();
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
		carryingCap = Integer.parseInt(text);
		text = lines.get(3).substring(lines.get(3).indexOf(":")+2).trim();
		growthRate = Double.parseDouble(text);
	}
	
	//Only to be used to initially create files
	public void saveSettings() {
		try {
			String text = "Species: " + name;
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", false);
			text = "Intitial Population: " + String.valueOf(initialPop);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
			text = "Carrying Capacity: " + String.valueOf(carryingCap);
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
	//Helps with GUI
	public IntegerProperty currentPopulationProperty() {
		IntegerProperty popProperty = new SimpleIntegerProperty();
		popProperty.set(currentPopulation);
		return popProperty;
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
	//Helps with GUI
	public StringProperty nameProperty() {
		StringProperty nameProperty = new SimpleStringProperty();
		nameProperty.set(name);
		return nameProperty;
	}
	public int getInitialPop() {
		return initialPop;
	}
	public void setInitialPop(int initialPop) {
		this.initialPop = initialPop;
//		saveSettings();
	}
	
	public int getCarryingCap() {
		return carryingCap;
	}

	public void setCarryingCap(int carryingCap) {
		this.carryingCap = carryingCap;
//		saveSettings();
	}
	
	public double getGrowthRate() {
		return growthRate;
	}
	
	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
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
