package serviceImplementation;

import service.ExamTip;
import service.Teacher;

public class HindiTeacher implements Teacher {

	//Defining a private field for dependency
	ExamTip examTip;
	
	//Define constructors for dependency injection
	public HindiTeacher() {
		
	}
	
	public HindiTeacher(ExamTip TheExamTip) {
		this.examTip = TheExamTip;
	}
	
	@Override
	public String getHomework() {
		return "Do one page of Hindi writing";
	}
	
	@Override
	public String getExamTip() {
		return examTip.getExamTip();
	}
	
	//init, destroy methods --> return type always 'void', name can be anything
	//Mainly used for logging purpose
	
	//An init method
	public void doInitialJob() {
		System.out.println("Under the initial method");
		System.out.println();
	}
	
	//A destroy method
	public void doFinalJob() {
		System.out.println();
		System.out.println("Under the destroy method");
	}
}
