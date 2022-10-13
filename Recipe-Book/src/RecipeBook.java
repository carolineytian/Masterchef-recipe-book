import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.io.*;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import java.nio.file.Files;
import java.nio.file.Path;

public class RecipeBook extends ArrayList<Recipe> implements Serializable  {
	
	public void addRecipe(Recipe r) {
		this.add(r); 
	}
	

	public RecipeBook sortedBook(String sortedBy) {
		
		// making a copy to not completely change the recipe book itself 
		
		RecipeBook output = new RecipeBook();
		for (Recipe r : this) {
			output.add(r);
		}
		
		
		if (sortedBy.equalsIgnoreCase("alpha")) {
			Collections.sort(output, new sortByName());
		}
		
		if (sortedBy.equalsIgnoreCase("num")) {
			Collections.sort(output, new sortByTime());
		}
		
		return output;
		
	}
	
	public Recipe getRandom() {
		Random random = new Random(); 
		int randomIdx = random.nextInt(this.size());
		return this.get(randomIdx);
	}
	
	public void saveToDisk(Recipe r){
            {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            BufferedWriter writer = null;
            try
                {
                writer = new BufferedWriter( new FileWriter(s+"/Recipe-Book/src/Data.txt",true));
                writer.write(""+r);
                }
            catch ( IOException e)
                {
                }
            finally
            {
                try
                    {
                    if ( writer != null)
                    writer.close( );
                }
                catch ( IOException e)
                    {
                }
            }
            }
	}
	
	public String toString() {
		String output = "";
		for (Recipe r : this) {
			output += "\n";
			output += r.toString();
		}
		
		return output; 
		
	}



}
