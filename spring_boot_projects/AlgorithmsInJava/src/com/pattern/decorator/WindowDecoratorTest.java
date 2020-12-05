package com.pattern.decorator;

//import static org.junit.Assert.assertEquals;
import com.pattern.decorator.VerticalScrollBarDecorator;
//import org.junit.Test;

public class WindowDecoratorTest {
	//@Test
	public void testWindowDecoratorTest() {
	    Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
      	    // assert that the description indeed includes horizontal + vertical scrollbars
      /*      assertEquals("simple window, including vertical scrollbars, including horizontal scrollbars", 
            		decoratedWindow.getDescription());*/
	}
}