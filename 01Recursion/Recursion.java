import java.lang.*;

public class Recursion{
	/*
	public static void main(String[] args){
		System.out.println(fact(0));
		System.out.println(fact(1));
		System.out.println(fact(2));
		System.out.println(fact(3));
		
		// 0
		System.out.println(fib(0));
		// 1
		System.out.println(fib(1));
		// 1
		System.out.println(fib(2));
		// 2
		System.out.println(fib(3));
		
		// 0
		System.out.println(sqrt(0));
		// ~1
		System.out.println(sqrt(1));
		// ~2
		System.out.println(sqrt(4));
		// ~3
		System.out.println(sqrt(9));
		// ~4
		System.out.println(sqrt(16));
	}
	*/

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
	
	public int fib(int n){
		if (n<0){
			throw new IllegalArgumentException();
		}
		if(n<2){
			return n;
		}
		return fibHelper(0, 1, n);
	}
	
	public static int fibHelper(int other, int sum, int n){
		if (n==0){
			return other;
		}
		return fibHelper(sum, other + sum, n-1);
	}
	
	
	public double sqrt(double n){
		if (n<0){
			throw new IllegalArgumentException();
		}
		if (n==0){
			return 0;
		}
		double guess = n/2;
		return sqrtHelper(guess, n);
	}
	
	public static double sqrtHelper(double guess, double n){
		double error = Math.abs(((guess * guess - n) / n));
		if(error < 0.000000000000001){
			return guess;
		}
		guess = (n / guess + guess) / 2;
		return sqrtHelper(guess, n);
	}
	
	
}
