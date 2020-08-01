package kr.co.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class) 	//Exception.class로 지정하였으므로 
										//모든 예외에 대한 처리가 except()만을 이용해서 처리할 수 있다
										//특정 타입의 예외 다루려면 Exception.class 대신 구체적 예외 클래스지정
	public String except(Exception ex, Model model) {
		
		log.error("Exception....." + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}

}
