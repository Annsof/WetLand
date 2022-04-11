package model;

public class WetLand {

	private final int SIZE = 8000;

	private String name;
	private int location;
	private String locationName;
	private boolean isAPreservedArea;
	private int type;
	private double area;
	private String imageURL;
	private Specie [] species;
	private Event [] events;
	private double compliancePercentage;

	//getters
	public int getSIZE() {
		return this.SIZE;
	}
	public boolean getIsAPreservedArea() {
		return isAPreservedArea;
	}
	public String getName() {
			return name;
	}
	public int getLocation() {
		return this.location;
	}
	public String getLocationName() {
		return this.locationName;
	}
	public int getType() {
		return this.type;
	}
	public double getArea() {
		return this.area;
	}
	public String getImageURL() {
		return this.imageURL;
	}
	public Specie[] getSpecies() {
		return this.species;
	}
	public Event[] getEvents() {
		return this.events;
	}
	public double getCompliancePercentage() {
		return this.compliancePercentage;
	}
	//setters
	public void setIsAPreservedArea(boolean isAPreservedArea) {
		this.isAPreservedArea = isAPreservedArea;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public void setSpecies(Specie[] species) {
		this.species = species;
	}
	public void setEvents(Event[] events) {
		this.events = events;
	}
	public void setCompliancePercentage(double compliancePercentage) {
		this.compliancePercentage = compliancePercentage;
	}
	
	/**
	 * This is the constructor of an WetLand class
	 * @param name String, has the name of the wetland
	 * @param location int, the wetland is in a rural or urban location, being represented by the integers 1 and 2 respectively
	 * @param locationName String, depending on whether the wetland is in a rural or urban location, it will ask for the name of the corregimiento or neighborhood, respectively.
	 * @param type int, means that the wetland is private or public, being represented by the integers 1 and 2 respectively
	 * @param area double, contains a number that represents the area in square kilometers of the wetland
	 * @param imageURL String, has a link to view an image of the wetland
	 * @param isAPreservedArea boolean, defines if the wetland is a protected area, being true if it is, and false if it is not
	 * @param compliancePercentage double, has the wetland compliance percentage
	 */
	public WetLand(String name, int location, String locationName, int type, double area, String imageURL, boolean isAPreservedArea, double compliancePercentage) {
		this.name=name;
		this.location=location;
		this.locationName=locationName;
		this.type=type;
		this.area=area;
		this.imageURL=imageURL;
		this.isAPreservedArea=isAPreservedArea;
		this.compliancePercentage=compliancePercentage;
		species = new Specie [SIZE];
		events = new Event [SIZE];
	}
	/**
	 * The method counts the amount of terrestrial flora species in the wetland
	 * @return the count of terrestrial flora species in the wetland
	 */
	public int countTerrestrialFlora(){
		int count = 0;
		for(int position=0;position<SIZE;position++){
			if(species[position]!=null && species[position].getType().equals(Type.TERRESTRIAL_FLORA)){
				count++;
			}
		}
		return count;
	}
	/**
	 * The method counts the amount of aquatic flora species in the wetland
	 * @return the count of aquatic flora species in the wetland
	 */
	public int countAquaticFlora(){
		int count = 0;
		for(int position=0;position<SIZE;position++){
			if(species[position]!=null && species[position].getType().equals(Type.AQUIATIC_FLORA)){
				count++;
			}
		}
		return count;
	}
	/**
	 * The method counts the amount of bird species in the wetland
	 * @return the count of bird species in the wetland
	 */
	public int countBird(){
		int count = 0;
		for(int position=0;position<SIZE;position++){
			if(species[position]!=null && species[position].getType().equals(Type.BIRD)){
				count++;
			}
		}
		return count;
	}
	/**
	 * The method counts the amount of mammal species in the wetland
	 * @return the count of mammal species in the wetland
	 */
	public int countmammal(){
		int count = 0;
		for(int position=0;position<SIZE;position++){
			if(species[position]!=null && species[position].getType().equals(Type.MAMMAL)){
				count++;
			}
		}
		return count;
	}
	/**
	 * The method counts the amount of aquatic species in the wetland
	 * @return the count of aquatic species in the wetland
	 */
	public int countAquatic(){
		int count = 0;
		for(int position=0;position<SIZE;position++){
			if(species[position]!=null && species[position].getType().equals(Type.AQUATIC)){
				count++;
			}
		}
		return count;
	}
	/**
	 * This method returns in String all the information of the class WetLand
	 * @return all the information of the class WetLand
	 */
	public String toString(){
		String out = 
		"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
		"\nWetland name: " + name;
		if (location == 1){
			out+="\nWetland location: Urban "+ "\nName of the corregimiento: "+locationName;
		}else{
			out+="\nWetland location: Rural "+ "\nName of the neighborhood:: "+locationName;
		}
		out+= "\nIs it a protected area?: "+isAPreservedArea+ 
		"\nThe area of the wetland is: " +area+ " square kilometers"+
		"\nA picture of the wetland is in the link: "+imageURL+
		"\nThe wetland compliance percentage is:"+compliancePercentage+
		"\nThe total number of :"+
		"\n     - Wildlife species in the wetland is: "+(countAquatic()+countBird()+countmammal())+ 
		"\n     - Flora species in the wetland is: "+(countTerrestrialFlora()+countAquaticFlora())+
		"\n     * Aquatic species is: "+countAquatic()+
		"\n     * Bird species is: "+countBird()+
		"\n     * Mammal species is: "+countmammal()+
		"\n     * Terrestrial flora species is: "+countTerrestrialFlora()+
		"\n     * Aquatic flora species is: "+countAquaticFlora();
		return out;
	}
	/**
	 * The method adds the object of type species in the array of species
	 * @param specie the object must be initialized with the information name,scientific name, if it is migratory, and the type of the specie 
	 * @return a confirmation message that the specie object has been added to the species array
	 */	
	public String addSpecie(Specie specie) {
		int emptyPosition = emptyPositionInSpecies();
		species[emptyPosition]= specie;
		return "The species has been added";
	}
	/**
	 * The method adds the object of event species in the array of events
	 * @param event the object must be initialized with the information the name of the host of the event,
	 * the value of the event, a description of the event, date in which the event will take place, 
	 * and the type of event
	 * @return a confirmation message that the event object has been added to the events array
	 */
	public String addEvent(Event event) {
		int emptyPosition = emptyPositionInEvent();
		events[emptyPosition]= event;
		return "The event has been added";
	}
	/**
	 * The method allows to search according to the year that the user entered, the amount of maintenance that was carried out in the wetland on that date
	 * @param year int, must be initialized with a year date
	 * @return a String with the number of maintenances that was carried out in the wetland in that year
	 */
	public String numMaintenancesInYear(int year){
		boolean empty= false;
		int count=0;
		String out ="";
		for (int i=0; i<SIZE && !empty; i++){
			if(events[i] ==null){
				empty= true;
			}
			if(events[i]!=null && events[i].getEventDate().getYear()==year){
				count++;
			}
		}
		out="\nFor the wetland "+name+" there was "+count+" maintenance(s) carried out during the year "+year;
		return out;
	}
	/** 
	 * Method that finds the first empty space in the array of species 
	 * @return returns an integrer indicating whether the species array has space or not, if it has space if it 
	 * returns a value other than -1 meaning that there is an empty space, if it doesn't have space left, it returns -1
	 * */
	public int emptyPositionInSpecies(){
		int emptySpacePosition= -1;
		for (int i=0; i<SIZE && emptySpacePosition==-1; i++){
			if(species[i] ==null){
				emptySpacePosition= i;
			}
		}
		return emptySpacePosition;
	}
	/** 
	 * Method that finds the first empty space in the array of events 
	 * @return returns an integrer indicating whether the events array has space or not, if it has space if it 
	 * returns a value other than -1 meaning that there is an empty space, if it doesn't have space left, it returns -1
	 * */
	public int emptyPositionInEvent(){
		int emptySpacePosition= -1;
		for (int i=0; i<SIZE && emptySpacePosition==-1; i++){
			if(events[i] ==null){
				emptySpacePosition= i;
			}
		}
		return emptySpacePosition;
	}
	/**
	 * This method checks if the name of a certain species in a the wetland already exists
	 * @param name String, initialized with the name of the species being tested
	 * @return returns a boolean, representing whether or not the species name exists in the wetland, true if it exists, false if not
	 */
	public boolean nameInSpeciesAlreadyExists(String name){
		boolean found=false;
		for (int position=0; position<SIZE && !found;position++){
			if (species[position]!=null && species[position].getName().equals(name)){
				found=true;
			}
		}
		return found;
	}
	/**
	 * This method checks if the scientific name of a certain species in a the wetland already exists
	 * @param name String, initialized with the scientific name of the species being tested
	 * @return returns a boolean, representing whether or not the species name exists in the wetland, true if it exists, false if not
	 */
	public boolean sciNameInSpeciesAlreadyExists(String sciName){
		boolean found=false;
		for (int position=0; position<SIZE && !found;position++){
			if (species[position]!=null && species[position].getSciName().equals(sciName)){
				found=true;
			}
		}
		return found;
	}
	
	

}