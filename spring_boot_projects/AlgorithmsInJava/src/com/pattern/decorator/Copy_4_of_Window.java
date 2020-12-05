package com.pattern.decorator;

public interface Copy_4_of_Window {
  
}
//abstract decorator class - note that it implements Window
abstract class WindowDecorator implements Window {
 protected Window windowToBeDecorated; // the Window being decorated

 public WindowDecorator (Window windowToBeDecorated) {
     this.windowToBeDecorated = windowToBeDecorated;
 }
 @Override
 public void draw() {
     windowToBeDecorated.draw(); //Delegation
 }
 @Override
 public String getDescription() {
     return windowToBeDecorated.getDescription(); //Delegation
 }
}

//The first concrete decorator which adds vertical scrollbar functionality
class VerticalScrollBarDecorator extends WindowDecorator {
 public VerticalScrollBarDecorator (Window windowToBeDecorated) {
     super(windowToBeDecorated);
 }

 @Override
 public void draw() {
     super.draw();
     drawVerticalScrollBar();
 }

 private void drawVerticalScrollBar() {
     // Draw the vertical scrollbar
 }

 @Override
 public String getDescription() {
     return super.getDescription() + ", including vertical scrollbars";
 }
}

//The second concrete decorator which adds horizontal scrollbar functionality
class HorizontalScrollBarDecorator extends WindowDecorator {
 public HorizontalScrollBarDecorator (Window windowToBeDecorated) {
     super(windowToBeDecorated);
 }

 @Override
 public void draw() {
     super.draw();
     drawHorizontalScrollBar();
 }

 private void drawHorizontalScrollBar() {
     // Draw the horizontal scrollbar
 }

 @Override
 public String getDescription() {
     return super.getDescription() + ", including horizontal scrollbars";
 }
}