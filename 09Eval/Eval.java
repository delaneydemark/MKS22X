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
		double num = Double.parseDouble(tokens[i]);
		expression.push(num);
	    }
	}
	return expression.peek();
    }

    public static void main(String[] args){
	System.out.println(Eval.eval("10 2.0 +"));
	System.out.println(Eval.eval("11 3 - 4 + 2.5 *"));
	System.out.println(Eval.eval("8 2 + 99 9 - * 2 + 9 -"));
    }
   
}
