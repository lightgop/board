package kr.co.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.domain.SampleDTO;
import kr.co.domain.SampleDTOList;
import kr.co.domain.TodoDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
//	}
	
	@RequestMapping("")
	public void basic() {
		
		log.info("basic................");
	}
	
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {

		log.info("basic get...................");
		
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {

		log.info("basic get only get...................");

	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {

		log.info("" + dto);

		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {

		log.info("name: " + name);
		log.info("age: " + age);

		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

		log.info("ids: " + ids);

		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {

		log.info("array ids: " + Arrays.toString(ids));

		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {

		log.info("list dtos: " + list);

		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto :" + dto);
		log.info("page: " + page);
		
		return "/sample/ex04";
	}

}
