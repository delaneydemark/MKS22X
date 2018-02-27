import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;

    public Maze(String fileName){;
	boolean = false;
	try{
	    File text = new File(fileName);
	    Scanner f = new Scanner(text);
	    
	    int rows = 0;
	    int cols = 0;
	    while(f.hasNextLine()){
		rows++;
		String line = f.nextLine();
		cols = line.length();
	    }
	    maze = new char[rows][cols];

	    int count = 0;
	    while(f.hasNext()){
		String line = f.nextLine();
		System.out.println(line);
		for(int j = 0; j<line.length(); j++){
		    maze[count][j]= line.charAt(j);
		}
		count++;
	    }

	    int start = 0;
	    int end = 0;
	    for(int i = 0; i<maze.length; i++){
		for(int j = 0; j<maze[i].length; j++){
		    if(start>1 || end>1 || (maze[j][i]!='E' && maze[j][i]!='S'
					    && maze[j][i]!=' ' && maze[j][i]!='#')){
			throw new IllegalStateException();
		    }
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
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


    
    
    public static void main(String[] args){
    	Maze test = new Maze("Maze1.txt");
    	System.out.println(test.toString());
    }
}
