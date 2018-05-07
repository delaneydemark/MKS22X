import java.util.*;

@SuppressWarnings("unchecked")
public class FrontierStack implements Frontier{
    private LinkedList<Location> locations;

    public FrontierStack(){
	locations = new LinkedList();
    }

    public void add(Location n){
	locations.addLast(n);
    }

    public Location next(){
	return locations.removeLast();
    }

    public boolean hasNext(){
	return locations.size()!=0;
    }
}
