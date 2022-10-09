import java.util.Comparator;

class sortByName implements Comparator<Recipe> {
	// other sort by classes can be implemented to add browsing functionality - like sort by ingredients length, instructions length

	@Override
	public int compare(Recipe o1, Recipe o2) {
		// TODO Auto-generated method stub
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
	}

}
