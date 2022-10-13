import java.util.Comparator;

class sortByTime implements Comparator<Recipe> {
	// other sort by classes can be implemented to add browsing functionality - like sort by ingredients length, instructions length

	@Override
	public int compare(Recipe o1, Recipe o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.time, o2.time);
	}

}
