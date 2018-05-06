public class FrontierQueue implements Frontier{
    private Queue<Location> locations;

    public FrontierQueue(){
	locations = new LinkedList<Location>();
    }

    public void add(Location n){
	locations.add(s);
    }

    public Location next(){
	return locations.remove();
    }

    public boolean hasNext(){
	return locations.peek()!=null;
    }
}
