package serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import service.ExamTip;
import service.Teacher;

@Component("Harshit") //Customized name
@Scope("prototype")
public class CSTeacher implements Teacher{
	
	ExamTip examTip;

	public CSTeacher() {

	}
	
	@Autowired
	public CSTeacher(@Qualifier("solvePreviousYearsPaper")ExamTip TheExamTip) {
		this.examTip = TheExamTip;
	}	

	@Override
	public String getHomework() {
		return "Practice Java Spring framework";
	}

	@Override
	public String getExamTip() {
		return examTip.getExamTip();
	}

}
