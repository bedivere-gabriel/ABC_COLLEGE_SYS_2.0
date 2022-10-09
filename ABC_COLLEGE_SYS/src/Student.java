import java.util.Scanner;

public class Student extends Persons
{
	Scanner sc = new Scanner(System.in);
	
	String[] modules = 
		{
			"Introduction to Computing", "Computer Programming 1", "Introduction to Human Computer Interaction",
			"Computer Programming 2", "Data Structures and Algorithm", "Professional Development",
			"Discrete Structures 1", "Computer Systems and Architecture", "Discrete Structures 2",
			"Object Oriented Programming", "Information Management", "Design Thinking", "Algorithm",
			"Fundamentals of Analaysis", "Operating System", "Application Development of Emerging Technologies",
			"Technoprenuership", "Database Systems", "Networks and Communications 1", "Automata Theory",
			"CS Specialization 1", "CS Elective Parallel and Distributive Computing", "Mobile Programming", "Networks and Communcations 2",
			"Modeling and Simulation", "Software Engineering 1", "CS ELective Computer Graphics and Visual Computing",
			"CS Specialization 2", "CS Project Management", "Software Engineering 2", "Programming Languages",
			"CS Specialization 3", "Number Theory", "Information Assurance and Security", "CS Project 1",
			"CS Specialization 4", "Social Issues and Professional Practice", "CS Project 2", "CS Elective Intelligent Systems",
			"Internship 1", "Internship 2"
		};
	String[] selectedMods = new String[6];
	int[] selectedModules = new int[6];
	int totalModules = modules.length, newMods, repeatMods, numberofModules;
	float amountPaid, balance, totalAmount, subTotal1, subTotal2;
	
	public String[] getModuleList()
	{
		return this.modules;
	}
	
	public void displayModules() //Display Modules Function
	{
		for (int x = 0; x < totalModules; x++)
		{
			if (x % 5 == 0)
			{
				System.out.println("");
			}
			if (modules[x].length() > 16 )
			{
				System.out.print(x+1 + ". ");
				for (int y = 0; y < 16; y++)
				{
					System.out.print(modules[x].charAt(y));
				}
				System.out.print("\t\t");
			}
			else if (modules[x].length() < 11)
			{
				System.out.print(x+1 + ". ");
				for (int y = 0; y < modules[x].length(); y++)
				{
					System.out.print(modules[x].charAt(y));
				}
				System.out.print("\t\t\t");
			}
			else 
			{
				System.out.print(x+1 + ". " + modules[x] + "\t\t");
			}
			
		}
	}
	
	public void selectModules() //User Select Modules Function
	{	
		boolean running = true;
		
		while(running) 
		{
			System.out.println("Please Enter the Module Numbers: ");
			for (int x = 0; x < numberofModules; x++)
			{
				System.out.print(x+1 + ". Enter: ");
				selectedModules[x] = sc.nextInt();
				if (selectedModules[x] > totalModules)
				{
					System.out.println("Module Number Out of bounds");
					continue;
				}
				running = false;
			}	
		}
		
		//reduce the value of the numbers in the selectedModules by 1 to be equivalent with the element number of the modules array
		for (int x = 0; x < numberofModules; x++)
		{
			selectedModules[x] -= 1;
		}
		
		//get the selected modules from the modules array
		int z = 0;
		for (int x = 0; x < totalModules; x++)
		{
			for (int y = 0; y < numberofModules; y++)
			{
				if (x == selectedModules[y])
				{
					selectedMods[z] = modules[x];
					z++;
				}
			}
		}
		
		//display the selectedMods
		for (int x = 0; x < numberofModules; x++)
		{
			System.out.println(x+1 + ". " + selectedMods[x]);
		}
	}
	
	public float getAmounPaid(float amount) //get the amount paid of the student
	{
		this.amountPaid = amount;
		balance = (float) (totalAmount - amountPaid);
		return balance;
	}
	
	public void getModules() //get modules by number with specifier of new and repeated modules
	{
		boolean catchError = false, running = true;

		while (running)
		{
			System.out.println("Enter Repeat Modules (1-6): ");
			this.repeatMods = sc.nextInt();
			if (repeatMods < 3 && repeatMods > 0)
			{
				System.out.println("Repeat mods is less than 3 and greater than 0");
				System.out.println("Enter New Modules: ");
				this.newMods = sc.nextInt();
				this.totalModules = repeatMods + newMods;
				System.out.println(totalModules);
				
				if (totalModules > 6)
				{
					catchError = true;
					System.out.println("catchError Fired True");	
				}
				else 
				{
					catchError = false;
				}
			}
			
			else if (repeatMods >= 3 && repeatMods <= 6)
			{
				System.out.println("Repeat Mods >= 3 AND <= 6");
				break;
			}
			
			else 
			{
				System.out.println("Repeat Mods Out of bounds");
				continue;
			}
			
			if (catchError == true)
			{
				System.out.println("CatchError Fired Continue");
				continue;
			}
				
			else if (catchError == false)
			{
				System.out.println("CatchError Fired Break");
				break;
			}
		}
		System.out.println("New Modules: " + newMods + "\tRepeat Modules: " + repeatMods);		
		this.numberofModules = this.repeatMods + this.newMods;
	}
	
	public float computeTotalAmount() //compute total assessment of the student
	{
		subTotal1 = 525 * newMods;
		subTotal2 = 110 * repeatMods;
		totalAmount = subTotal1 + subTotal2;
		return totalAmount;
	}
	
	
}