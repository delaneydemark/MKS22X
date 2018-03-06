import java.util.*;
import java.io.*;


public class USACO{

    public static int bronze(String filename){
	File text = new File(filename);
	Scanner f = new Scanner(text);

	String s ="";
	while(f.hasNextLine()){
	    s+=f.nextLine();
	    s+="\n";
	}

	String lines[] = s.split("\n");
	int elevations[][] = new int[lines.length-3][lines[1].length()];
    }

}
