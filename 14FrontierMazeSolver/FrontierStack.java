public class FrontierStack implements Frontier{
    private Stack locations;

    public FrontierStack(){
	locations = new Stack();
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
