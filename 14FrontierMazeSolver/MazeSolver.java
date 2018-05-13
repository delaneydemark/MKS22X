public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;
   

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
	animate = true;
    }

    //Default to BFS
    public boolean solve(){ return solve(0); }

    //mode: required to allow for alternate solve modes.
    //0: BFS --> queue
    //1: DFS --> stack
    public boolean solve(int mode){
	//initialize your frontier
	if(mode==0){
	    frontier = new FrontierQueue();
	}else{
	    frontier = new FrontierStack();
	}
	//while there is stuff in the frontier:
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    //  get the next location
	    Location loc = frontier.next();
	    //  process the location to find the locations (use the maze to do this)
	    maze.set(loc.getX(), loc.getY(), '.');
	    Location[] neighbors = maze.getNeighbors(loc);
	    //  check if any locations are the end, if you found the end just return true!
	    for(int i = 0; i<neighbors.length && neighbors[i]!=null; i++){
		    if(maze.getEnd().getX()==neighbors[i].getX() &&
		       maze.getEnd().getY()==neighbors[i].getY()){
			//maze.set(loc.getX(), loc.getY(), '.');
			Location l = neighbors[i].getPrev();
			while(l.getX()!=maze.getStart().getX() || l.getY()!=maze.getStart().getY()){
			    maze.set(l.getX(), l.getY(), '@');
			    l = l.getPrev();
			    System.out.println(maze.toStringColor());
			}
			//System.out.println(maze.toStringColor());
			maze.set(maze.getStart().getX(), maze.getStart().getY(), '@');
			System.out.println(maze.toStringColor());
			return true;
		    }
		    //  add all the locations to the frontier
		   	
		    frontier.add(neighbors[i]);
		    
		
	    }
	    if(animate){
		System.out.println(maze.toStringColor());
	    }
	}
	//when there are no more values in the frontier return false
	return false;
    }

    public String toString(){
	return maze.toString();
    }

    public static void main(String[] args){
	MazeSolver test = new MazeSolver("data2.dat");

	System.out.println(test.solve(1));
    }
}
