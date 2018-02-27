import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    private String board[][];

    public Maze(){
	
	try{
	    File text = new File("Maze1.txt");
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
				board[count][j]= line.substring(j, j+1);
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
    	Maze test = new Maze();
    	System.out.println(test.toString());
    }
}