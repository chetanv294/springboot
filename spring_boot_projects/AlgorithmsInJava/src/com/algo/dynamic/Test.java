package com.algo.dynamic;

public class Test {
public static void main(String[] args) {
 
	Integer[] cell = new Integer[2];
    int[] row = new int[5];
   // int a;
	System.out.println(cell);
	System.out.println(row);
	// System.out.println(a);
	//System.out.println(new Test());
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
	System.out.println("hello");
		//return super.toString();
	return new Test().hashCode()+"";
	}
}
