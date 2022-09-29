import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RecipeBook extends ArrayList<Recipe> implements Serializable {
	
	public void addRecipe(Recipe r) {
		this.add(r); 
	}
	
	
	
}
