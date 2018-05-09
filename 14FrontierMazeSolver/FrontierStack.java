import java.util.*;

//@SuppressWarnings("unchecked")
public class FrontierStack implements Frontier{
    private Stack<Location> locations;

    public FrontierStack(){
	locations = new Stack<Location>();
    }

    public void add(Location n){
	locations.push(n);
    }

    public Location next(){
	return locations.pop();
    }

    public boolean hasNext(){
	return !locations.empty();
    }
}
