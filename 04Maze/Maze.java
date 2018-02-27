import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;

    public Maze(String fileName);
	
	try{
	    File text = new File(fileName);
	    Scanner f = new Scanner(text);
	    
	    /*int rows = 0;
	    int cols = 0;
	    while(f.hasNextLine()){
	    	String line = f.nextLine();
	    	rows++;
	    }*/
	    board = new String[9][35];

		int count = 0;
	    while(f.hasNext()){
			String line = f.nextLine();
			for(int j = 0; j<line.length(); j++){
			    board[count][j]= line.charAt(j);
			}
			count++;
		}
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}
    }
     
    public String toString(){
    	String s = "";
    	for(int i = 0; i<board.length; i++){
    		for(int j = 0; j<board[i].length; j++){
    			s+= board[i][j];
    		}
    		s+="\n";
    	}
    	return s;
    }
    
    
    public static void main(String[] args){
    	Maze test = new Maze("Maze1.txt");
    	System.out.println(test.toString());
    }
}
