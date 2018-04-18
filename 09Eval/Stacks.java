import java.util.*;

public class Stacks{
    private ArrayList<Double> data;

    public Stacks(){
	data = new ArrayList<Double>();
    }

    public void push(Double n){
	data.add(n);
    }

    public double pop(){
	if(data.size()==0){
	    return 0.0;
	}
	return data.remove(data.size()-1);
    }

    public double peek(){
	return data.get(data.size()-1);
    }

    public String toString(){
	return data.toString();
    }

    public static void main(String[] args){
	Stacks test = new Stacks();
	test.push(5.0);
	test.push(1.0);
	test.push(3.0);
	test.push(20.0);
	System.out.println(test.toString());
	System.out.println(test.pop());
	System.out.println(test.toString());
	System.out.println(test.peek());
    }
}
