package model;

public class Control {
	
	private WetLand [] wetlands;
	private final int SIZE = 80;
	
	public Control(){
		wetlands = new WetLand [SIZE];
	}
	/**
	 * This method allows registering a new wetland and saves it in the array of wetlands in the position obtained by the 
	 * hasSpaceInWetLands method that searches for the first empty space in the array of wetlands
	 * @param name String, it must contain a unique name of the wetland to be registered, otherwise it will not be possible to register
	 * @param location int, the wetland is in a rural or urban location, being represented by the integers 1 and 2 respectively
	 * @param locationName String, depending on whether the wetland is in a rural or urban location, it will ask for the name of the corregimiento or neighborhood, respectively.
	 * @param type int, means that the wetland is private or public, being represented by the integers 1 and 2 respectively
	 * @param area double, contains a number that represents the area in square kilometers of the wetland
	 * @param imageURL String, has a link to view an image of the wetland
	 * @param protectedArea boolean, defines if the wetland is a protected area, being true if it is, and false if it is not
	 * @param compliancePercentage double, has the wetland compliance percentage
	 * @return a confirmation message that the wetland has been added
	 */
	public String addWetLand(String name, int location, String locationName, int type, double area, String imageURL, boolean protectedArea, double compliancePercentage ) {
		String out = "";
		int emptyPosition = hasSpaceInWetLands();
		if (emptyPosition==-1){
			out="The 80 wetlands of the Santiago de Cali municipality have already been registered. Cannot register wetland";
		}else{
			wetlands[emptyPosition] = new WetLand(name,location,locationName,type,area,imageURL,protectedArea,compliancePercentage);
			out = "A WetLand has been added";
		}
		return out;
	}
	/**
	 * The method allows adding a species to a certain existing wetland, whose name and scientific name must be unique, otherwise it will not be possible to register
	 * @param wetLandName String, Contains the name of an existing wetland in which the species belongs
	 * @param name String, it must contain a unique name of the specie to be registered, otherwise it will not be possible to register
	 * @param sciName String, it must contain a unique scientific name of the specie to be registered, otherwise it will not be possible to register
	 * @param migratory boolean, defines whether the species is migratory or not, true if it is, false if not
	 * @param type int, has the option chosen in the menu by the user of the possible types of species represented in an integer, 
	 * 1 if it is terrestrial flora, 2 if it is aquatic flora, 3 if it is a bird, 4 if it is a mammal, and if it is aquatic 
	 * @return a confirmation message that the species has been added
	 */	
	public String addSpecie(String name, String sciName, boolean migratory, int type, String wetLandName) {
		int index = findWetLandIndex(wetLandName);
		Type itsType=null;
		String out="";
		switch(type){
			case 1:
				itsType	=Type.TERRESTRIAL_FLORA;
				break;
			case 2:
				itsType	=Type.AQUIATIC_FLORA;
				break;
			case 3:
				itsType	=Type.BIRD;
				break;
			case 4:
				itsType	=Type.MAMMAL;
				break;
			case 5:
				itsType	=Type.AQUATIC;
				break;
		}
		Specie newSpecie = new Specie(name, sciName, migratory, itsType);
		
		out = wetlands[index].addSpecie(newSpecie);
		return out;
	}
	/**	
	 * This method allows you to search for the wetland or wetlands with the least amount of flora species
	 * @return a String with the message containing the wetland or wetlands with the least amount of flora species
	 */
	public String calculateWetLandMinNumFlora() {
		boolean empty=false,empty2=false;
		String out = "", out1 = "";
		int least = -1;
		int countFlora=1000000;
		for (int i=0; i<SIZE && !empty; i++){
			if (wetlands[i]==null){
				empty=true;
			}else{
				if( countFlora>(wetlands[i].countTerrestrialFlora()+wetlands[i].countAquaticFlora())){
				countFlora=wetlands[i].countTerrestrialFlora()+wetlands[i].countAquaticFlora();
				out="The wetland that contains the least amount of flora is: " +wetlands[i].getName()+" with a number of "+countFlora+" species of flora\n";
				least=i;
				}
			}
		}
		for (int i=0; i<SIZE && !empty2; i++){
			if (wetlands[i]==null){
				empty2=true;
			}else{
				if( wetlands[i]!=wetlands[least] && countFlora==(wetlands[i].countTerrestrialFlora()+wetlands[i].countAquaticFlora())){
				out1+=", " +wetlands[i].getName();
				}
			}
		}
		if (!out1.equals("")){
			out="The wetlands that contains the least amount of flora are: " +wetlands[least].getName()+out1+" with a number of "+countFlora+" species of flora\n";
		}
		return out;
	}
	/**
	 * This method allows you to search for the wetland or wetlands with the largest amount of wildlife species
	 * @return a String with the message containing the wetland or wetlands with the largest amount of wildlife species
	 * or an empty message indicating that there is no wetland with any kind of wildlife
	 */
	public String calculatewetLandMaxNumWildLife() {
		boolean empty=false,empty2=false;
		String out = "", out1 = "",toPrint="";
		int least = -1;
		int countWildLife=-1;
		for (int i=0; i<SIZE && !empty; i++){
			if (wetlands[i]==null){
				empty=true;
			}else{
				if( countWildLife<( wetlands[i].countAquatic()+wetlands[i].countBird()+wetlands[i].countmammal() )){
					countWildLife=wetlands[i].countAquatic()+wetlands[i].countBird()+wetlands[i].countmammal();
				out="The wetland that contains the largest amount of wildlife is: " +wetlands[i].getName()+" with a number of "+countWildLife+" species of wildlife\n";
				least=i;
				}
			}
		}
		for (int i=0; i<SIZE && !empty2; i++){
			if (wetlands[i]==null){
				empty2=true;
			}else{
				if( wetlands[i]!=wetlands[least] && countWildLife==(wetlands[i].countAquatic()+wetlands[i].countBird()+wetlands[i].countmammal())){
				out1+=", " +wetlands[i].getName();
				}
			}
		}
		if (!out1.equals("")&&countWildLife!=0){
			toPrint="The wetlands that contains the largest amount of wildlife are: " +wetlands[least].getName()+out1+" with a number of "+countWildLife+" species of wildlife\n";
		}
		if (out1.equals("")&&countWildLife!=0){
			toPrint=out;
		}
		return toPrint;
	}
	/**
	 * This method searches for the information of a specific wetland searched by the user
	 * @param wetLandName String, The variable must be initialized with the name entered by the user of the possible wetland
	 * @return It will return all the information of a specific wetland or in the opposite case that the wetland is not found, it will return an empty message
	 */
	public String showWetLandInfo(String wetLandName) {
		String out = "";
		int index = findWetLandIndex(wetLandName);
		if (index != -1){
		WetLand  wetLand = wetlands[index];
			if (wetLand!=null){
				out = wetLand.toString();
			}
		}
		return out;
	}
	/**
	 * This method allows you to display the information of all wetlands using the showWetLandInfo method for each available wetland in the array of wetlands
	 * @returna String that contains the information of all the existing wetlands, or in the case that there is not at least one wetland, 
	 * it returns an empty message
	 */
	public String showAllWetLandInfo() {
		int emptySpacePosition= -1;
		String out = "";
		for (int i=0; i<SIZE && emptySpacePosition==-1; i++){
			if (wetlands[i]==null){
				emptySpacePosition=0;
			}else{
				out+=showWetLandInfo(wetlands[i].getName());
			}
		}
		return out;
	}
	/**
	 * The method allows to search according to the year that the user entered, the amount of maintenance that was carried out in all the wetlands on that date
	 * @param year int, must be initialized with a year date
	 * @return a String with the number of maintenances that was carried out in each wetland in that year
	 */
	public String numMaintenancesInYear(int year){
		int emptySpacePosition= -1;
		String out = "";
		for (int i=0; i<SIZE && emptySpacePosition==-1; i++){
			if (wetlands[i]==null){
				emptySpacePosition=0;
			}else{
				out+=wetlands[i].numMaintenancesInYear(year);
			}
		}
		return out;
	}
	/** 
	 * Method that finds the first empty space in the array of wetlands 
	 * @return returns an integrer indicating whether the wetlands array has space or not, if it has space if it 
	 * returns a value other than -1 meaning that there is an empty space, if it doesn't have space left, it returns -1
	 * */
	public int hasSpaceInWetLands(){
		int emptySpacePosition= -1;
		for (int i=0; i<SIZE && emptySpacePosition==-1; i++){
			if(wetlands[i] ==null){
				emptySpacePosition= i;
			}
		}
		return emptySpacePosition;
	}
	/**
	 * This method searches if the name of the wetland entered by the user exists among all existing wetlands.
	 * @param wetLandName String, The variable must be initialized with the name entered by the user of the possible wetland
	 * @return returns the position of the WetLand in the array of wetlands else it returns -1 which means that it wasnt found
	 */
	public int findWetLandIndex(String wetLandName){
		boolean found=false;
		int index = -1;
		for (int position=0; position<SIZE && !found;position++){
			if (wetlands[position]!=null && wetlands[position].getName().equals(wetLandName)){
				found=true;
				index=position;
			}
		}
		return index;
	}
	/**
	 * This method checks if the name of a certain species in a certain wetland already exists
	 * @param wetLandName String, must contain the name of an existing wetland
	 * @param name String, initialized with the name of the species being tested
	 * @return returns a boolean, representing whether or not the species name exists in said wetland, true if it exists, false if not
	 */
	public boolean nameOfSpecieAlreadyExists(String wetLandName, String name){
		boolean answer = false;
		int index = findWetLandIndex(wetLandName);
		answer=wetlands[index].nameInSpeciesAlreadyExists(name);
		return answer;
	}
	/**
	 * This method checks if the scientific name of a certain species in a certain wetland already exists
	 * @param wetLandName String, must contain the name of an existing wetland
	 * @param name String, initialized with the scientific name of the species being tested
	 * @return returns a boolean, representing whether or not the species scientific name exists in said wetland, true if it exists, false if not
	 */
	public boolean sciNameOfSpecieAlreadyExists(String wetLandName, String sciName){
		boolean answer = false;
		int index = findWetLandIndex(wetLandName);
		answer=wetlands[index].sciNameInSpeciesAlreadyExists(sciName);
		return answer;
	}
	/**
	 * The method checks if the date entered by the user is correctly entered
	 * @param date It must contain a String in the format (DD/MM/YY)
	 * @return returns a boolean indicating whether the message was entered correctly or not, true if it was, false if not
	 */
	public boolean IsdateCorrect(String date){
		boolean theChecker=true;
		String[] checker = date.split("/");
		if(checker.length!=3){
			theChecker=false;
		}
		return theChecker;
	}
	/**
	 * The method allows adding an event to a certain existing wetland
	 * @param eventUserId String, has the name of the host of the event
	 * @param value double, has the value of the event to be carried out
	 * @param description String, has a description of the event
	 * @param eventDate It must contain a String in the format (DD/MM/YY)
	 * @param type int, has the option chosen in the menu by the user of the possible types of events represented in an integer, 
	 * 1 if it is maintenance, 2 if it is school visits, 3 if it is an improvement activity, and 4 if it is a celebration
	 * @param wetLandName String, Contains the name of an existing wetland in which the species belongs
	 * @return a confirmation message that the event has been added
	 */
	public String addEvent(String eventUserId, double value, String description, String eventDate, int type, String wetLandName){
		int index = findWetLandIndex(wetLandName);
		EventType itsType=null;
		String out="";
		switch(type){
			case 1:
			itsType=EventType.MAINTENANCE;
			
				break;
			case 2:
			itsType=EventType.SCHOOL_VISITS;
				break;
			case 3:
			itsType=EventType.IMPROVEMENT_ACTIVITIES;
				break;
			case 4:
			itsType=EventType.CELEBRATIONS;
				break;
		}
		String[] dates = eventDate.split("/");
		int day = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int year = Integer.parseInt(dates[2]);

		Date date = new Date(day, month, year);
		Event newEvent = new Event(eventUserId, value, description, date, itsType);
		out = wetlands[index].addEvent(newEvent);
		return out;

	}
	/**
	 * This method checks if the name of a certain species in a all existing wetlands already exists
	 * @param name String, initialized with the scientific name of the species being searched
	 * @returnreturns the name of all the wetlands in which the species is found, or otherwise returns an empty message 
	 * indicating that the species was not found in any of the wetlands
	 */
	public String findSpecieInWetLands(String name){
		boolean emptyPosition= false;
		String out="",print="";
		for (int i=0; i<SIZE && !emptyPosition; i++){
			if(wetlands[i] ==null){
				emptyPosition= true;
			}else{
				if(wetlands[i].nameInSpeciesAlreadyExists(name)==true){
					out+=", "+wetlands[i].getName();
				}
			}
		}
		if(!out.equals("")){
			print="The species "+name+" is found in wetlands such as"+out;
		}
		return print;
	}


}