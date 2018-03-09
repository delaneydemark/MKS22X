import java.util.*;
import java.io.*;


public class USACO{

    public static int bronze(String filename){
	try{

	    File text = new File(filename);
	    Scanner f = new Scanner(text);

	    int rows = f.nexInt();
	    int cols = f.nextInt();
	    int elevation = f.nextInt();
	    int instructions = f.nextInt();
	

	    int elevations[][] = new int[rows][cols];

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
	
    }

    public static void bronzeH(int upperR, int upperC, int down){
	int max = 0;
	for(int i = 0; i<3; i++){
	    for(int j = 0; j<3; j++){
		if(upperR+i>=0 && upperR+i<elevations.length &&
		   upperC+j>=0 && upperC+j<elevations[0].length){
		    if(elevations[upperR+i][upperC+j]>max){
			max = elevations[upperR+i][upperC+j];
		    }
		}
	    }
	}
    }

    public static int silver(String filename){
	File text = new File(filename);
	Scanner f = new Scanner(text);

	String s ="";
	String first = f.nextLine();
	while(f.hasNextLine()){
	    s+=f.nextLine();
	    s+="\n";
	}

	String lines[] = s.split("\n");
	char map[][] = new char[lines.length-2][lines[1].length()];

	for(int i = 1; i<map.length-1; i++){
	    for(int j = 0; j<map[0].length; i++){
		map[i][j]=lines[i].charAt(j);
	    }
	}

	int startR= Integer.parseInt(lines[lines.length-1].substring(0,1));
	int startC= Integer.parseInt(lines[lines.length-1].substring(2,3));
	int endR= Integer.parseInt(lines[lines.length-1].substring(4,5));
	int endC= Integer.parseInt(lines[lines.length-1].substring(6,7));
	int steps = Integer.parseInt(lines[0].substring(4,5));
    }

}
