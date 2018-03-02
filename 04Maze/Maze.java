import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private int[][] possibleMoves = {{1,0},{-1,0},{0,1},{0,-1}};

    public Maze(String fileName) throws FileNotFoundException{;
	boolean animate = false;
	
	File text = new File(fileName);
	Scanner f = new Scanner(text);
	    
	    
	String s = "";
	while(f.hasNextLine()){
	    s+=f.nextLine();
	    s+="\n";
	}
	String[] lines = s.split("\n");
	maze = new char[lines.length][lines[0].length()];
	    
	int start = 0;
	int end = 0;
	for(int i = 0; i<maze.length; i++){
	    for(int j = 0; j<maze[0].length; j++){
		if(start>1 || end>1){
		    throw new IllegalStateException();
	    	}
		if(lines[i].charAt(j)!='E' && lines[i].charAt(j)!='S'
		   && lines[i].charAt(j)!='#' && lines[i].charAt(j)!=' '
	    	   && lines[i].charAt(j)!='\n'){
		    throw new IllegalStateException();
	    	}
	    	maze[i][j] = lines[i].charAt(j);
	    }
	}

    }
     
    public String toString(){
	String s = "";
    	for(int i = 0; i<maze.length; i++){
	    for(int j = 0; j<maze[i].length; j++){
		s+= maze[i][j];
    	    }
	    s+="\n";
    	}
    	return s;
    }

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }


    public void setAnimate(boolean b){

	animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }


    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

	//find the location of the S.
	int row = 0;
	int col = 0;
	for(int i = 0; i<maze.length; i++){
	    for(int j = 0; j<maze[i].length; j++){
		if(maze[i][j]=='S'){
		    row = i;
		    col = j;
		}
	    }
	}
	//erase the S
	maze[row][col]=' ';
	return solve(row,col,0, false);
    }


        /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int count){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
	if(animate){

	    clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE
	if(maze[row][col]=='E'){
	    return count;
	}
	if(maze[row][col]==' '){
	    maze[row][col]='@';
	}

	for(int i = 0, i<possibleMoves.length; i++){
	    if(row+possibleMoves[i][0]<maze.length && row+possibleMoves[i][0]>=0 &&
	       col+possibleMoves[i][1]<maze.length && col+possibleMoves[i][1]>=0){
		if(maze[row+possibleMoves[i][0]][col+possibleMoves[i][1]]==' ' ||
		   maze[row+possibleMoves[i][0]][col+possibleMoves[i][1]]=='E'){
		    return solve(row+possibleMoves[i][0], col+possibleMoves[i][1], count+1, false);
		}
	    }
	}

	maze[row][col]='.';

	for(int i = i<possibleMoves.length; i++){
	    
	}

	
	    /*if(row+1<maze.length){
	    if(maze[row+1][col]==' ' || maze[row+1][col]=='E'){
		return solve(row+1, col, count+1, false);
	    }
	}
	if(col-1>=0){
	    if(maze[row][col-1]==' ' || maze[row][col-1]=='E'){
		return solve(row, col-1, count+1, false);
	    }
	}
	if(col+1<maze[0].length){
	    if(maze[row][col+1]==' ' || maze[row][col+1]=='E'){
		return solve(row, col+1, count+1, false);
	    }
	}
       if(row-1>=0){
	    if(maze[row+1][col]==' ' || maze[row+1][col]=='E'){
		return solve(row-1, col, count+1, false);
	    }
	}
	
	if(row+1<maze.length){
	    if(maze[row+1][col]=='@'){
		return solve(row+1, col, count-1, true);
	    }
	}
	if(col-1>=0){
	    if(maze[row][col-1]=='@'){
		return solve(row, col-1, count-1, true);
	    }
	}
	if(col+1<maze[0].length){
	    if(maze[row][col+1]=='@'){
		return solve(row, col+1, count-1, true);
	    }
	}
	if(row-1>=0){
	    if(maze[row-1][col]=='@'){
		return solve(row-1, col+1, count-1, true);
	    }
	    }*/
	

        return -1;
    }

    
    public static void main(String[] args){
    	try{
    			Maze test = new Maze("Maze1.txt");
    			System.out.println(test.toString());
			System.out.println(test.solve());
			test.setAnimate(true);
			System.out.println(test.solve());
    		}catch(FileNotFoundException e){
    			System.out.println("File not found");
    			System.exit(1);
    		}
    }
}
