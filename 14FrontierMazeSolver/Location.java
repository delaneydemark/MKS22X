public class Location extends Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToStart;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Location(int _x, int _y, Location prev, int d){
	x = _x;
	y = _y;
	previous = prev;
	distanceToStart = d;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public int compareTo(Location a, Location b){
	return a.distanceToStart - b.distanceToStart;
    }
}
