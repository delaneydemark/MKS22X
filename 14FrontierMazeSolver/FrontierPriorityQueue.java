public class FrontierPriorityQueue{
    MyHeap<Location> locations;

    public FrontierPriorityQueue(){
	locations = new MyHeap<Location>(false);
    }

    public void add(Location n){
	locations.add(n);
    }

    public boolean hasNext(){
	return !locations.size()==0;
    }

    public Location next(){
	return locations.remove();
    }
		    
}
