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
	while(frontier.hasNext()){
	    //  get the next location
	    //  process the location to find the locations (use the maze to do this)
	    Location[] neighbors = maze.getNeighbors(frontier.next());
	    //  check if any locations are the end, if you found the end just return true!
	    for(int i = 0; i<neighbors.length; i++){
		if(neighbors[i]!=null){
		    if(neighbors[i].getX()==maze.getEnd().getX() && neighbors[i].getY()==maze.getEnd().getY()){
			return true;
		    }
		//  add all the locations to the frontier
		frontier.add(neighbors[i]);
		}
	    }
	    if(animate){
		System.out.println(toString());
	    }
	}
	//when there are no more values in the frontier return false
	return false;
    }

    public String toString(){
	return maze.toString();
    }

    public static void main(String[] args){
	MazeSolver test = new MazeSolver("data1.dat");

	System.out.println(test.solve(0));
    }
}
