package com.algo.backtracking;

public class Fibonacci {

	 public static void main(String[] args) {
		System.out.println(new Fibonacci().fibo(4));
	}
	 
	 int fibo(int n) {
		if(n <=0)
		{
			return 0;
		}
		if(n ==1)
		{
			return 1;
		}
		System.out.print(" ,fn="+n);
		int a = fibo(n-1);
		System.out.println(" ,p1");
		System.out.print(" ,sn="+n);
		int b= fibo(n-2);
		System.out.println(" ,p2");
		 return a + b;
	 }
}
