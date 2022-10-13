import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ResourceBundle.Control;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;



// class for commandline user interaction
//Recipe(String name, String description, ArrayList<String> ingredients, ArrayList<String> instructions)


public class Main {
	// ignore the following, populating dummy recipes with lots of text to play around with 
	// ------------------------------------------------------------------------------------------------------------------------------
	
	public static Recipe initalizeRecipe1() {

		// from https://www.allrecipes.com/recipe/24052/brigadeiro/
		ArrayList<String> ingredients = new ArrayList<String>(){
			{
				add("1 (14 ounce) can sweetened condensed milk");
				add("3 tablespoons unsweetened cocoa");
				add("1 tablespoon butter");
			}
		};
		ArrayList<String> instructions = new ArrayList<String>(){
			{
				add("Combine condensed milk, cocoa, and butter in a medium saucepan over medium heat. Cook and stir until thickened, about 10 minutes. Remove from heat and let rest until mixture is cool enough to handle.");
				add("Use your hands to shape into small balls and place on a serving plate. Can be eaten at once or chilled until serving.");
				add("ENJOY!");
			}
		};
		int time = 50;
		return new Recipe("Brigadeiros", "Yummy and simple Brazilian dessert.", ingredients, instructions, time); 
	} //initializeRecipe1
	
	public static Recipe initializeRecipe2() {
		// from https://www.allrecipes.com/recipe/157642/homemade-flour-tortillas/
		
		ArrayList<String> ingredients = new ArrayList<String>(){
			{
				add("4 cups all-purpose flour");
				add("1 teaspoon salt");
				add("2 teaspoons baking powder");
				add("2 tablespoons lard");
				add("1.5 cups water"); 
			}
		};
		ArrayList<String> instructions = new ArrayList<String>(){
			{
				add("Whisk the flour, salt, and baking powder together in a mixing bowl. "
				 		+ "Mix in the lard with your fingers until the flour resembles cornmeal. "
				 		+ "Add the water and mix until the dough comes together; "
				 		+ "place on a lightly floured surface and knead a few minutes until smooth and elastic. D"
				 		+ "ivide the dough into 24 equal pieces and roll each piece into a ball.");
				add("Preheat a large skillet over medium-high heat. "
				 		+ "Use a well-floured rolling pin to roll a dough ball into a thin, round tortilla. P"
				 		+ "lace into the hot skillet, and cook until bubbly and golden; flip and continue cooking until golden on the other side. "
				 		+ "Place the cooked tortilla in a tortilla warmer; continue rolling and cooking the remaining dough.");
			}
		};
		int time = 75;
		return new Recipe("Homemade Flour Tortillas", "Traditional flour tortillas - homemade and much better than store bought. Do not substitute vegetable oil or shortening for the lard.", ingredients, instructions, time); 
	} //initializeRecipe2
	
	public static Recipe initializeRecipe3()  { //this is not running 
		// from https://www.allrecipes.com/recipe/46982/pesto-pasta-with-chicken/
		ArrayList<String> ingredients = new ArrayList<String>(){
			{
				add("1 (16 ounce) package bow tie pasta");
				add("1 teaspoon olive oil");
				add("2 cloves garlic, minced");
				add("2 skinless, boneless chicken breasts, cut into bite-sized pieces");
				add("1 pinch crushed red pepper flakes, or to taste");
				add("1/2 cup pesto sauce");
				add("⅓ cup oil-packed sun-dried tomatoes, drained and cut into strips");
			}
		};
		
		ArrayList<String> instructions = new ArrayList<String>(){
			{
				add("Bring a large pot of lightly salted water to a boil. Add pasta and cook until al dente, 8 to 10 minutes; drain.");
				add("Heat oil in a large skillet over medium heat. Sauté garlic until tender, then stir in chicken and season with red pepper flakes. Cook until chicken is golden and cooked through.");
				add("Combine pasta, chicken, pesto, and sun-dried tomatoes in a large bowl; toss to coat evenly.");
			}
		};
		int time = 30;
		return new Recipe("Test", "Easy and delicious. Serve with crusty bread and salad for dinner.", ingredients, instructions, time); 
	} //end initializeRecipe3

	public static RecipeBook initializeRecipeBook() {
		RecipeBook rb = new RecipeBook() {
			{
				add(initalizeRecipe1());
				add(initializeRecipe2());
				add(initializeRecipe3());
			}
			
		};
		return rb;
	} //end initializeRecipeBook
	
	// ---------------------------------------------------------------------------------------------------------------------------------
	
	//method for search recipe in the recipe list 
	public static void BrowseRecipe(int recipeNumber,RecipeBook mainbook) {

		RecipeBook mainBook = mainbook;
		int recipeNum = recipeNumber;
		Scanner sc = new Scanner(System.in);

			//Options to see all or instructions step-by-step
			if (recipeNum <= mainBook.size()) {
				System.out.println("1. See all information for one recipe");
				System.out.println("2. See instructions step-by-step for one recipe");
				int selectNum = sc.nextInt();
				if (selectNum == 1) {
					System.out.println(mainBook.get(recipeNum-1));
				} //end if
				else if (selectNum == 2) {
					ArrayList<String> instructions = mainBook.get(recipeNum-1).getInstructions();
					for (int i = 0; i < instructions.size(); i++) {
						System.out.println((i+1) + ":" + instructions.get(i));
						if (i+1==instructions.size()) {
							System.out.println("This is the end of the recipe!");
						} //end if
						else {
							System.out.print("Enter to go to the next instruction");
						} //end else
						if (i == 0) { //this is the line i added to fix the enter 
							sc.nextLine();
						} //clears the buffer 
						String nextinstruction= sc.nextLine();
							if(nextinstruction.isEmpty()){
								System.out.println();
								continue;
								} //end if
								else {
								System.out.println("You should enter to go to the next instruction");
							} //end else
					} //end for
				} //end if
				else {
					System.out.println("Enter a valid option");
				} //end else
				
			} //end if
			else {
				System.out.println("You need to choose the number that is on the recipe list");
			} //end else
			
			//Type anything to go back
			System.out.println("Type anything to go back to recipe list");
			String typeAnything = sc.next();
		} //public static void BrowseRecipe
	

	public static ArrayList<String> askingUser(Scanner sc, String type) {
		
		System.out.println("Input your " + type + "s, " 
				+ "\npressing ENTER after each " + type + ".\nWhen you've completed adding to your recipe, just press ENTER.");
		
		ArrayList<String> output = new ArrayList<String>(); 
		int i = 1;
		String input = "";
		Boolean keepGoing = true;
		
		while (keepGoing) {
			System.out.println("Enter " + type + " " + i + ": ");
			input = sc.nextLine(); 
			//deleted print input to prevent from printing twice 
			if (input != "") {
				output.add(input); 
				i++; 
			} //end if
			else {
				keepGoing = false;
			} //end else
		} //end while keepGoing
		
		return output; 
	} //end askingUser

	
	public static Recipe usersNewRecipe() { 
		// Using Tiffany's logic from previous implementation, with a slight update to allow for re-usability and minimize opportunity for error. 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Creating a new recipe...");
		
		System.out.println("Recipe Name: ");
		
		String recipeName = sc.nextLine();
		System.out.println("Recipe Description: ");
		String recipeDescription = sc.nextLine();
		
		ArrayList<String>ingredients = askingUser(sc, "ingredient"); 
		ArrayList<String> instructions = askingUser(sc, "instruction"); 
		
		System.out.println("Recipe Time: ");
		String recipeTime = sc.nextLine();
		int time; 
		if (recipeTime == "") {
			time = 0; 
		} else {
			time = Integer.parseInt(recipeTime);
		}
		
		
		return new Recipe(recipeName, recipeDescription, ingredients, instructions, time);
	
		//rb.addRecipe(new Recipe (recipeName, recipeDescription, ingredients, instructions, recipeTime));
	}


	public static void main(String[] args) throws FileNotFoundException {

		RecipeBook mainBook = initializeRecipeBook(); 
		//read Recipe 
		Path currentRelativePath1 = Paths.get("");
        String s1 = currentRelativePath1.toAbsolutePath().toString();
		try {
			System.out.println(s1);
			FileInputStream fis = new FileInputStream(s1+"/Recipe-Book/src/Data.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			mainBook = (RecipeBook) ois.readObject();  
			System.out.println(mainBook);
			fis.close();
			ois.close();

			
		} catch(IOException e){

		} catch(ClassNotFoundException cl) {

		}
		finally
		{
		}
		
		//mainBook = initializeRecipeBook(); //run to set dummies, if not closed properly, need to reset 
		
		//initialize variable
		int option = 0;
		System.out.println("Welcome to MasterChef Recipe Book!");
		
		Scanner input = new Scanner(System.in); 
		
		while (option != 5) {
			System.out.println("Select one option from the menu: \n"
					+ "[1] 📖 View your ENTIRE Recipe Book \n"
					+ "[2] 🍝 Add recipe(s) to your Recipe Book \n"
					+ "[3] 🕶 Retrieve recipes by browsing (filtering) or searching. \n"
					+ "[4] ✌️ Exit out of MasterChef");
			
			option = input.nextInt();
			
			if (option == 1) {
				int o = 1;
				while(o == 1) {
					//change the string 
					for (int i = 0; i < mainBook.size(); i++) {
						System.out.println((i+1)+ ":" + mainBook.get(i).getName());
					} //end for
					System.out.println("Select one recipe or enter 100 to go back to the main menu"); //can change this to enter instead of 100 
					
					Scanner sc = new Scanner(System.in);
					int recipeNum = sc.nextInt();
					
					//if input 100, exit 
					if (recipeNum == 100) {
						break;
					} //end if
					else {
						BrowseRecipe(recipeNum, mainBook);
					} //end else
				} //end while
			} //end if
			else if (option == 2) {
				Scanner sc = new Scanner(System.in);
				String more = "";
				
				Boolean keepAdding = true;
				while (keepAdding) {
					Recipe newRecipe = usersNewRecipe(); 
					mainBook.add(newRecipe);

			// will delete this once we check write and read to disk, please leave it for now 
			// Path currentRelativePath = Paths.get("");
            // String s = currentRelativePath.toAbsolutePath().toString();
            // BufferedWriter writer = null;
            // try
            // {
			// 	FileOutputStream fos = new FileOutputStream(s+"/Recipe-Book/src/Data.txt",true);
			// 	ObjectOutputStream oos = new ObjectOutputStream(fos);
			// 	oos.writeObject(mainBook);
			// 	oos.close();
            // }
            // catch ( IOException e)
            // {
            // }
            // finally
            // {
            //     try
            //     {
            //         if ( writer != null)
            //         writer.close( );
            //     }
            //     catch ( IOException e)
            //     {
            //     }
            // }

					System.out.println("Would you like to add a new recipe? Y/N?");
					more = sc.next();
					if (more.equalsIgnoreCase("n")) {
						keepAdding = false;
					} //end if
	          	} //end while

			} //end else if
			else if (option == 3) {
			
				//initialize variable
				int optionSearchBrowse = 0;
				String recipeName;
				
				Scanner searchBrowse = new Scanner(System.in);
				
				while (optionSearchBrowse != 3) {
				
					System.out.println("Would you like to ");
					System.out.println("1: Search by recipe name");
					System.out.println("2: Browse recipes (sort by...)");
					System.out.println("3: Quit");
					System.out.print("Enter an option: ");
					
					optionSearchBrowse = input.nextInt();
					
					if (optionSearchBrowse == 1) {
						//System.out.println("Enter the name of the recipe: ");
						recipeName = input.nextLine();
						Recipe  r = searchRecipe(recipeName, mainBook);
						if (r != null) {
							System.out.println(r.toString());
						} //end if
						
						break;
					} //end if
			
					else if (optionSearchBrowse == 2) {
						System.out.println("How would you like to sort your recipes?");
						Scanner howToBrowse = new Scanner(System.in); 
						System.out.println("1: In alphabetical order");
						System.out.println("2: By time to complete recipe");
						int sortBy = howToBrowse.nextInt(); 
						
						if (sortBy == 1) {
							System.out.println("The sorted recipes by name are: ");
							RecipeBook sorted = mainBook.sortedBook("alpha");
							System.out.println(sorted.toString());
							

							//Returns to the main menu
							Scanner sc = new Scanner(System.in);
							System.out.println("Type anything to go back");
							String typeAnything = sc.next();
						} //end if
						//break;
						
						if (sortBy == 2) {
							System.out.println("The sorted recipes by time are: ");
							RecipeBook sorted = mainBook.sortedBook("num");
							//System.out.println(sorted.toString());
							//Returns to the main menu
							System.out.println("Minutes\t\tName");
							for (Recipe r : sorted) {
								System.out.println(r.time + "\t\t" + r.name);
							}
							Scanner sc = new Scanner(System.in);
							System.out.println("Type anything to go back");
							String typeAnything = sc.next();
				
						} //end if
						break;
						
						
					} //end else if
					
					else if (optionSearchBrowse == 3) {
						System.out.println("Leaving Recipe Book recipes page");
						break;
					} //end else if
					
					else {
						System.out.println("Sorry, this choice is invalid. Please try again.");
					} //end else
				} //end while
			} //end else if 
			else if (option == 4) {
				System.out.println("Thank you for using the Masterchef Recipe Book!");
				break;
			} //end else if
			else {
				System.out.println("Sorry, this choice is invalid. Please try again.");
				//System.exit(0);
			} //end else
		} //end while
		
		//write to disk
		Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            BufferedWriter writer = null;
            try
            {
				FileOutputStream fos = new FileOutputStream(s+"/Recipe-Book/src/Data.txt",false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(mainBook);
				oos.close();
            }
            catch ( IOException e )
            {
            }
            finally
            {
                try
                {
                    if ( writer != null)
                    writer.close( );
                }
                catch ( IOException e )
                {
                }
            }
		input.close();
	} //end public static void main

	
	//method to search for a recipe in the array 
	public static Recipe searchRecipe(String recipeName, RecipeBook mainBook) {
			
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the name of the recipe: ");
		recipeName = input.nextLine().toLowerCase();
		
		for (int i = 0; i < mainBook.size(); i++) {
			//look through every index of the array to find the matched recipe name
			if (mainBook.get(i).getName().toLowerCase().contains(recipeName)) {
				System.out.println("The recipe " + mainBook.get(i).getName() + " was found!");

				int explorationChoice = 0;
				while (explorationChoice != 3) {
					System.out.println("Would you like to \n"
							+ "1. Read the entire recipe (including the description, ingredients, and instructions) \n"
							+ "2. Step through the instructions one at a time");
					System.out.println("Enter your choice: ");
					explorationChoice = input.nextInt();
					if (explorationChoice == 1) {
						return mainBook.get(i);
					} //end if
					else if (explorationChoice == 2) {

						System.out.println("Before we get to step by step instructions, some people prefer to prepare ingredients first.");
		    			System.out.println("Would you like to view the ingredients? (Please enter Y for yes and N for No)");
		    			System.out.print("Enter your choice: ");
		    			input.nextLine();
		    			String ingredientsYesNo = input.nextLine().toLowerCase();
		    			
		    			if (ingredientsYesNo.equals("y")) {
		    				System.out.println("Here are the ingredients: ");
		    				ArrayList<String> ingredients = mainBook.get(i).getIngredients();
		    				for (int ingredientNum = 0; ingredientNum < ingredients.size(); ingredientNum++) {
			    				System.out.println(ingredients.get(ingredientNum));
		    				} //end for
		    				System.out.println("\nYou have viewed all the ingredients. Now continuing to step by step instructions! \n");
		    			} //end if
		    			else if (ingredientsYesNo.equals("n")) {
		    				System.out.println("Continuing to step by step instructions! \n");
		    			} //end else if

						ArrayList<String> instructions = mainBook.get(i).getInstructions();
						
						for (int j = 0; j < instructions.size(); j++) {
							System.out.println("Step " + (j+1) + ": " + instructions.get(j));
							if(j+1 == instructions.size()) {
								System.out.println("This is the end of the recipe!");
							} //end if
							else {
								System.out.print("Press ENTER to go to the next instruction step");
							} //end else
							
							if (j == 0) {
								input.nextLine();
							} //clears the buffer 
							
							String nextInstructionStep = input.nextLine();			
							if(nextInstructionStep.isEmpty()) {
								System.out.println();
								continue;
							} //end if
							else {
								System.out.println("Press ENTER to go to the next instruction step");
							} //end else
						} //end for
						System.out.println("You have completed the recipe - returning to main option menu dashboard now!");
						break;
					} //end else if
					else if (explorationChoice == 3) {
						System.out.println("Returning to main option menu dashboard.");
						break;
					} //end else if
					else {
						System.out.println("Sorry, this choice is invalid. Please try again.");
						System.out.println("Try another method. Returning to main dashboard...");
					} //end else
				} //end while
			} //end if
			else if (i == mainBook.size() - 1) {
				System.out.println("Sorry, the recipe with that name was not found.");
			} //end else
		} //end for
		return null;
	} //end searchRecipe
	
} //end public class Main
