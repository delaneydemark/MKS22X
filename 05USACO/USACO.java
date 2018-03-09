import java.util.*;
import java.io.*;


public class USACO{

    public static int bronze(String filename){
	int elevations[][];
	int elevation;
	try{

	    File text = new File(filename);
	    Scanner f = new Scanner(text);

	    int rows = f.nextnt();
	    int cols = f.nextInt();
	    elevation = f.nextInt();
	    int instructions = f.nextInt();
	

	    elevations     = new int[rows][cols];

	    for(int i = 0; i<elevations.length; i++){
		for(int j = 0; j<elevations[i].length; j++){
		    map[i][j]=f.nextInt();
		}
	    }

	    for(int i = 0; i<instructions; i++){
		int upperR = f.nextInt();
		int upperC = f.nextInt();
		int down = f.nextInt();
		bronzeH(upperR, upperC, down);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}

	int volume = 0;
	for(int i = 0; i<elevations.length; i++){
	    for(int j = 0; j<elevations[0].length; j++){
		if(elevations[i][j]<= elevation){
		    elevations[i][j]= elevation - elevations[i][j];
		    volume+=elevations[i][j];
		}
	    }
	}
	return volume * 72 * 72;
	
    }

    public static void bronzeH(int upperR, int upperC, int down){
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
	try{
	    File text = new File(filename);
	    Scanner f = new Scanner(text);

	    int rows = f.nextInt();
	    int cols = f.nextInt();
	    time = f.nextInt();

	    String s = "";
	    while(f.hasNext()){
		s+=f.nextLine();
		s+="\n";
	    }
	    System.out.println(s);

	    String lines[] = s.split("\n");
	    map     = new char[rows][cols];

	      for(int i =0 ; i<map.length-1; i++){
		for(int j = 0; j<map[0].length; i++){
		    map[i][j]=lines[i].charAt(j);
		}
	        } 
     
	    //	    startR = f.nextInt();
	    //	    startC = f.nextInt();
	    //	    endR = f.nextInt();
	    //	    endC = f.nextInt();
	    

	    

	    

  
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}
	return 0;
    }


    public static void main(String[] args){
	// should be 342144
	//System.out.println(USACO.bronze("makelake.txt");
	System.out.println(USACO.silver("ctravel.txt"));
    }

}
