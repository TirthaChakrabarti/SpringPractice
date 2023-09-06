package serviceImplementation;

import org.springframework.stereotype.Component;

import service.ExamTip;

@Component
public class SolvePreviousYearsPaper implements ExamTip{

	@Override
	public String getExamTip() {
		return "Solve last 5 years question papers";
	}

}
