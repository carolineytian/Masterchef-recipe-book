import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import java.nio.file.Files;
import java.nio.file.Path;

public class RecipeBook extends ArrayList<Recipe> implements Serializable {
	
	public void addRecipe(Recipe r) {
		this.add(r); 
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
}
