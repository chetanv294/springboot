package com.pattern.decorator;

  
 public class SimpleWindow implements Window {
    @Override
    public void draw() {
        // Draw window
    }
    @Override
    public String getDescription() {
    	System.out.println("simple window");
        return "simple window";
    }
}