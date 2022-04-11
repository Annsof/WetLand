package ui;
import java.util.Scanner;
import model.Control;

/**
* This wetlands program is a solution that manages the wetlands information, being able to add new wetlands, species and 
* events and make certain counts and reports based on the recorded data.
* @author Ana Londono
* @since april 2022
* @Version 1.0
**/
public class Main{
	/**
	* controller is an object of type control that connects to the solution model
	**/
	private Control controller;
	/**
	* sc is an object of the Scanner class that reads the input
	**/
	private Scanner sc;	
	public Main(){
		controller = new Control();
		sc= new Scanner(System.in);
	}
	public static void main (String[]args){
	
		Main principal = new Main();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nWelcome to the archive of the wetlands of the town hall of Santiago de Cali.");
		int option = 0;
		do{
			option=principal.displayMenu();
			principal.menuExecution(option);
		}while(option!=0);
		
		
	}
	/**
	* This method displays the possible menu options for the user to choose from.
	* @return the option chosen by the user represented by an integer
	**/
	public int displayMenu(){
		int option = 0;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Select one of the following options\n"+
							"(1) Create a wetland\n"+
							"(2) Add a new species in wetland\n"+
							"(3) Add  an event in wetland\n"+
							"(4) Inform for each wetland, the amount of maintenance in a year given by the user.\n"+
							"(5) Display the name of the wetland with fewer species of flora.\n"+
							"(6) Given the name of a species, display the wetlands where it is found\n"+
							"(7) Display the information of all  wetlands\n"+
							"(8) Display the name of the wetland with the largest number of animals\n"+
							"(0) To exit\n");
		option=sc.nextInt();
		sc.nextLine();
		System.out.println();
		return option;
	}
	/**
	* This method executes the option chosen by the user on the display menu method
	* @param option initialized with values between 1 and 8 to execute some function of the program, 
	0 to exit, and any other value, since it is not valid, the menu will reappear
	**/ 
	public void menuExecution(int option){
		switch(option){
			case 1:
			registerWetLand();
			break;
			case 2:
			registerSpecie();
			break;
			case 3:
			registerEvent();
			break;
			case 4:
			numMaintenancesInYear();
			break;
			case 5:
			wetLandMinNumFlora();
			break;
			case 6:
			findSpecieInWetLands();
			break;
			case 7:
			showAllWetLandInfo();
			break;
			case 8:
			wetLandMaxNumWildLife();
			break;
			case 0:
			System.out.print("Bye :-)!\n");
			break;
			default:
			System.out.print("Enter a valid option\n");
			break;
		}
			
		
	}
	/**
	 * This method allows you to register a new wetland, checking that the name of the wetland does 
	 * not exist and that the data entered is under the conditions that the system requests from the user.
	 */
	public void registerWetLand(){
		System.out.println("Adding wetland");
		String name, imageURL, locationName	;
		int location,type;
		double area,compliancePercentage;
		boolean isProtected;

		System.out.println("Enter the name of the wetland");
		name=sc.nextLine();
		String doesItAlreadyExist = controller.showWetLandInfo(name);
		if(doesItAlreadyExist.equals("")){
		System.out.println("What is the location you have? (1. urban / 2. rural)");
		location=sc.nextInt();
			sc.nextLine();
		while (location<1 || location>2){
			System.out.println("Enter a valid location (1. urban / 2. rural)");
			location=sc.nextInt();
				sc.nextLine();
		}
		if (location==1){
			System.out.println("Enter the name of the corregimiento where the wetland is located");
			locationName=sc.nextLine();
		}else{
			System.out.println("Enter the name of the neighborhood where the wetland is located");
			locationName=sc.nextLine();
		}
		System.out.println("What type of wetland is it? (1. Private / 2. Public)");
		type=sc.nextInt();	
			sc.nextLine();
		while (type<1 || type>2){
			System.out.println("Enetr a valid wetland type (1. Private / 2. Public)");
			type=sc.nextInt();
				sc.nextLine();
		}		
		System.out.println("How many square kilometers does the wetland have?");
		area=sc.nextDouble();
			sc.nextLine();
		System.out.println("Enter the URL of an image of the wetland");
		imageURL=sc.nextLine();
		System.out.println("Is the wetland protected? (true / false)");
		isProtected=sc.nextBoolean();
			sc.nextLine();
		System.out.println("What is the percentage of wetland compliance?");
		compliancePercentage=sc.nextDouble();

		System.out.println(controller.addWetLand(name,location, locationName, type, area, imageURL, isProtected,compliancePercentage));
		}else{
			System.out.println("The name of this wetland already exists. cannot register wetland");
		}

	}
	/**
	 * This method allows registering a new species, verifying that the name of the wetland to which the 
	 * species is going to be entered already exists, that the name and scientific name of the species 
	 * are unique in the wetland to be entered and that the data entered are under the conditions that 
	 * the system asks the user
	 */
	public void registerSpecie(){

		String name,sciName,wetLandName;
		int type;
		boolean isMigratory;

		System.out.println("Adding specie");

		System.out.println("Type the name where this species belongs");
		wetLandName=sc.nextLine();

		String thisWetLandAlreadyExist = controller.showWetLandInfo(wetLandName);

		if(!thisWetLandAlreadyExist.equals("")){

			System.out.println("type the name of the specie");
			name=sc.nextLine();

			boolean thisNameAlreadyExist = controller.nameOfSpecieAlreadyExists(wetLandName,name);

			if(thisNameAlreadyExist==false){

			System.out.println("type the scientific name of the specie");
			sciName=sc.nextLine();

			boolean thisSciNameAlreadyExist = controller.sciNameOfSpecieAlreadyExists(wetLandName,sciName);
			
			if (thisSciNameAlreadyExist==false){

				System.out.println("is the species migratory? (true/false)");
				isMigratory=sc.nextBoolean();

				System.out.println("what kind of species is it?\n" +
									"(1)terrestrial flora\n" + 
									"(2)aquatic flora\n"+
									"(3)bird\n"+
									"(4)mammal\n"+
									"(5)aquatic\n");
				type=sc.nextInt();
				sc.nextLine();
				while (type<1 || type>5){
					System.out.println("Enter a valid answer");
					System.out.println("what kind of species is it?\n" +
									"(1)terrestrial flora\n" + 
									"(2)aquatic flora\n"+
									"(3)bird\n"+
									"(4)mammal\n"+
									"(5)aquatic\n");
					type=sc.nextInt();
					sc.nextLine();
				}
				System.out.println(controller.addSpecie(name,sciName,isMigratory,type,wetLandName));

				}else{
					System.out.println("the scientific name of this species already exists");
				}
			}else{
				System.out.println("the name of this species already exists");
		}

		}else{
			System.out.println("The wetland to which you are adding the species does not exist");
		}

	}
	/**
	 * This method allows registering a new event, verifying that the name of the wetland to which the event 
	 * is going to be entered already exists, that the date entered is a valid one and that the data entered 
	 * is under the conditions that the system requests from the user.
	 */
	public void registerEvent(){
		String wetLandName,date="";
		System.out.println("Adding event");

		System.out.println("Type the name of the wetland where this event belongs");
		wetLandName=sc.nextLine();

		String thisWetLandAlreadyExist = controller.showWetLandInfo(wetLandName);

		if(!thisWetLandAlreadyExist.equals("")){
			
			System.out.println("Enter the date the event will take place. (DD/MM/YY)");
			date=sc.nextLine();

			boolean theChecker = controller.IsdateCorrect(date);

			if(theChecker==true){

				System.out.println("Enter who will host the event");
				String host=sc.nextLine();

				System.out.println("Enter a description about the event");
				String description=sc.nextLine();

				System.out.println("What will be the value of the event");
				double value=sc.nextDouble();

				System.out.println("Select what type of event it will be.\n" +
									"(1)maintenance\n" + 
									"(2)school visits\n"+
									"(3)improvement activities \n"+
									"(4)celebrations\n");
				int type=sc.nextInt();
				sc.nextLine();

				while (type<1 || type>4){
					System.out.println("Enter a valid answer");
					System.out.println("Select what type of event it will be.\n" +
									"(1)maintenance\n" + 
									"(2)school visits\n"+
									"(3)improvement activities \n"+
									"(4)celebrations\n");
					type=sc.nextInt();
					sc.nextLine();
				}

				System.out.println(controller.addEvent(host,value,description,date,type,wetLandName));

			}else{
				System.out.println("The date is in the wrong format");
			}

		}else{
			System.out.println("The wetland to which you are adding the event does not exist");
		}
		
	}
	/** 
	 * This method allows displaying on the screen all the information of all the wetlands in the system, 
	 * verifying first that there is at least 1 wetland
	*/
	public void showAllWetLandInfo(){
		if(!controller.showAllWetLandInfo().equals("")){
		System.out.println(controller.showAllWetLandInfo());
		}else{
			System.out.println("There is no existing wetlands");
		}
	}
	/**
	 * This method allows showing on the screen all the maintenance carried out 
	 * in the year that the user enters in all the wetlands.
	 */
	public void numMaintenancesInYear(){
		if(!controller.showAllWetLandInfo().equals("")){
			System.out.println("Enter the year in which you are looking for the amount of maintenance performed");
			int year=sc.nextInt();
			sc.nextLine();
			System.out.println(controller.numMaintenancesInYear(year));
		}else{
			System.out.println("There is no existing wetlands");
		}
		
	}
	/**
	 * This method allows you to see the wetland or wetlands with the least amount of flora species, 
	 * verifying that there is at least 1 wetland in the system.
	 */
	public void wetLandMinNumFlora(){
		if(!controller.showAllWetLandInfo().equals("")){
			System.out.println(controller.calculateWetLandMinNumFlora());
		}else{
			System.out.println("There is no existing wetlands");
		}
	}
	/**
	 * This method allows you to see the wetland or wetlands with the largest number of wildlife species, 
	 * verifying that there is at least 1 wetland in the system.
	 */
	public void wetLandMaxNumWildLife(){
		if(!controller.showAllWetLandInfo().equals("")){
			String out =controller.calculatewetLandMaxNumWildLife();
			if(!out.equals("")){
			System.out.println(out);
			}else{
				System.out.println("There is no wildlife in the wetlands");
			}
		}else{
			System.out.println("There is no existing wetlands");
		}
	}
	/**
	 * This method allows to see if the name of a certain species exists in any of the existing wetlands
	 */
	public void findSpecieInWetLands(){
		if(!controller.showAllWetLandInfo().equals("")){
			System.out.println("Type the name of the species you are looking for");
				String nameSpecie=sc.nextLine();
			String out =controller.findSpecieInWetLands(nameSpecie);
			if(!out.equals("")){
			System.out.println(out);
			}else{
				System.out.println("The species you are looking for could not be found");
			}
		}else{
			System.out.println("There is no existing wetlands");
		}
	}
}
