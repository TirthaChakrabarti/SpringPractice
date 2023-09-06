package serviceImplementation;

import service.ExamTip;
import service.Teacher;

public class MathTeacher implements Teacher {
	
	//Defining a private field for dependency
	ExamTip examTip;
	
	//Define constructors for dependency injection
	public MathTeacher() {
		
	}

	public MathTeacher(ExamTip TheExamTip) {
		this.examTip = TheExamTip;
	}

	@Override
	public String getHomework() {
		return "Practice any ten maths problem";
	}
	
	@Override
	public String getExamTip() {
		return examTip.getExamTip();
	}	
}
