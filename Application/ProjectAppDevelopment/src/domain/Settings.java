package domain;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Settings {
	public int defaultTimeRange;
	public int defaultTimeView;
	private File file;
	private static Settings internalObject = null;
	
	public static synchronized Settings instance() {
		if (internalObject == null) {
			internalObject = new Settings();
		}
		return internalObject;
	}
	
	private Settings() {
		reset();
//		saveSettings();
		loadSettings();
	}
	private void reset() {
		ClassLoader classLoader = getClass().getClassLoader();
		file = new File(classLoader.getResource("data/Settings.txt").getFile());
		defaultTimeRange = 20;
		defaultTimeView = 0;
	}

	public void loadSettings() {
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		}
		String text = lines.get(0).substring(lines.get(0).indexOf(":")+2).trim();
		defaultTimeRange = Integer.parseInt(text);
		text = lines.get(1).substring(lines.get(1).indexOf(":")+2).trim();
		defaultTimeView = Integer.parseInt(text);
	}
	
	//Only to be used to initially create files
	public void saveSettings() {
		try {
			String text = "Default time range: " + defaultTimeRange;
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", false);
			text = "Default time selected: " + String.valueOf(defaultTimeView);
			FileUtils.writeStringToFile(file, text+"\n","UTF-8", true);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(17);
		}
	}

	public int getDefaultTimeRange() {
		return defaultTimeRange;
	}

	public void setDefaultTimeRange(int defaultTimeRange) {
		this.defaultTimeRange = defaultTimeRange;
	}

	public int getDefaultTimeView() {
		return defaultTimeView;
	}

	public void setDefaultTimeView(int defaultTimeView) {
		this.defaultTimeView = defaultTimeView;
	}
}
