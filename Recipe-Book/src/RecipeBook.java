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
		saveToDisk(r);
	}
	
	public void saveToDisk(Recipe r){
        try{
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            Files.write(Paths.get(s+"/Data.txt"),(""+r).getBytes(), APPEND);

        } catch(IOException e){
            System.out.println(toString());
        }
    }
}
