import java.util.*;
import java.io.*;


public class USACO{

    public static int bronze(String filename){
	try{

	    File text = new File(filename);
	    Scanner f = new Scanner(text);

	    String s ="";
	    String instructions= f.nextLine();
	    while(f.hasNextLine()){
		s+=f.nextLine();
		s+="\n";
	    }

	    String lines[] = s.split("\n");
	    int elevations[][] = new int[lines.length-2][lines[0].length()];

	    for(int i = 0; i<elevations.length; i++){
		String row[] = lines[i].split(" ");
		for(int j = 0; j<elevations[i].length; j++){
		    map[i][j]=Integer.parseInt(row[j]);
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
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
