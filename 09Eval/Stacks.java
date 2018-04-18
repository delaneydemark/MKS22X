import java.util.*;

public class Stacks{
    private ArrayList<Double> data;

    public Stacks(){
	data = new ArrayList<Double>();
    }

    public void push(Double n){
	data.add(d);
    }

    public double pop(){
	if(data.size()==0){
	    return 0.0;
	}
	return data.remove(data.size()-1);
    }
}
