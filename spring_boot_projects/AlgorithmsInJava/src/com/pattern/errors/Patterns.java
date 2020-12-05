package com.pattern.errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {	
	
	/*private Pattern pattern;
	  private Matcher matcher;

	  private static final String PASSWORDPATTERN =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	  public void PatternMatcher(){
		  pattern = Pattern.compile(PASSWORDPATTERN);
	  }

	  public boolean validate(final String password){     
		 
		  matcher = pattern.matcher(password);
		  return matcher.matches();

	  }
	  
	   boolean match(String regex, String value){
			String newValue;
			 
			newValue = value;		 
			 
	    	pattern = Pattern.compile(regex,Pattern.UNICODE_CHARACTER_CLASS);
	    	 
	    	matcher = pattern.matcher(newValue);
	    	return matcher.matches();
		}*/
	   
	   public static void main(String[] args) {
		 //  Patterns ptr = new Patterns();
		//    System.out.println( ptr.match("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",  "kmkm12@"));
		    
		    
		    /** **/
		   /* String regex   = "[a-z]@.";
		    String str = "abc@yahoo.com,123@cnn.com,abc@google.com";*/
		   /* String regex = "\\w+";
		    String str = "asdf Java2s.com";*/
		    
		    /*String regex = "[^0-9]*[12]?[0-9]{1,2}[^0-9]*";
		    String str = "299";*/
		    
		    //String regex = "\bdog\b";//".*\b(one|two|three)\b.*$" ; String str = "The dog plays in the yard.";
		    // "^(?=.*?\bone\b)(?=.*?\btwo\b)(?=.*?\bthree\b).*$";
		    // * for {0,} 
		   // + for {1,}
		   //? {0,1}
		   //String regex   = "^/*(\\b.+\\s+)[(AND|OR)]+(\\s+.*\\b)/*$";
		   //String regex   = "^/*((\\b.+\\s+)[(AND|OR)](\\s+.*\\b))$";
		  // String regex   = "^/*(\\b.+\\s+)(AND|OR)$";
		 //  String regex   = "(\\b\\s+)(AND|OR)(\\s+\\b)";  String str = "col1=abs(column1)   AND abcd  OR abcd AND abcd AND";
		  // String regex   = "^[\\_$\\w://]{1,10}$";
		  // String str = "/d/_/_d/___";
//		   String regex   = "(\\s+AND|OR\\s+)";
//		   String regex   = "\\b(\\s*(AND|OR)\\s*)";  String regex   = "^[^\\d].*";
		   /**
		    * ^(http|https|ftp):[\/]{2}([a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,4})(:[0-9]+)?\/?([a-zA-Z0-9\-\._\?\,\'\/\\\+&amp;%\$#\=~]*)
		    * 
		    * <([\w]+).*>(.*?)<\/\1>
		    * \b(\w+)\b(?=.*\1)
		    * ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,12}$
		    * **/
		   String regex   = "((\\w+[^(AND\\s+)])\\s*)";  // (\\s*(AND|OR)\\s*)		   
		   regex = "\\b(\\w+)\\s+\\1\\b";
		   regex = "[^0-9]*[12]?[0-9]{1,2}[^0-9]*"; //^(?=.*?\bone\b)(?=.*?\btwo\b)(?=.*?\bthree\b).*$		 
		   String str = " ";//"AN xyxz AN abcd AN";// OR abcd AND xyz OR xvc OR";
		   regex = "\\b(\\w+)\\s+\\1\\b";
		   str = "word1 is copy  endl kline copy .";
		   
		   regex = "(.*)";
		   regex = "^(?=.*?(\\s+(AND)\\s+)).*$";
		  // regex = "^(?=(\\w+\\s+(AND)\\s+))*$"; //^(?=.*?\bmust-have\b)(?=.*?\bmandatory\b)((?!avoid|illegal).)*$
		   
		   regex = "^(?=.*?(\\b(AND)\\b))*$";
		   
		   //"(\\w+)(?=(([&])\\s*)\\w+)*";
		   regex = "(\\w+)( &\\s*\\w+)*";  //"(\\w+)(,\\s*\\w+)*";
		   //correct//"(\\w+)(( &| \\|)\\s*\\w+)*"
		   
		   //((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})
		   regex = "(\\w+([=><])*\\w+([a-z\\(\\)]))(( &| \\|)\\s*\\w+)*";  //"(\\w+)(,\\s*\\w+)*";
		  // regex = "[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':]";
		   //regex = "^(http|https|ftp):[\/]{2}([a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,4})(:[0-9]+)?\/?([a-zA-Z0-9\-\._\?\,\'\/\\\+&amp;%\$#\=~]*)";
		   
		   regex = "q(?=u)";
		   str = "colum2=copy(columnas) & thosethis | noline | theme";
		   
		  // regex= "\\b\\w+(?<=s)\\b";
		  // regex = "(?<=USD)\\d{3}";
		 //  str = "USD100";
		   
		   regex = "grey(?=hound)";
		   str= "i left my grey socks at the greyhound";
	//	   System.out.println(str.matches(regex) );
				   
		    Pattern p  = Pattern.compile(regex);//Pattern.compile(regex,Pattern.UNICODE_CHARACTER_CLASS);		    
		    
		    Matcher  m   = p.matcher(str);
		//    System.out.println(m.matches());
	//	    System.out.println(m.lookingAt());
		    
		    while (m.find())  {
		        String  foundStr = str.substring(m.start(),  m.end());
	//	        System.out.println("Found string  is:" + foundStr + "-->"+ m.group(0)  );
		      }
		    
		String nsrt =    str.replaceAll(regex, "<____>");
		//System.out.print( nsrt );
		
		mainno_1(); 
	}
	   
	   public static void mainno_1( ) {
		   //^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,12}$
		   //^[A-Za-z][A-Za-z0-9]*(?:_[A-Za-z0-9]+)*$
		   
		  String   regex = "^[A-Za-z]+[A-Za-z0-9]*(_[A-Za-z0-9]+)*$";
		  String str= "saa1_9";	/**  my grey socks at the greyhound"; **/
		  
		  regex = "(?=^.{1,10}$)^([A-Za-z]+[A-Za-z0-9]*(_[A-Za-z0-9]+)*)$";
		  str= "s_aa1_6@@@";
		  
		  regex = "^[A-Za-z].{1,10}$";
		  str= "a@#$%^&123";
		  
		  regex = "^(?=^.{1,10}$).*([A-Z]|[a-z]|[0-9]).*$"; 
		  str= "!@#$%^1&*(";
		  
		  regex = "^(?=^.{1,500}$).*([A-Z]|[a-z]|[0-9]).*"; 	// previous regex for ASN1ParserMapping.recMainAttribute
		  str= "!@#$%^1&*(";
		/**  ([a-zA-Z_$][a-zA-Z\d_$]*\.)*[a-zA-Z_$][a-zA-Z\d_$]*
		  fully qualified java class name
		  **/
		  regex = "^([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*$"; 
		  str= "$a.$1.$a1a_.cabc";
		  str="abc";
		  
		/**  String str1="kiran kumar kk";
		  //String regex1= "((w+)_(w+)_(w+)) \3,\2,\1";
		  String regex1= "(\b\b\b) 3,2,1";
		  String replace= "\\3, \\2, \\1";
		  System.out.println( "regex swaped : " + str1.replaceAll(regex1, str1));  **/
		  
		  
		   System.out.println(str.matches(regex) );
				   
		    Pattern p  = Pattern.compile(regex); /** Pattern.compile(regex,Pattern.UNICODE_CHARACTER_CLASS);	**/	    
		    
		    Matcher  m   = p.matcher(str);
		    System.out.println(m.matches());
		    System.out.println(m.lookingAt());
		    
		    if (m.find()) {
		        for (int i = 0; i <= m.groupCount(); i++) {
		        System.out.println("------------------------------------");
		        System.out.println("Group " + i + ": " + m.group(i));
		        }
		    }
		    
		  /**  while (m.find())  {		    
		        String  foundStr = str.substring(m.start(),  m.end());
		        System.out.println("Found string  is:" + foundStr + "-->"+ m.group(0)  );
		      } **/
		    
		String nsrt =    str.replaceAll(regex, "<____>");
		System.out.print( nsrt );
		
		
		
	   }

	   public static void mainno( ) {
		   
		     final String REGEX = "\\bcat\\b";
		     final String INPUT = "cat cat cat cattie cat";
		   
	      Pattern p = Pattern.compile(REGEX);
	      Matcher m = p.matcher(INPUT);   // get a matcher object
	      int count = 0;
	      
	      System.out.println("\n\n"+m.lookingAt());
	      
	      while(m.find()) {
	    	
	         count++;
	         System.out.println("Match number "+count);
	         System.out.println("start(): "+m.start());
	         System.out.println("end(): "+m.end());
	      }
	      
	   }
	   
	   
}
class $Abc$bc {
	
}