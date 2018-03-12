import java.util.*;
import java.io.*;


public class USACO{

    public static int bronze(String filename){
	int[][] elevations;
	int elevation;
	int volume = 0;
	try{

	    File text = new File(filename);
	    Scanner f = new Scanner(text);

	    int rows = f.nextInt();
	    int cols = f.nextInt();
	    elevation = f.nextInt();
	    int instructions = f.nextInt();
	

	    elevations = new int[rows][cols];

	    for(int i = 0; i<elevations.length; i++){
		for(int j = 0; j<elevations[i].length; j++){
		    elevations[i][j]=f.nextInt();
		}
	    }

	    for(int i = 0; i<instructions; i++){
		int upperR = f.nextInt();
		int upperC = f.nextInt();
		int down = f.nextInt();
		bronzeH(upperR-1, upperC-1, down, elevations);
	    }

	    for(int i = 0; i<elevations.length; i++){
		for(int j = 0; j<elevations[0].length; j++){
		    if(elevations[i][j]<= elevation){
			elevations[i][j]= elevation - elevations[i][j];
			volume+=elevations[i][j];
		    }
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}

	
	
	return volume * 72 * 72;
	
    }

    public static void bronzeH(int upperR, int upperC, int down, int[][] elevations){
	int max = 0;
	for(int i = 0; i<3; i++){
	    for(int j = 0; j<3; j++){
		if(upperR+i<elevations.length && upperC+j<elevations[0].length){
		    if(elevations[upperR+i][upperC+j]>max){
			max = elevations[upperR+i][upperC+j];
		    }
		}
	    }
	}

	for(int i = 0; i<3; i++){
	    for(int j = 0; j<3; j++){
		if(upperR+i<elevations.length && upperC+j<elevations[0].length){
		    if(max-elevations[upperR+i][upperC+j]<=down){
			elevations[upperR+i][upperC+j] -= down - (max - elevations[upperR+i][upperC+j]);
		    }
		}
	    }
	}
    }

    public static int silver(String filename){
	int time;
	int startR;
	int startC;
	int endR;
	int endC;
	char map[][];
	int[][] last;
	int[][] current;
	int total = 0;
	try{
	    File text = new File(filename);
	    Scanner f = new Scanner(text);

	    int rows = f.nextInt();
	    int cols = f.nextInt();
	    time = f.nextInt();

	   
	    map = new char[rows][cols];
	    last = new int[rows][cols];
	    current = new int[rows][cols];
	    
	    String s = "";
	    while(f.hasNext() && !(f.hasNextInt())){
		s+=f.next();
		s+="\n";
	    }

	    String[] lines = s.split("\n");
	    
	    for(int i =0 ; i<lines.length; i++){
		for(int j = 0; j<lines[0].length(); j++){
		    map[i][j]=lines[i].charAt(j);
		}
	    }
     
	    startR = f.nextInt();
	    startC = f.nextInt();

	    endR = f.nextInt();
	    endC = f.nextInt();
	    
	    int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
	    last[startR][startC] = 1;
	    for(int i = 0; i<time; i++){
		for(int r = 0; r<rows; r++){
		    for(int c = 0; c<cols; c++){
			if(i%2==0 && map[r][c]!='*'){
			    if(last[r][c]>0){
				current[r][c]=0;
			    }else{
				int possibleMoves = 0;
				for(int m = 0; m<moves.length; m++){
				    if(r+moves[m][0]>=0 && r+moves[m][0]<rows
				       && c+moves[m][1]>=0 && c+moves[m][1]<cols){
					possibleMoves+=last[r+moves[m][0]][c+moves[m][1]];
				    }
				}
				current[r][c]=possibleMoves;
			    }
			}else(map[r][c]!='*'){
				if(current[r][c]>0){
				    last[r][c]=0;
				}else{
				    int possibleMoves = 0;
				    for(int m = 0; m<moves.length; m++){
					if(r+moves[m][0]>=0 && r+moves[m][0]<rows
					   && c+moves[m][1]>=0 && c+moves[m][1]<cols){
					    possibleMoves+=current[r+moves[m][0]][c+moves[m][1]];
					}
				    }
				    last[r][c]=possibleMoves;
				}
			}
		    }
		}
	    }
	    

	    

  
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}
	return total;
    }


    public static void main(String[] args){
	// should be 342144
	//System.out.println(USACO.bronze("makelake.txt"));
	System.out.println(USACO.silver("ctravel.txt"));
    }

}
