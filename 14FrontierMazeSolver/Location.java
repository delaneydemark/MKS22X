public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToEnd;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Location(int _x, int _y, Location prev, int d){
	x = _x;
	y = _y;
	previous = prev;
	distanceToEnd = d;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location b){
	return this.distanceToEnd - b.distanceToEnd;
    }
}
