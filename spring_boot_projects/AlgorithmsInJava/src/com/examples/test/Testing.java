package com.examples.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Testing {
    public static void main(String[] args) throws Exception
     { 
    	\u000a
         // the line below this gives an output
         // \u000d System.out.println("comment executed");
    	
    	/** Set<Testing> vset = new HashSet<Testing>();
    	Testing test = new Testing();
    	Testing test1 = new Testing();
    	
    	System.out.println( test.hashCode() );
    	try{
    	System.out.println(vset.add( test )); 
    	System.out.println(vset.add( test ));
    	System.out.println(vset.add( test1 ));
    	
    	Iterator itr = vset.iterator();
    	while( itr.hasNext() ){
    		System.out.println( itr.next().hashCode() );
    	  }
    	}
    	catch(Exception ex){
    		System.out.println( "Errror : " + ex );
    	}
    	System.exit(0);*/
    	
    	Vector<Integer> vr = new Vector<Integer>();
    	
    	vr.add(1);
    	vr.add(2);
    	vr.add(3);
    	vr.add(4);
    	vr.add(5);
    	vr.add(6);vr.add(6);vr.add(6);
    	vr.add(6);vr.add(6);vr.add(6);
    	
    	/** int min = Integer.MAX_VALUE, min_index_test=-1;int a=20,b=1+a,c = 10;
    	System.out.println("min : " + min + " :min_index : " + (min_index_test + a + b + c)); **/
    	/*System.out.println(vr.capacity());
    	
    	System.out.println(vr.size());*/
    	//System.out.println(Singleton.getInstance());
    	 // System.out.println("\1");
    	
    	    /*for(int a=0;a < 10 ;a++) 
    	    	
    	      if(a==5){
    	    	   System.out.println("a" + a);
    	    	  for(int b=0;b < 10 ;b++)
    	    		 
    	    	 	 System.out.println("b");
    	    	     System.out.println("X");
    	    	}*/
    	
    	/*if(false || true){
    		System.out.println("OR");
    	}
    	if(false && true){
    		System.out.println("AND");
    	}*/
    	
    	//recursiveStackLIFO(1);   
    	
    	coversion();
     }
    
    /** ArrayList to LinkedList **/
    public static void coversion(){
    	
    	System.out.println( Integer.MAX_VALUE );
    	
    	//LinkedList arl  = new LinkedList();
    	
    	
    	List al  = new ArrayList();
    	
    	al.add("Amit");  
    	al.add("Vijay");  
    	al.add("Kumar");  
    	al.add(1,"Sachin");  
    	
    	List linkls = new LinkedList();
    	
    	linkls.addAll( al );
    	
    	System.out.println( al );
    	System.out.println( linkls );
    }
    
    public static void recursiveStackLIFO(int n) throws Exception
    {
    	++n;
    	//while(n < 3){
    	if(n < 4){
    		System.out.println("before :n= " + n);
    		Thread.sleep(100);
    		recursiveStackLIFO(n);
    	
    		System.out.println("\n child :n= " + n);
    		/*recursiveStackLIFO(n);
        	
    		System.out.println("after :n= " + n);*/    		 
    	}
    }
     
}

class Singleton
{
	private static Singleton obj= new Singleton();
 
    // private constructor to force use of
    // getInstance() to create Singleton object
    private Singleton() {
    	//System.out.println(obj);
    }
 
    public static Singleton getInstance()
    {
    	System.out.println(obj);
        if (obj==null)
        	obj = new Singleton();
        return obj;
    }
    
    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();

        } 
        catch (CloneNotSupportedException e) 
        {
            e.printStackTrace();
            
        }
        return clone;  
    }
}
class Animal {
    public String identifyMyself()  {
        return "I am a Animal.";
    }
    
    public String identifyMyself_1() throws Exception {
        return "I am a Animal - 1.";
    }
    
    public String identifyMyself_2(){
        return "I am a Animal - 2.";
    }
    
    public String identifyMyself_3() throws RuntimeException  {
        return "I am a Animal - 3.";
    }
}
class Horse extends Animal{
   /* public String identifyMyself() throws ClassNotFoundException  {
        return "I am a horse.";
    }*/
	public String identifyMyself_2(){
        return "I am a Animal - 2.";
    }
	public String identifyMyself_3() {
        return "I am a Animal - 3.";
    }
}
class Cat extends Animal{
    public String identifyMyself() throws RuntimeException {
        return "I am a cat.";
    }
    
    public String identifyMyself_1() {
        return "I am a cat.";
    }
    
   /* public String identifyMyself_2() throws Exception {
        return "I am a Animal - 2.";
    }*/
    public String identifyMyself_3() throws RuntimeException  {
        return "I am a Animal - 3.";
    }
}
/***
 class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

 interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

 interface Mythical {
	 int a,b,c;
	 Mythical(){
		 
	 }
    default public String identifyMyself() {
    	a=0;
        return "I am a mythical creature.";
    }
}

 class Pegasus extends Horse implements Flyer, Mythical {
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
} ***/
