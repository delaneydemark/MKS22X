import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;

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


	//and start solving at the location of the s.

        //return solve(???,???);

    }
    
    
    public static void main(String[] args){
    	try{
    			Maze test = new Maze("Maze1.txt");
    			System.out.println(test.toString());
    		}catch(FileNotFoundException e){
    			System.out.println("File not found");
    			System.exit(1);
    		}
    }
}
