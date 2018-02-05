public class Recursion{
	
	public static void main(String[] args){
		System.out.println(fact(0));
		System.out.println(fact(1));
		System.out.println(fact(2));
		System.out.println(fact(3));
	}

	public int fact(int n){
		if (n<0){
			throw new IllegalArgumentException();
		}
		if (n==0){
			return 1;
		}
		else{
			return n * fact(n-1);
		}
	}
}
