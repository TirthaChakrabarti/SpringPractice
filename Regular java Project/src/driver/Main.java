package driver;

import service.Teacher;	
import serviceImplementation.GkTeacher;

public class Main {

	public static void main(String[] args) {
		
		//Create an object of teacher
		//Functionality easily changeable: by changing class, we can get the desired output
		//But the program is not easily configurable as it needs changing core Java classes (not a good practice) 
		
		//Teacher teacher = new HindiTeacher();
		Teacher teacher = new GkTeacher();
		
		//use the object to retrieve the homework of a particular teacher
		System.out.println(teacher.getHomework());	
	}
}
