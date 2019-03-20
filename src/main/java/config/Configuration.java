package config;

public final class Configuration {
	public final String seed = "spike mad lonely paper fiber give thrive bind blush wide test nest surge vault misery";
	public final String hashSeed = "DbAnchoring2k18HRWProjektSeed";
	public final int fee = 1100000;
		
	public Configuration() {}

	public String getSeed() {
		return seed;
	}
	
	public int getFee() {
		return fee;
	}
	
	public String getHashSeed() {
		return hashSeed;
	}
}

