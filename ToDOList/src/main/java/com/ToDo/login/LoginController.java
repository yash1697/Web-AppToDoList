package com.ToDo.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/login" ,method= RequestMethod.GET)
	public String ShowLogin()
	{
		return "login";
	}
	
	@RequestMapping(value="/login" ,method= RequestMethod.POST)
	public String HandleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model)
	{
		boolean a = service.validateUser(name, password);
		if(a)
		{
		model.put("name", name);
		model.put("pass", password);
		return "welcome";
		}
		else
		{
			String msg = "Dummy thats not it";
		model.put("errorMessage",msg);
			return "login";
		}
	}
	

}
