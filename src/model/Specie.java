package model;

public class Specie {

	private String name;
	private String sciName;
	private boolean migratory;
	private Type type;

	//getters
	public String getName() {
		return this.name;
	}	
	public String getSciName() {
		return this.sciName;
	}
	public boolean getMigratory() {
		return this.migratory;
	}
	public Type getType() {
		return this.type;
	}
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setSciName(String sciName) {
		this.sciName = sciName;
	}
	public void setMigratory(boolean migratory) {
		this.migratory = migratory;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	/**
	 * This is the constructor of a class Species
	 * @param name String, contains a name of the specie 
	 * @param sciName String, contains a scientific name of the specie 
	 * @param migratory boolean, defines whether the species is migratory or not, true if it is, false if not
	 * @param type Type, indicates the type of species it is such as, terrestrial flora, aquatic flora, bird, mammal, and aquatic 
	 */
	public Specie(String name, String sciName, boolean migratory, Type type) {
		this.name = name;
		this.sciName = sciName;
		this.migratory = migratory;
		this.type = type;
	}

}