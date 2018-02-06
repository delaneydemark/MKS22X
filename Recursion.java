public class Recursion{
	
	public static void main(String[] args){
		//System.out.println(fact(0));
		//System.out.println(fact(1));
		//System.out.println(fact(2));
		//System.out.println(fact(3));
		// 0
		System.out.println(fib(0));
		// 1
		System.out.println(fib(1));
		// 1
		System.out.println(fib(2));
		// 2
		System.out.println(fib(3));
	}

	public int fact(int n){
		if(n<0){
			throw new IllegalArgumentException();
		}
		if(n==0){
			return 1;
		}
		else{
			return n * fact(n-1);
		}
	}
	
	public static int fib(int n){
		if(n<0){
			throw new IllegalArgumentException();
		}
		return fibHelper(0, 1, n);
	}
	
	public static int fibHelper(int other, int sum, int n){
		if(n==0){
			return sum;
		}
	/*if(n==1){
			return 1;
		}*/
		return fibHelper(sum, other + sum, n-1); 
	}
}