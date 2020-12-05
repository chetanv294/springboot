package com.pattern.errors;



public class RefByOrValueBy {
	
    
    private static void foo(String bar) {
	    bar = null;
	}
    
    
    public static void main(String[] args) {
    	String baz = "Hah!";
        foo(baz);
        System.out.println("baz : " + baz);
	}
}
