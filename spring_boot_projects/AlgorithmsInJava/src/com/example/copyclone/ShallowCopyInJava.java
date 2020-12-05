package com.example.copyclone;

public class ShallowCopyInJava {
	public static void main(String[] args)
    {
        Course science = new Course("Physics", "Chemistry", "Biology");
 
        Student student1 = new Student(111, "John", science);
 
        Student student2 = null;
 
        try
        {
            //Creating a clone of student1 and assigning it to student2
 
          //  student2 = (Student) student1.clone();
        	student2 =  student1;
        }
        catch (Exception e) //(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
 
        //Printing the subject3 of 'student1'
 
        System.out.println(student1.course.subject3);         //Output : Biology
        
        //Changing the subject3 of 'student2'
 
        student2.course.subject3 = "Maths";
        //student1.id = 222;
        student2.id = 333;
        //This change will be reflected in original student 'student1'
 
        System.out.println(student1.course.subject3);       //Output : Maths
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1.course.hashCode());
        System.out.println(student2.course.hashCode());
        
        String s1 = new String("ABC");
        String s2 = new String("ABC");
        String s3 = new String("XYZ");
        String s5 = "AB";
      //  s5.intern();
        String s4 =  s5 + "C" ;
       // s4 = s4.intern();
        s1 = s1.intern();
        
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s4 == s1);
    }
}
class Course
{
    String subject1;
 
    String subject2;
 
    String subject3;
 
    public Course(String sub1, String sub2, String sub3)
    {
        this.subject1 = sub1;
 
        this.subject2 = sub2;
 
        this.subject3 = sub3;
    }
}
 
class Student implements Cloneable
{
    int id;
 
    String name;
 
    Course course;
 
    public Student(int id, String name, Course course)
    {
        this.id = id;
 
        this.name = name;
 
        this.course = course;
    }
 
    //Default version of clone() method. It creates shallow copy of an object.
 
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    @Override
    public String toString() {
    	StringBuilder sb =new StringBuilder();
    	sb.append("{id: " + id  + "}, {name : " +name + "}, {course: " + course.subject1 + "," + course.subject2 + "," + course.subject3 + " }");
    	return sb.toString();
    }
}