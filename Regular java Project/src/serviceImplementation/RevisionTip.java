package serviceImplementation;

import org.springframework.stereotype.Component;

import service.ExamTip;

@Component
public class RevisionTip implements ExamTip {

	@Override
	public String getExamTip() {
		return "Do a lot of revision";
	}
}
