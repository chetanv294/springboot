package com.pattern.errors;


import java.lang.reflect.Constructor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	 private Pattern pattern;
	  private Matcher matcher;

	  private static final String PASSWORDPATTERN =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	  public PatternMatcher(){
		  pattern = Pattern.compile(PASSWORDPATTERN);
	  }

	  /**
	   * Validate password with regular expression
	   * @param password password for validation
	   * @return true valid password, false invalid password
	   */
	  public boolean validate(final String password){

		  matcher = pattern.matcher(password);
		  return matcher.matches();

	  }
	  
	  public static void main(String[] args) throws Exception{
		  
		  System.out.println( new PatternMatcher().validate("kmkm12@"));
	  Object obj =	Class.forName("com.pattern.errors.PatternMatcher").newInstance();
	  PatternMatcher objj = (PatternMatcher) obj;
	  System.out.println(objj.validate("kmkmG$$"));
	  
	/*  PatternMatcher anotherObject = new PatternMatcher();
	  PatternMatcher object = (PatternMatcher) anotherObject.clone();	  
	  PatternMatcher emp2 = PatternMatcher.class.newInstance();
	  Constructor<PatternMatcher> constructor = PatternMatcher.class.getConstructor();
	  PatternMatcher emp3 = constructor.newInstance();*/
	  
	}
}
