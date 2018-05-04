public class Location{
    private int x,y;
    private Location previous;
    private int distanceToStart;

    public Location(int _x, int _y){
	x = _x;
	y = _y;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }
}
