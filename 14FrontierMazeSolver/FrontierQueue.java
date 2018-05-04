public class FrontierQueue implements Frontier{
    private Queue<Location> locations;

    public FrontierQueue(){
	locations = new Queue<Location>();
    }

    public void add(Location s){
	locations.add(s);
    }

    public Location next(){
	return locations.remove();
    }

    public boolean hasNext(){
	return locations.poll()!=null;
    }
}
