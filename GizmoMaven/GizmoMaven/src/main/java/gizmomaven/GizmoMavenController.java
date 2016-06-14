package gizmomaven;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GizmoMavenController {

	
	@RequestMapping(value={"/","gotoindex"})
	public String loadIndexPage()
	{
		return "index";
	}
	 
	@RequestMapping("/aboutus")
	public String loadAboutusPage()
	{
		return "aboutus";
	}
	@RequestMapping("/signup")
	public String loadSignUpPage()
	{
		return "signup";
	}
	@RequestMapping("/Contact")
	public String loadContactPage()
	{
		return "Contact";
	}
	
}
