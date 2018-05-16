public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToEnd;
    private int distanceSoFar;
    private int distance;
    private boolean AStar;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Location(int _x, int _y, Location prev, int d, boolean A){
	x = _x;
	y = _y;
	previous = prev;
	distanceToEnd = d;
	if(previous!=null){
	    distanceSoFar = previous.distanceSoFar() + 1;
	}else{
	    distanceSoFar = 0;
	}
	AStar = A;
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

    public int distanceSoFar(){
	return distanceSoFar;
    }

    public int compareTo(Location b){
	if(AStar){
	    return (this.distanceSoFar+this.distanceToEnd) - (b.distanceSoFar+b.distanceToEnd);
	}
	return this.distanceToEnd - b.distanceToEnd;
    }
}
