package com.ToDo.todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {
	
	@Autowired
	private TodoService service;
	
	@RequestMapping(value="/list-todos" ,method= RequestMethod.GET)
	public String ShowLogin(ModelMap modal)
	{
		modal.addAttribute("todo", service.retrieveTodos("yash"));
		return "list-todos";
	}


}
