public class Eval{
    public static double eval(String nums){
	Stacks expression = new Stacks();
	String[] tokens = nums.split(" ");
	for(int i = 0; i<tokens.length; i++){
	    if(tokens[i].equals("+")){
		expression.push(expression.pop() + expression.pop());
	    }else if(tokens[i].equals("-")){
		expression.push(-1*(expression.pop() - expression.pop()));
	    }else if(tokens[i].equals("*")){
		expression.push(expression.pop() * expression.pop());
	    }else if(tokens[i].equals("/")){
		expression.push((1/expression.pop()) * expression.pop());
	    }else if(tokens[i].equals("%")){
		double current = expression.pop();
		expression.push(expression.pop() % current);
	    }else{
		expression.push(tokens[i]);
	    }
	}
    }
}
