package serviceImplementation;

import service.ExamTip;
import service.Teacher;

public class GkTeacher implements Teacher {
	
	//Defining a private field for dependency
	ExamTip examTip;
	
	//Define constructors for dependency injection
	public GkTeacher() {
		
	}

	public GkTeacher(ExamTip TheExamTip) {
		this.examTip = TheExamTip;
	}

	@Override
	public String getHomework() {
		return "Read current affairs";
	}
	
	@Override
	public String getExamTip() {
		return examTip.getExamTip();
	}

}
