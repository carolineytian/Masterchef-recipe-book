import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// class for commandline user interaction
//Recipe(String name, String description, ArrayList<String> ingredients, ArrayList<String> instructions)


public class Main {
	// ignore the following, populating dummy recipes with lots of text to play around with 
	
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
				 add("Combine condensed milk, cocoa, and butter in a medium saucepan over medium heat.");
				 add("Cook and stir until thickened, about 10 minutes.");
				 add("Remove from heat and let rest until mixture is cool enough to handle.");
				 add("Use your hands to shape into small balls and place on a serving plate.");
				 add("Can be eaten at once or chilled until serving.");
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
				 add("Whisk the flour, salt, and baking powder together in a mixing bowl.");
				 add("Mix in the lard with your fingers until the flour resembles cornmeal.");
				 add("Add the water and mix until the dough comes together;");
				 add("Place on a lightly floured surface and knead a few minutes until smooth and elastic.");
				 add("Divide the dough into 24 equal pieces and roll each piece into a ball.");
				 add("Preheat a large skillet over medium-high heat.");
				 add("Use a well-floured rolling pin to roll a dough ball into a thin, round tortilla.");
				 add("Place into the hot skillet, and cook until bubbly and golden; flip and continue cooking until golden on the other side.");
				 add("Place the cooked tortilla in a tortilla warmer; continue rolling and cooking the remaining dough.");
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
				 add("Bring a large pot of lightly salted water to a boil.");
				 add("Add pasta and cook until al dente, 8 to 10 minutes; drain.");
				 add("Heat oil in a large skillet over medium heat.");
				 add("Sauté garlic until tender, then stir in chicken and season with red pepper flakes.");
				 add("Cook until chicken is golden and cooked through.");
				 add("Combine pasta, chicken, pesto, and sun-dried tomatoes in a large bowl - toss to coat evenly.");
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
	
	
	
	public static void main(String[] args) {
		
		RecipeBook mainBook = initializeRecipeBook();
		System.out.println(mainBook);
		
		//initialize variable
		int optionSearchBrowse = 0;
		String recipeName;
		
		System.out.println("Welcome to the Recipe Book recipes page!");
		
		Scanner input = new Scanner(System.in);
	
				
		while (optionSearchBrowse != 3) {
			
			System.out.println("Would you like to ");
			System.out.println("1: Search by recipe name");
			System.out.println("2: Browse all recipes");
			System.out.println("3: Quit");
			System.out.print("Enter an option: ");
			
			optionSearchBrowse = input.nextInt();
			
			if (optionSearchBrowse == 1) {
				System.out.print("Enter the name of the recipe: ");
				recipeName = input.nextLine();
				searchRecipe(recipeName, mainBook);
				break;
			} //end of
		
			else if (optionSearchBrowse == 2) {
				System.out.println("Enter the name of the recipe: ");
				recipeName = input.nextLine();
				//browseRecipe(recipeName, mainBook);
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

	} //end public static void main

	//method to search for a recipe in the array
	public static void searchRecipe(String recipeName, RecipeBook mainBook) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the name of the recipe: ");
		recipeName = input.nextLine();
		for (int i = 0; i < mainBook.size(); i++) {
			//look through every index of the array to find the matched recipe name
	    	if (mainBook.get(i).getName().equals(recipeName)) {
	    		System.out.println("The recipe was found! Here it is: " + recipeName.toString());
	    		//mainBook.get(i).toString();
	   			break;
	   		} //end if
	    	else if (i == mainBook.size() - 1) {
	    		System.out.println("Sorry, the recipe with that name was not found.");
	    	} //end else
	    } //end for
	 } //end searchRecipe
}
