import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


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
		
		return new Recipe("Brigadeiros", "Yummy and simple Brazilian dessert.", ingredients, instructions); 
	}
	
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
		
		return new Recipe("Homemade Flour Tortillas", "Traditional flour tortillas - homemade and much better than store bought. Do not substitute vegetable oil or shortening for the lard.", ingredients, instructions); 
	}
	
	public static Recipe initializeRecipe3() {
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
		
		return new Recipe("Pesto Pasta with Chicken", "Easy and delicious. Serve with crusty bread and salad for dinner.", ingredients, instructions); 
		
		
	}
	
	public static RecipeBook initializeRecipeBook() {
		RecipeBook rb = new RecipeBook() {
			{
				add(initalizeRecipe1());
				add(initializeRecipe2());
				add(initializeRecipe3());
			}
			
		};
		
		return rb;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------------
	
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
			System.out.println(input);
			if (input != "") {
				output.add(input); 
				i++; 
			} else {
				keepGoing = false;
			}
		}
		
		return output; 
	}

	
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
		
		
		
		
		return new Recipe (recipeName, recipeDescription, ingredients, instructions); 
	}


	
	
	public static void main(String[] args) {
		RecipeBook mainBook = initializeRecipeBook();
		
		Scanner input = new Scanner(System.in); 
		
		System.out.println("Welcome to MasterChef Recipe Book!");
		System.out.println("Select one option from the menu: \n"
				+ "[1] View your Recipe Book \n"
				+ "[2] Add recipe(s) to your Recipe Book \n"
				+ "[3] Leave MasterChef. \n");
		
		int option = input.nextInt();
		
		if (option == 1) {
			System.out.println(mainBook);
		} else if (option == 2) {
			Scanner sc = new Scanner(System.in);
			String more = "";
			
	        
	        Boolean keepAdding = true;
	        while (keepAdding) {
	        	 Recipe newRecipe = usersNewRecipe(); 
	        	 mainBook.add(newRecipe); 
	        	 System.out.println("Would you like to add a new recipe? Y/N?");
	        	 more = sc.next();
	        	 if (more.equalsIgnoreCase("n")) {
	        		 keepAdding = false;
	        	 }

	        }
			
		} else {
			System.exit(0);
		}
		
	
		
	}
}