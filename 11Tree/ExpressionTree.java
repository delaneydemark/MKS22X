public class ExpressionTree{

    private char op;
    private double value;
    private ExpressionTree left,right;

    public ExpressionTree(double value){
	this.value = value;
	op = '~';
    }

    public ExpressionTree(char op, ExpressionTree l, ExpressionTree r){
	this.op = op;
	left = l;
	right = r;
    }

    public char getOp(){
	return op;
    }

    private double getValue(){
	return value;
    }

    private ExpressionTree getRight(){
	return right;
    }

    private ExpressionTree getLeft(){
	return left;
    }

    private boolean isOp(){
	return hasChildren();
    }

    private boolean isValue(){
	return !hasChildren();
    }

    private boolean hasChildren(){
	return left!=null && right!=null;
    }

    public String toString(){
	String s = "(";
	
    }

    public String toStringPostfix(){
	if(isValue()){
	    return "" + getValue() + " ";
	    
	}
	return "" + getLeft().toStringPostfix() + getRight().toStringPostfix() + getOp() + " ";
    }

    public String toStringPrefix(){
    }

    public double evaluate(){
	if(isValue()){
	    return getValue();
	}
	return apply(getOp(), getLeft().evaluate(), getRight.evaluate());
    }

    private double apply(char op, double a, double b){
	if(op=='+'){
	    return a+b;
	}else if(op=='-'){
	    return a-b;
	}else if(op=='*'){
	    return a*b;
	}else if(op=='/'){
	    return a/b;
	}
	return 0.0;
    }
}
