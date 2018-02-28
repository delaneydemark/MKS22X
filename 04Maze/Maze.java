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
	    }
	    String[] lines = s.split("\n");
	    System.out.println(s);
	    System.out.println("\n");
	    for(int i = 0; i<lines.length; i++){
	    	System.out.println(lines[i]);
	    }
	    /*int rows = 0;
	    int cols = 0;
	    while(f.hasNextLine()){
			rows++;
			String line = f.nextLine();
			cols = line.length();
	    }
	    //String[] lines = f.nextLine().split("\n");
	    int rows = f.nextLine().length();
	    //int rows = lines.length;
	    //int cols = lines[0].length();
	    maze = new char[rows][35];
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
	    }*/
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
    	try{
    			Maze test = new Maze("Maze1.txt");
    			//System.out.println(test.toString());
    		}catch(FileNotFoundException e){
    			//Maze test = new Maze("Maze1.txt");
    			//System.out.println(test.toString());
    			System.out.println("Constructor throws exception every time");
    		}
    }
}
